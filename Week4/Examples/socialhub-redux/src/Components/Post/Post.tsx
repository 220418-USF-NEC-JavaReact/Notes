import React from 'react';

import { IPost } from '../../Interfaces/IPost';

import './Post.css';
import defaultImage from "../../deafultpic.jpg";

export const Post:React.FC<IPost> = (post:IPost) => {

    return(
        <div className="post">
            <div className="post-profile">
                <img className="post-image" src={defaultImage} />
                <h3 className="post-user">{post.postUser.firstName} {post.postUser.lastName}</h3>
            </div>

            <div className="post-content">
                <p>{post.content}</p>
            </div>
        </div>
    )

}