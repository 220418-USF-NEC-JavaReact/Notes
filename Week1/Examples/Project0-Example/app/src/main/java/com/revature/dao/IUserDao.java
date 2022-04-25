package com.revature.dao;

import com.revature.models.User;

import java.util.List;

public interface IUserDao {

    User createUser(User u);
    User getUserByUsername(String username);
    List<User> getAllUsers();

}