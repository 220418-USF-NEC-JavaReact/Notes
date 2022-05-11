package com.example.services;

import com.example.dao.IPostDao;
import com.example.dao.IUserDao;
import com.example.models.User;

public class UserService {

    private IUserDao ud;
    private IPostDao pd;

    public UserService(IUserDao ud, IPostDao pd){
        this.ud = ud;
        this.pd = pd;
    }

    //Typically when we create a user in a application, we are registering it
    public void registerUser(String first, String last, String email, String password){
        User register = new User(101, first, last, email, password);
        ud.createUser(register);
    }

    public User loginUser(String email, String password){
        //Try to see if that user exists in the database
        User u = ud.readUserByEmail(email);

        if(u != null){
            if(password.equals(u.getPassword())){
                //This is out success
                return u;
            } else {
                //This means the password did not match
                return null;
            }
        }

        //Also not good, the user did not exist
        return null;
    }

    public User updateUserInfo(User u){
        return ud.updateUser(u);
    }

    public void deleteUser(User u){
        ud.deleteUser(u);
    }

    public void createFollowingRelationship(int followingId, int userId){
        ud.insertFollowing(followingId, userId);
    }

    public User populateUserObject(String email){
        User u = ud.readUserByEmail(email);

        u.setFollowing(ud.getFollowing(u.getUserId()));
        u.setFollowers(ud.getFollowers(u.getUserId()));
        u.setPosts(pd.readPostByUser(u.getUserId()));

        return u;
    }


}
