package com.revature.dao;

import com.revature.models.User;
import java.util.Map;
import java.util.List;
import java.util.ArrayList;

public class UserDaoMock implements IUserDao {

    Map<String,User> db = MockUserDB.getInstance().getDB();

    @Override
    public User createUser(User u){
        //Store the user in the "db"
        db.put(u.getUsername(), u);
        return u;
    }

    @Override
    public User getUserByUsername(String username){
        return db.get(username);
    }

    @Override
    public List<User> getAllUsers(){
        //ArrayList has a constructor which takes in a Generic Collection
        //And inserts the values into the array list
        return new ArrayList<User>(db.values());
    }

}