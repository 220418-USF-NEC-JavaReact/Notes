package com.example.repository.services;

import com.example.exceptions.IncorrectCredentials;
import com.example.models.Person;
import com.example.repository.PersonRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class PersonService {


    private PersonRepo rp;

    @Autowired
    public PersonService(PersonRepo rp){
        this.rp = rp;
    }

    public Person createPerson(String first, String last, String username, String password){
        Person p = new Person(0, first, last, username, password);

        return rp.save(p);
    }

    public Person getUserByUsernameAndPassword(String username, String password) throws IncorrectCredentials {

        Person p = rp.findByUsernameAndPassword(username, password);

        //Login failed
        System.out.println(p);

        if(p == null){
            throw new IncorrectCredentials();
        } else{
            return p;
        }

    }

}
