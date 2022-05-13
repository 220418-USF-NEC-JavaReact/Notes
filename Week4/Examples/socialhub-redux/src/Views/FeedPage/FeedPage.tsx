import React, { ReactNode, useEffect } from 'react';

import { useSelector, useDispatch } from 'react-redux';
import { Navbar } from '../../Components/Navbar/Navbar';
import { RootState, AppDispatch } from '../../Store';
import { useNavigate } from 'react-router-dom';

import { getPosts } from '../../Slices/PostSlice';

import { CreatePost } from '../../Components/CreatePost/CreatePost';
import { Loading } from '../../Components/Loading/Loading';
import { Post } from '../../Components/Post/Post';
import { IPost } from '../../Interfaces/IPost';

import './FeedPage.css';

export const FeedPage: React.FC = () => {

    const userInfo = useSelector((state:RootState) => state.user);
    const posts = useSelector((state:RootState) => state.posts);
    const navigator = useNavigate();
    const dispatch:AppDispatch = useDispatch();

    useEffect(() => {
        //If the user is not logged in, push them to the login page
        if(!userInfo.user){
            navigator("/login");
        }
        //If the user IS logged in, but we have not gotten their posts yet
        else if(userInfo.user && !posts.posts){
            dispatch(getPosts());
        }

        console.log("Userstate: ", userInfo, "Posts: ", posts);
    }, [userInfo, posts.posts]);

    return(
        <div>
            <Navbar />
            <div className="feed-page">
                <CreatePost />
                {posts.posts ? posts.posts.map((post:IPost) => {
                    return <Post {...post} key={post.postId} />
                }) :
                <Loading />
                }
            </div>
        </div>
    )

}