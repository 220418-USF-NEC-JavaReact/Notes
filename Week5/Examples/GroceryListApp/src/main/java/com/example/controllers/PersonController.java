package com.example.controllers;

import com.example.models.Person;
import com.example.repository.services.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/person")
public class PersonController {

    private PersonService ps;

    @Autowired
    public PersonController(PersonService ps){
        this.ps = ps;
    }

    @PostMapping("/register")
    @ResponseBody
    public Person handleRegister(@RequestBody Person p){
        return ps.createPerson(p.getFirstName(), p.getLastName(), p.getUsername(), p.getPassword());
    }

    @PostMapping("/login")
    @ResponseBody
    public Person handleLogin(@RequestBody Login l){
        return ps.getUserByUsernameAndPassword(l.username, l.password);
    }

}

class Login {
    public String username;
    public String password;
}