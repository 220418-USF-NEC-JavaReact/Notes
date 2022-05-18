package com.example.repository;

import com.example.models.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PersonRepo extends JpaRepository<Person, Integer> {

    public List<Person> findAll();
    public Person findByUsernameAndPassword(String username, String password);

}
