import {createSlice, createAsyncThunk} from  "@reduxjs/toolkit";
import axios from "axios";
import { Post } from "../Components/Post/Post";
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
  async (thunkAPI) => {
      try{
          axios.defaults.withCredentials = true;
          const res = await axios.get("http://localhost:8000/posts");

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
            axios.defaults.withCredentials = true;
            const res = await axios.post("http://localhost:8000/posts/", newPost);

            return newPost;
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