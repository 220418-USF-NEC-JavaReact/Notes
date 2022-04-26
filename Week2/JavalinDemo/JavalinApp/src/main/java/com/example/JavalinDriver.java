package com.example;

import io.javalin.Javalin;

public class JavalinDriver {

    public static void main(String args[]){
        //First step is to setup our javalin app
        Javalin server = Javalin.create(config -> {
            config.enableCorsForAllOrigins();
        });

        //We setup our javalin http handlers with lambdas
        //ctx is that Context Object we talked about in the notes
        //.result sends the HTTP response back to the client
        server.get("/people", (ctx) -> ctx.result("We would send back a list of people with this request"));


        //We can use path parameters to specify a specific resource
        server.get("/person/{id}", (ctx) -> {
            int id = Integer.parseInt(ctx.pathParam("id"));
            ctx.result("We would send back the user with the id of: " + id);
        });

        //we can also use query parameters to specify specific resources
        server.get("/person", (ctx) -> {
           String first = ctx.queryParam("first");
           String last = ctx.queryParam("last");
           ctx.result("We would send back the user with first name: " + first + " and last name: " + last);
        });

        //Start the javalin application to listen for HTTP requests
        server.start(8000);

    }

}
