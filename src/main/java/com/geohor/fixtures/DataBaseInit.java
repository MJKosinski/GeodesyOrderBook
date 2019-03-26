package com.geohor.fixtures;

import com.geohor.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class DataBaseInit {

    @Autowired
    UserRepository userRepository;


    @PostConstruct
    public void insertIntoDB(){
    userRepository.save(UserInit.createUsers());

    }


}
