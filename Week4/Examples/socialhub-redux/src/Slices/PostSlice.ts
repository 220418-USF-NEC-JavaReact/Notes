import {createSlice, createAsyncThunk} from  "@reduxjs/toolkit";
import axios from "axios";
import {IPost} from "../Interfaces/IPost";

interface PostSliceState{
    loading: boolean,
    error: boolean,
    posts?: IPost[]
}

const initialPostState: PostSliceState = {
    loading: false,
    error: false
};

export const getPosts = createAsyncThunk(
  "posts/get",
  async (userId:number, thunkAPI) => {
      try{
          const res = await axios.get(`http://localhost:8000/posts/following/${userId}`);

          return res.data;
      } catch (e){
          console.log(e);
      }
  }  
);

export const createPost = createAsyncThunk(
    "posts/create",
    async (newPost:IPost, thunkAPI) => {
        try{
            let post: IPost = {
                postId: 0,
                content: newPost.content,
                postedDate: newPost.postedDate
            }
            const res = await axios.post(`http://localhost:8000/post?user=${newPost.postUser?.userId}`, post);

            let ret:IPost = {
                postId: res.data.postId,
                content: res.data.content,
                username: newPost.postUser?.username,
                postedDate: res.data.postedDate
            }

            return ret;
        } catch (e){
            console.log(e);
        }
    }
)

export const PostSlice = createSlice({
    name: 'posts',
    initialState: initialPostState,
    reducers: {
        clearPosts: (state) => {
            state.posts = undefined
        }
    },
    extraReducers: (builder) => {
        builder.addCase(getPosts.pending, (state, action)=> {
            state.loading = true;
        });

        builder.addCase(getPosts.fulfilled, (state, action) => {
            state.posts = action.payload;
            state.loading = false;
            state.error = false;
        });

        builder.addCase(getPosts.rejected, (state, action) => {
            state.error = true;
            state.loading = false;
        });
        builder.addCase(createPost.fulfilled, (state, action) => {
            if(state.posts && action.payload){
                state.posts = [action.payload, ...state.posts];
            }
        });
    }
});

export const {clearPosts} = PostSlice.actions;

export default PostSlice.reducer;