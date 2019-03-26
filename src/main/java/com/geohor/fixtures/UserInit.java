package com.geohor.fixtures;

import com.geohor.entity.User;
import com.geohor.myenum.UserType;

import java.util.ArrayList;
import java.util.List;

public class UserInit {
    
    
    public static List<User> createUsers() {
        
        List<User> users = new ArrayList<>();
        User geoUser = new User();
        geoUser.setLogin("geo");
        geoUser.setEmail("geo@geo.pl");
        geoUser.setPassword("123");
        geoUser.setType(UserType.GEODESY);
        users.add(geoUser);

        User generalCUser = new User();
        generalCUser.setLogin("gw");
        generalCUser.setEmail("gw@gw.pl");
        generalCUser.setPassword("123");
        generalCUser.setType(UserType.GENERAL_CONTRACTOR);
        users.add(generalCUser);
        
        User sub1User = new User();
        sub1User.setLogin("sub1");
        sub1User.setEmail("sub1@gw.pl");
        sub1User.setPassword("123");
        sub1User.setType(UserType.SUBCONTRACTOR);
        users.add(sub1User);

        User sub2User = new User();
        sub2User.setLogin("sub2");
        sub2User.setEmail("sub2@gw.pl");
        sub2User.setPassword("123");
        sub2User.setType(UserType.SUBCONTRACTOR);
        users.add(sub2User);

        
        
        return users;
    }
    
    
    
}
