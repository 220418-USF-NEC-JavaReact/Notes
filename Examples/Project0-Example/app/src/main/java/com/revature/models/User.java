package com.revature.models;

import java.util.List;
import java.util.ArrayList;
import java.util.Set;
import java.util.HashSet;

public class User{

    private int id;
    private String first;
    private String last;
    private String email;
    private String username;
    private String password;
    private List<Post> posts;
    private Set<User> followers;
    private Set<User> following;

    public User(){

        posts = new ArrayList<>();
        followers = new HashSet<>();
        following = new HashSet<>();

    }

    //We could create an all args, but I know we don't really need it, so i am going to be
    //lazy and create the constructor that I know I need
    public User(String first, String last, String username, String email, String password){
        this.first = first;
        this.last = last;
        this.email = email;
        this.username = username;
        this.password = password;
        this.posts = new ArrayList<>();
        this.followers = new HashSet<>();
        this.following = new HashSet<>();
    }


    


}