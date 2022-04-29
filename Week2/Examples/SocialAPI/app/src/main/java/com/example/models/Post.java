package com.example.models;

import java.sql.Date;

public class Post {

    private int postId;
    private Date postedDate;
    private String content;
    private User postUser;

    public Post() {
    }

    public Post(int postId, Date postedDate, String content, User postUser) {
        this.postId = postId;
        this.postedDate = postedDate;
        this.content = content;
        this.postUser = postUser;
    }

    public Post(int postId, Date postedDate, String content) {
        this.postId = postId;
        this.postedDate = postedDate;
        this.content = content;
    }

    public int getPostId() {
        return postId;
    }

    public void setPostId(int postId) {
        this.postId = postId;
    }

    public Date getPostedDate() {
        return postedDate;
    }

    public void setPostedDate(Date postedDate) {
        this.postedDate = postedDate;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public User getPostUser() {
        return postUser;
    }

    public void setPostUser(User postUser) {
        this.postUser = postUser;
    }

    @Override
    public String toString() {
        return "Post{" +
                "postId=" + postId +
                ", postedDate=" + postedDate +
                ", content='" + content + '\'' +
                ", postUser=" + postUser +
                '}';
    }
}
