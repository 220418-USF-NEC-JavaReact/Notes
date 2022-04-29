package com.example.dao;

import com.example.models.Post;

import java.util.List;

public interface IPostDao {

    public void createPost(Post p);

    public List<Post> readPostByUser(int id);

}
