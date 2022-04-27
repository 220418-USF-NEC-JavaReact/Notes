package com.example.services;

import com.example.dao.IUserDao;
import com.example.models.User;

public class UserService {

    private IUserDao id;

    public UserService(IUserDao id){
        this.id = id;
    }

    //Typically when we create a user in a application, we are registering it
    public void registerUser(String first, String last, String email, String password){
        User register = new User(0, first, last, email, password);
        id.createUser(register);
    }


}
