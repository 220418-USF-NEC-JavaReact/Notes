package com.revature.exceptions;

public class UsernameOrPasswordIncorrectException extends Exception {

    //We typically create at least two constructors
    public UsernameOrPasswordIncorrectException(){
        super("This user input an incorect username or password");
    }

    public UsernameOrPasswordIncorrectException(String message){
        super(message);
    }

}