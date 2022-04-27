package com.example.dao;

import com.example.models.User;
import com.example.utils.ConnectionSingleton;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public class UserDaoJDBC implements IUserDao{

    public ConnectionSingleton cs = ConnectionSingleton.getConnectionSingleton();

    @Override
    public void createUser(User u) {

        //To create a user, we must get our connection, create a statement, and execute said statement
        Connection c = cs.getConnection();

        String sql = "insert into users (first_name, last_name, email, password) values " +
                "('" + u.getFirstName() +"','" + u.getLastName() + "','" + u.getEmail() +"','" + u.getPassword() + "')";

        try {
            Statement s = c.createStatement();
            s.execute(sql);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public List<User> readAllUsers() {
        return null;
    }

    @Override
    public User readUserByEmail(String email) {
        return null;
    }

    @Override
    public User updateUser(User u) {
        return null;
    }

    @Override
    public void deleteUser(User u) {

    }
}
