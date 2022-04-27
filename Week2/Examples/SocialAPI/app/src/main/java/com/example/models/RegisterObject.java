package com.example.models;

public class RegisterObject {

    public String first;
    public String last;
    public String email;
    public String password;

    @Override
    public String toString() {
        return "RegisterObject{" +
                "first='" + first + '\'' +
                ", last='" + last + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
