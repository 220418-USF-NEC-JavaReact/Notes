import React, {useState, useEffect} from 'react';

import {IPost} from "../../Interfaces/IPost";

import './Post.css';

export const Post:React.FC<IPost> = (post:IPost) => {

    const [dateString, setDateString] = useState("");

    useEffect(() => {
        if(post.postedDate){
            let d = new Date(post.postedDate);
            setDateString(d.toUTCString());
        }
    }, [post]);

    return(
        <div className="post">
            <h2>{post.postUser.firstName} {post.postUser.lastName}</h2>
            <p>{post.content}</p>
            <p>{dateString}</p>
        </div>
    )

}