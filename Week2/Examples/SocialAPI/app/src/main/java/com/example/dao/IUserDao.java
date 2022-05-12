package com.example.dao;

import com.example.models.User;

import java.util.List;
import java.util.Set;

public interface IUserDao {

    //Start out with the most basic crud

    //Create
    public void createUser(User u);

    //Read
    public List<User> readAllUsers();

    //Read
    public User readUserByEmail(String email);

    //Read
    public User readUserById(int id);

    //Update
    public User updateUser(User u);

    //Delete
    public void deleteUser(User u);

    public void insertFollowing(int followingId, int followerId);

    public Set<User> getFollowing(int id);

    public Set<User> getFollowers(int id);

}
