package com.example.controllers;

import com.example.models.RegisterObject;
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

}
