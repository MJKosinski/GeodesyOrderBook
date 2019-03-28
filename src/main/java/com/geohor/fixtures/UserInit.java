package com.geohor.fixtures;

import com.geohor.entity.User;
import com.geohor.myenum.UserType;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

public class UserInit {
    



    public static List<User> createUsers() {
        
        List<User> users = new ArrayList<>();
        User geoUser = new User();
        geoUser.setName("geodeta");
        geoUser.setEmail("geo@geo.pl");
        geoUser.setPassword(BCrypt.hashpw("123", BCrypt.gensalt()));
        geoUser.setType(UserType.GEODESY);
        users.add(geoUser);

        User generalCUser = new User();
        generalCUser.setName("generalny_wykonawca");
        generalCUser.setEmail("gw@gw.pl");
        generalCUser.setPassword(BCrypt.hashpw("123", BCrypt.gensalt()));
        generalCUser.setType(UserType.GENERAL_CONTRACTOR);
        users.add(generalCUser);
        
        User sub1User = new User();
        sub1User.setName("Podwykonawca-1");
        sub1User.setEmail("sub1@gw.pl");
        sub1User.setPassword(BCrypt.hashpw("123", BCrypt.gensalt()));
        sub1User.setType(UserType.SUBCONTRACTOR);
        users.add(sub1User);

        User sub2User = new User();
        sub2User.setName("Podwykonawca-2");
        sub2User.setEmail("sub2@gw.pl");
        sub2User.setPassword(BCrypt.hashpw("123", BCrypt.gensalt()));
        sub2User.setType(UserType.SUBCONTRACTOR);
        users.add(sub2User);

        
        
        return users;
    }
    
    
    
}
