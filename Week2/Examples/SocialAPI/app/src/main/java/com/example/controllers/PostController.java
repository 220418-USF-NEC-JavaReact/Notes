package com.example.controllers;

import com.example.models.Post;
import com.example.models.User;
import com.example.services.PostService;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.javalin.http.Handler;

public class PostController {

    private PostService ps;
    private ObjectMapper om;

    public PostController(PostService ps){
        this.ps = ps;
        this.om = new ObjectMapper();
    }

    public Handler handleCreatePost = (ctx) -> {

        //ctx.header("Access-Control-Expose-Headers", "*");

        //First check to see if the use already logged in
        if(ctx.req.getSession().getAttribute("id") == null){
            ctx.status(401);
            ctx.result("You must login to create posts");
        } else {
            int posterId = Integer.parseInt((String) ctx.req.getSession().getAttribute("id"));

            User u = new User();
            u.setUserId(posterId);

            Post p = om.readValue(ctx.body(), Post.class);

            ps.addPost(p.getContent(), u);

            ctx.status(201);
            ctx.result("Post Created");
        }

    };

    public Handler handleGetUserPosts = (ctx) -> {


        ctx.header("Access-Control-Expose-Headers", "*");

        if(ctx.req.getSession().getAttribute("id") == null){
            ctx.status(401);
            ctx.result("You must be logged in to view your posts");
        } else {
            int posterId = Integer.parseInt((String) ctx.req.getSession().getAttribute("id"));

            ctx.result(om.writeValueAsString(ps.getAllUsersPosts(posterId)));
        }

    };

}
