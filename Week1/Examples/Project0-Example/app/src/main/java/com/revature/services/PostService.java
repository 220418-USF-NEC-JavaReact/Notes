package com.revature.services;

import com.revature.dao.IPostDao;
import com.revature.models.Post;
import com.revature.models.PostComparator;
import com.revature.models.User;

import java.util.Set;
import java.util.TreeSet;

public class PostService {

    //We will also use dependency injection inside of here, so we can swap out whatever implemtation
    //of the dao that we want

    private IPostDao pDao;

    public PostService(IPostDao pd){
        this.pDao = pd;
    }
    
    public Set<Post> getUserFeed(User loggedIn){

        Set<User> following = loggedIn.getFollowing();

        //We want to specify how we are going to order the posts, so we must give the treeset a comparator
        Set<Post> userFeed = new TreeSet<>(new PostComparator());

        //Create an enhanced for loop, because I haven't really showed you one yet
        //The loop is looping through the set of users that we follow
        for(User u : following){
            //Looping through each user in our following list
            //Getting their username, and getting the posts that belong to them
            userFeed.addAll(pDao.getPostsByUser(u.getUsername()));
        }

        if(pDao.getPostsByUser(loggedIn.getUsername()) == null){
            return userFeed;
        }
        else {
            userFeed.addAll(pDao.getPostsByUser(loggedIn.getUsername()));
            return userFeed;
        }
    }

    public void createPost(User u, String content){
        Post p = new Post(content, u);

        pDao.createPost(p);
    }

}
