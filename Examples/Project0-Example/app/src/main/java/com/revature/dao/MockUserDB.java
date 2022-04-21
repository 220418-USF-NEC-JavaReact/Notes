package com.revature.dao;

import java.util.*;
import com.revature.models.User;

//The Mock User DB will be a lazy singleton
public class MockUserDB{

    //We are going to use a HashMap as our mock database
    //The first value is the key, the second is the element we are storing
    private Map<String, User> db;

    private static MockUserDB mockDBInstance = null;

    private MockUserDB(){
        db = new HashMap<>();
    }

    public static MockUserDB getInstance(){
        if(mockDBInstance == null){
            mockDBInstance = new MockUserDB();
            return mockDBInstance;
        } else {
            return mockDBInstance;
        }
    }

    public Map<String, User> getDB(){
        return db;
    }

        public void populateUsers(){
        User u1 = new User("Rick", "Sanchez", "RickSanchez1234", "rick@mail.com", "password");
        User u2 = new User("Morty", "Smith", "MortySmith1234", "morty@mail.com", "password");
        User u3 = new User("Summer", "Smith", "SummerSmith1234", "summer@mail.com", "password");
        User u4 = new User("Jimmy", "Nuetron", "JimmyNuetraon1234", "jimmy@mail.com", "password");
        User u5 = new User("Timmy", "Turner", "TimmyTurner1234", "timmy@mail.com", "password");

        Set<User> u1Followers = new HashSet<>();
        Set<User> u1Following = new HashSet<>();

        u1Following.add(u2);
        u1Following.add(u3);
        u1Following.add(u4);

        u1Followers.add(u2);
        u1Followers.add(u5);

        Set<User> u2Followers = new HashSet<>();
        Set<User> u2Following = new HashSet<>();

        u2Followers.add(u1);
        u2Followers.add(u3);

        u2Following.add(u1);
        u2Following.add(u3);
        u2Following.add(u4);
        u2Following.add(u5);

        Set<User> u3Followers = new HashSet<>();
        Set<User> u3Following = new HashSet<>();

        u3Followers.add(u1);
        u3Followers.add(u2);
        u3Followers.add(u4);
        u3Followers.add(u5);

        u3Following.add(u2);
        u3Following.add(u4);

        Set<User> u4Followers = new HashSet<>();
        Set<User> u4Following = new HashSet<>();

        u4Followers.add(u1);
        u4Followers.add(u2);
        u4Followers.add(u3);

        u4Following.add(u3);
        u4Following.add(u5);

        Set<User> u5Followers = new HashSet<>();
        Set<User> u5Following = new HashSet<>();

        u5Followers.add(u4);
        u5Followers.add(u2);
        u5Followers.add(u1);

        u5Following.add(u3);
        u5Following.add(u2);
        u5Following.add(u1);

        u1.setFollowers(u1Followers);
        u1.setFollowing(u1Following);
        u2.setFollowers(u2Followers);
        u2.setFollowing(u2Following);
        u3.setFollowers(u3Followers);
        u3.setFollowing(u3Following);
        u4.setFollowers(u4Followers);
        u4.setFollowing(u4Following);
        u5.setFollowing(u5Following);
        u5.setFollowers(u5Followers);

        db.put(u1.getUsername(), u1);
        db.put(u2.getUsername(), u2);
        db.put(u3.getUsername(), u3);
        db.put(u4.getUsername(), u4);
        db.put(u5.getUsername(), u5);
    }


}