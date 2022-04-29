package com.example.controllers;

import com.example.models.LoginObject;
import com.example.models.RegisterObject;
import com.example.models.User;
import com.example.services.UserService;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.javalin.http.Handler;

public class UserController {

    private UserService us;

    private ObjectMapper om;

    public UserController(UserService us){
        this.us = us;
        this.om = new ObjectMapper();
    }

    //Create the implemenation for your handlers inside of Controller classes to clean up your main method
    public Handler handleRegister = (ctx) -> {
        RegisterObject ro = om.readValue(ctx.body(), RegisterObject.class);

        System.out.println(ro);

        us.registerUser(ro.first, ro.last, ro.email, ro.password);
        ctx.status(201);
        ctx.result("Create user");
    };

    public Handler handleLogin = (ctx) -> {
        LoginObject lo = om.readValue(ctx.body(), LoginObject.class);

        User u = us.loginUser(lo.email, lo.password);

        if(u == null){
            ctx.status(403);
            ctx.result("Username or password was incorrect");
        } else {
            //We could also, if the user is logged in successfully, setup a session for them
            ctx.req.getSession().setAttribute("loggedIn", u.getEmail());
            ctx.req.getSession().setAttribute("id", ""+u.getUserId());
            ctx.result(om.writeValueAsString(u));
        }
    };

    public Handler handleUpdateUser = (ctx) -> {
      User u = om.readValue(ctx.body(), User.class);

      System.out.println(u);

      ctx.result(om.writeValueAsString(us.updateUserInfo(u)));
    };

    public Handler handleDeleteUser = (ctx) -> {
        int id = Integer.parseInt(ctx.pathParam("id"));
        User u = new User();
        u.setUserId(id);
        us.deleteUser(u);
        ctx.result("User deleted");
    };

}
