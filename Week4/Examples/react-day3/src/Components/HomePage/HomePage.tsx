import React, {useEffect, useState} from 'react';
import axios from 'axios';

import { useNavigate } from 'react-router-dom';

import {Post} from '../Post/Post';

import { IUser } from '../../Interfaces/IUser';
import { IPost } from '../../Interfaces/IPost';

export const HomePage: React.FC<IUser> = (user:IUser) => {

    const [posts, setPosts] = useState<IPost[]>([]);

    const navigator = useNavigate();

    const getPosts = async () => {
        axios.defaults.withCredentials = true;
        let res = await axios.get(`http://localhost:8000/posts`);
        setPosts(res.data);
    }

    useEffect(() => {
        //If the firstName is false, this if statement will equate to true
        if(user.userId < 0){
            navigator("/login");
        }
        if(posts.length < 1){
            getPosts();
        }
        console.log(posts);
    }, [posts])

    return (
        /*
            Posts is a list of posts
            .map will loop through every post and do some logic
            In this case post is the current post in the list of posts
        */
        <>
            <h1>Welcome {user.firstName}</h1>
            <h2>Home page view</h2>
            {posts.length < 1 ? <h1>Loading</h1> : posts.map((post:IPost) => {
                console.log("We are here");
                return(
                    <Post {...post}/>
                )
            })}
        </>
    );

}