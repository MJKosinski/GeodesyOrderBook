package com.geohor.fixtures;

import com.geohor.repository.UserRepository;
import com.geohor.repository.WorkRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class DataBaseInit {

    @Autowired
    UserRepository userRepository;

    @Autowired
    WorkRepository workRepository;

    @Autowired
    WorkInit workInit;


    @PostConstruct
    public void insertIntoDB(){
    userRepository.save(UserInit.createUsers());
    workRepository.save(workInit.createWorks());
    }


}
