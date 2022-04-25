package com.revature.models;

import java.util.Comparator;

public class PostComparator implements Comparator<Post> {

    @Override
    public int compare(Post o1, Post o2) {
        if(o1.getTimeStamp().after(o2.getTimeStamp())){
            return -1;
        }
        else if(o1.getTimeStamp().before(o2.getTimeStamp())){
            return 1;
        }
        else {
            return 0;
        }
    }
}
