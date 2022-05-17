package com.example.service;

import org.springframework.stereotype.Component;

@Component("UserServiceBean")
public class UserService {

    public User createUser(String username, String password){
        return new User(1, username, password);
    }

    public boolean login (String username, String password) throws Exception{
        User checkAgainst = new User(1,"ethan", "password");

        if(username.equals(checkAgainst.username) && password.equals(checkAgainst.password)){
            return true;
        }
        else{
            throw new Exception();
        }
    }

    public User updateUser(User u){
        User original = new User(1, "Original", "OrginalPass");
        User updated = u;
        return updated;
    }

}

class User {
    int id;
    String username;
    String password;

    public User(int id, String username, String password){
        this.id = id;
        this.username = username;
        this.password = password;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
