/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package com.example;

import io.javalin.Javalin;
import io.javalin.http.staticfiles.Location;

public class App {

    public static void main(String[] args) {

        Javalin app = Javalin.create(config -> {
            config.enableCorsForAllOrigins();
            config.addStaticFiles("/public", Location.CLASSPATH);
        });

        app.post("/login", ctx -> {
            String username = ctx.formParam("username");
            String password = ctx.formParam("password");
            ctx.result(username + " " + password);
        });

        app.start(8080);

    }
}
