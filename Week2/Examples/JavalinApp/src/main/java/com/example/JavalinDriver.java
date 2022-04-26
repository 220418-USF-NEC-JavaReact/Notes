package com.example;

import com.example.models.LoginInObject;
import com.example.models.Person;
import com.fasterxml.jackson.databind.ObjectMapper;
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

        //Receive user info from the client and parse it with jackson
        server.post("/person", (ctx) -> {
            ObjectMapper mapper = new ObjectMapper();
            Person p = mapper.readValue(ctx.body(), Person.class);
            System.out.println(p);
            //Send back the created user to the client
            ctx.result(mapper.writeValueAsString(p));
        });

        //Lets say that Ethan wants to login
        server.post("/login", (ctx) -> {
            ObjectMapper mapper = new ObjectMapper();
            LoginInObject lo = mapper.readValue(ctx.body(), LoginInObject.class);

            //After we would take that login object, and pass it to some login service
            //Assume we had some login logic, and we successfully logged Ethan in
            Person p = new Person("Ethan", "McGill", lo.email, lo.password, "Associate");

            //We want to keep track that Ethan is logged in
            //Remember, if a session does not exist, getSession will create one
            ctx.req.getSession().setAttribute("loggedIn", true);
            ctx.req.getSession().setAttribute("type", p.getType());
            //You might want to send back the user for frontend use
            ctx.result("User was logged in");
        });

        server.get("/restricted", (ctx) -> {
           //If the session does not exist it will return null
            Boolean loggedIn = (Boolean) ctx.req.getSession().getAttribute("loggedIn");
           if(loggedIn != null && loggedIn){
               String type = (String) ctx.req.getSession().getAttribute("type");
               if(type.equals("Trainer")){
                   ctx.result("Super secret trainer data");
               } else {
                   ctx.status(403);
               }
           } else {
               throw new Exception();
           }

        });

        //We can deal with exceptions
        server.exception(Exception.class, (e, ctx) -> {
            ctx.status(401);
            ctx.result("You must be logged in as a trainer to view this page");
        });

        server.error(403, ctx -> {
            ctx.result("You are not a trainer, go away");
        });


        server.get("/logout", (ctx) -> {
           //We want to get rid of the session
           ctx.req.getSession().invalidate();
           ctx.result("User is no longer logged in");
        });


        //Start the javalin application to listen for HTTP requests
        server.start(8000);

    }

}
