package com.geohor.converter;

import com.geohor.entity.User;
import com.geohor.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;


public class UserConverter implements Converter<String, User> {
    @Autowired
    UserRepository userRepository;

    @Override
    public User convert(String id) {
        return userRepository.findOne(Long.parseLong(id));
    }
}
