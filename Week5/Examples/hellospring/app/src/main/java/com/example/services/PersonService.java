package com.example.services;

import com.example.dao.IPersonDao;
import com.example.models.Person;

public class PersonService {

    //Typically our PersonService needs access to our PersonDao, this is a dependency we can allow spring to manage for us
    private IPersonDao pDao;

    public PersonService(IPersonDao pd){
        this.pDao = pd;
    }

    public Person register(String first, String last, String username, String password){
        Person p = new Person(first, last, username, password);

        return pDao.createPerson(p);
    }

}
