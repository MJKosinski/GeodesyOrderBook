package com.geohor.service;

import com.geohor.entity.User;
import com.geohor.repository.UserRepository;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class UserService {


    @Autowired
    UserRepository userRepository;

    public void save(User user) {
        boolean hashPass = false;
        if (user.getId()==null){
            hashPass = true;
            //encode password
        } else if(user.getPassword() == null || user.getPassword().trim().length()==0){
            //check if password changed
            User oldUserData = userRepository.findOne(user.getId());
            user.setPassword(oldUserData.getPassword());
        } else {
            //password changed
            hashPass = true;

        }
        if (hashPass) {
            String hashedPass = BCrypt.hashpw(user.getPassword(), BCrypt.gensalt());
            user.setPassword(hashedPass);
        }
        userRepository.save(user);
    }

    public User checkLogin(String email, String password) throws Exception{
        User user = userRepository.findUserByEmail(email);
        if(user == null) {
            throw new Exception("User not found");
        }
        if(BCrypt.checkpw(password, user.getPassword())){
            return user;
        } else {
            throw new Exception("Wrong user or password");
        }
    }



}
