package com.example.dao;

import com.example.models.Person;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository("PersonDao")
@Transactional
public class PersonDao {

    //We need a session to connect to the database
    private SessionFactory sessionFactory;

    @Autowired
    public PersonDao(SessionFactory sesFactory){
        this.sessionFactory = sesFactory;
    }

    public Person insert(Person p){
        int id = (int)sessionFactory.getCurrentSession().save(p);

        p.setUserId(id);

        return p;
    }

    public Person selectPersonById(int id){
        return sessionFactory.getCurrentSession().get(Person.class, id);
    }

    //Finally looking at hql
    public List<Person> selectAllPeople(){
        return sessionFactory.getCurrentSession().createQuery("from Person", Person.class).list();
    }

    public Person getUserByUsernameAndPassword(String username, String password){
        return sessionFactory.getCurrentSession()
                .createQuery(
                        "from Person where username=:username and password=:password",
                        Person.class
                ).setParameter("username", username)
                .setParameter("password", password).uniqueResult();
    }

}
