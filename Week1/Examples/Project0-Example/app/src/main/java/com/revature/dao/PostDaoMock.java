package com.revature.dao;

import com.revature.models.Post;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class PostDaoMock implements IPostDao{

    private Map<String, List<Post>> db = MockPostDB.getInstance().getDB();

    @Override
    public List<Post> getPostsByUser(String username) {
        return db.get(username);
    }

    @Override
    public void createPost(Post p) {

        String username = p.getUser().getUsername();

        //We need the preexisting list of posts, if one does not exists create it
        List<Post> posts = db.get(username);

        if(posts != null){
            posts.add(p);
        }else{
            posts = new ArrayList<>();
            posts.add(p);
        }

        //We will update the List of posts in the db
        db.put(username, posts);

    }
}
