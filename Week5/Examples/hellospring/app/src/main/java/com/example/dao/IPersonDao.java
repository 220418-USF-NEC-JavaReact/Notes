package com.example.dao;

import com.example.models.Person;

public interface IPersonDao {

    public Person createPerson(Person p);

    public Person getPerson(Person p);

    public Person updatePerson(Person p);

    public boolean deletePerson(Person p);
}
