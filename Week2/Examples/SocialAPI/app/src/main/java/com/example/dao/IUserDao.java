package com.example.dao;

import com.example.models.User;

import java.util.List;

public interface IUserDao {

    //Start out with the most basic crud

    //Create
    public void createUser(User u);

    //Read
    public List<User> readAllUsers();

    //Read
    public User readUserByEmail(String email);

    //Update
    public User updateUser(User u);

    //Delete
    public void deleteUser(User u);

}
