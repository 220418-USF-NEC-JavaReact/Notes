package com.example.services;

import com.example.dao.IPostDao;
import com.example.models.Post;
import com.example.models.User;

import java.sql.Date;
import java.time.Instant;
import java.util.List;

public class PostService {

    private IPostDao pd;

    public PostService(IPostDao pd){
        this.pd = pd;
    }

    public void addPost(String content, User u){

        Date d = new Date(Instant.now().toEpochMilli());

        Post p = new Post(0, d, content, u);

        pd.createPost(p);

    }

    public List<Post> getAllUsersPosts(int id){
        return pd.readPostByUser(id);
    }

}
