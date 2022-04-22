package com.revature.services;

import com.revature.models.User;
import com.revature.dao.IUserDao;
import com.revature.exceptions.UsernameOrPasswordIncorrectException;
import java.util.Collections;
import java.util.List;
import java.util.ArrayList;
import java.util.Set;

public class UserService{

    //Later on we will use dependency injection, to allow an external resource to control
    //or inject which DAO functionality the Userservice will use
    private IUserDao uDao;

    public UserService(IUserDao uDao){
        this.uDao = uDao;
    }

    //We need to thing about the logic behind registering a user
    public void registerUser(String first, String last, String username, String email, String password){
        //Check the database/datastorage to see if the user exists with that username
        //If not, create a new user, and persist them in data storage
        User register = new User(first, last, username, email, password);

        //After we create the user, we would want to call the data access object
        //To store the data in the persistance layer
        uDao.createUser(register);

    }

    //We need a way to retrieve a user with specific username and password from the database
    public User loginUser(String username, String password) throws UsernameOrPasswordIncorrectException{

        User u = uDao.getUserByUsername(username);

        if(uDao.getUserByUsername(username) == null || !password.equals(u.getPassword())){
            throw new UsernameOrPasswordIncorrectException();
        } else {
            return u;
        }

    }

    public void followUser(User current, String username){
        //When we follow a user
        //Put the user in out following list
        //Put ourselves, in the other users followers list
        //We need to get the person we actaully want to follow, this is an opportunity for
        //Another exception
        User followie = uDao.getUserByUsername(username);

        //Take the person that is logged in, and get the list of people they are following
        Set<User> following = current.getFollowing();
        //Add the user we want to follow to our following list
        following.add(followie);
        current.setFollowing(following);

        //Update the person object that is being followed
        Set<User> followers = followie.getFollowers();
        followers.add(current);
        followie.setFollowers(followers);

        uDao.createUser(current);
        uDao.createUser(followie);
    }

    public List<User> getTopUsers(){

        List<User> uList = uDao.getAllUsers();

        Collections.sort(uList);

        return uList;
    }

}