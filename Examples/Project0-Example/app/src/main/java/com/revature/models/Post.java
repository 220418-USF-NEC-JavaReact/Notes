package com.revature.models;

import java.util.Date;

public class Post {

    private String content;
    private Date timeStamp;
    private User user;

    public Post(){

    }

    public Post(String content, Date timeStamp, User u){
        this.content = content;
        this.timeStamp = timeStamp;
        this.user = u;
    }

    public Post(String content, User u){
        this.content = content;
        this.user = u;
        timeStamp = new Date();
    }

    public String getContent(){
        return content;
    }

    public void setContent(String content){
        this.content = content;
    }

    public Date getTimeStamp(){
        return timeStamp;
    }

    public void setTimeStamp(Date timeStamp){
        this.timeStamp = timeStamp;
    }

    public User getUser(){
        return user;
    }

    public void setUser(User u){
        this.user = u;
    }

    @Override
    public String toString(){
        return "Post:{\n\t"
            + "content: " + content + "\n"
            + "timestamp: " + timeStamp + "\n"
            + "user: " + user + "\n}";
    }

}