package com.example.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.BAD_REQUEST)
public class IncorrectCredentials extends RuntimeException{

    public IncorrectCredentials(){
        super("Username or password incorrect");
    }

}
