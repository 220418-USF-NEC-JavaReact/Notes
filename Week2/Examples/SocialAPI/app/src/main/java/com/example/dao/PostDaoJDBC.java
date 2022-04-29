package com.example.dao;

import com.example.models.Post;
import com.example.models.User;
import com.example.utils.ConnectionSingleton;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PostDaoJDBC implements IPostDao{

    private ConnectionSingleton cs = ConnectionSingleton.getConnectionSingleton();

    @Override
    public void createPost(Post p) {

        Connection c = cs.getConnection();

        //We will call our stored procedure that we created to create a new post
        try{
            //We must first turn off autocommit
            c.setAutoCommit(false);

            String sql = "call create_post(?,?,?)";
            CallableStatement call = c.prepareCall(sql);

            call.setDate(1, p.getPostedDate());
            call.setString(2, p.getContent());
            call.setInt(3, p.getPostUser().getUserId());

            call.execute();

            //We HAVE to set commit back to true so it actually commits
            c.setAutoCommit(true);
        } catch(SQLException e){
            e.printStackTrace();
        }


    }

    @Override
    public List<Post> readPostByUser(int id) {

        Connection c = cs.getConnection();

        try{
            c.setAutoCommit(false);
            String sql = "{?=call get_posts_by_user(?)}";

            CallableStatement call = c.prepareCall(sql);

            //The function returns a ref cursor, so we need to gain access to that in Java
            call.registerOutParameter(1, Types.OTHER);

            call.setInt(2, id);

            call.execute();

            ResultSet rs = (ResultSet) call.getObject(1);

            List<Post> aList = new ArrayList<>();

            while(rs.next()){
                User u = new User(rs.getInt(5),rs.getString(6),rs.getString(7),rs.getString(8),rs.getString(9));

                Post p = new Post(rs.getInt(1), rs.getDate(2), rs.getString(3), u);

                aList.add(p);
            }

            return aList;

        } catch(SQLException e){
            e.printStackTrace();
            return null;
        }

    }
}
