import React, {useState, useEffect} from 'react';

import { useDispatch, useSelector } from 'react-redux';
import { AppDispatch, RootState } from '../../Store';
import { createPost } from '../../Slices/PostSlice';

import pic from '../../deafultpic.jpg';
import { IPost } from '../../Interfaces/IPost';

import './CreatePost.css';

export const CreatePost: React.FC = () => {

    const [content, setContent] = useState<string>("");

    const currentUser = useSelector((state:RootState)=> state.user.user);
    const dispatch:AppDispatch = useDispatch();

    const handleChange = (event:React.ChangeEvent<HTMLTextAreaElement>) => {
        setContent(event.target.value);
    }


    const handlePost = () => {

        let d = new Date();

        if(currentUser){
            let post:IPost = {
                postId: 0,
                content,
                postedDate: d,
                postUser: currentUser
            }

            dispatch(createPost(post));
        }
    }

    useEffect(() => {
        console.log(content);
    }, [content])

    return(
        <div className="create-container">
            <div className="content-container">
                <img className="create-profile-pic" src={pic} />
                <textarea className="content" onChange={handleChange} placeholder="Create a new post" maxLength={256}></textarea>
            </div>
            <button className="create-btn" onClick={handlePost}>Send New Post</button>
        </div>
    )

}