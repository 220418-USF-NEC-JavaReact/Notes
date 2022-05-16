package com.example.dao;

import com.example.models.Person;

import java.util.ArrayList;
import java.util.List;

public class PersonDaoMock implements IPersonDao{

    private List<Person> personDB;

    public PersonDaoMock(){
        this.personDB = new ArrayList<>();
    }

    @Override
    public Person createPerson(Person p) {
        personDB.add(p);
        return p;
    }

    @Override
    public Person getPerson(Person p) {
        int i = personDB.lastIndexOf(p);

        if(i == -1){
            return null;
        }else{
            return personDB.get(i);
        }
    }

    @Override
    public Person updatePerson(Person p) {
        for(int i=0; i< personDB.size(); i++){
            Person temp = personDB.get(i);
            if(temp.getUsername().equals(p.getUsername())){
                personDB.set(i, p);
            }
        }

        return p;
    }

    @Override
    public boolean deletePerson(Person p) {

        return personDB.remove(p);
    }
}
