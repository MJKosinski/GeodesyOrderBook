package com.geohor.service;

import com.geohor.entity.User;
import com.geohor.entity.Work;
import com.geohor.myenum.UserType;
import com.geohor.repository.UserRepository;
import com.geohor.repository.WorkRepository;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;


@Service
public class UserService {


    @Autowired
    UserRepository userRepository;

    @Autowired
    WorkRepository workRepository;

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


    public List<User> findAll(UserType type) {

        List<User> allUsers = new ArrayList<>();

        if(type == UserType.GEODESY) {

            allUsers = userRepository.findAll();
        } else if(type == UserType.GENERAL_CONTRACTOR) {
            allUsers = userRepository.findAllByTypeIsNot(UserType.GEODESY);
        }


     return allUsers;
    }

    public void delUser(UserType fulltype, Long id){
        User userToDelete = userRepository.findOne(id);
        if(fulltype == UserType.GEODESY){
            userRepository.delete(userToDelete);
            return;

        } else if(fulltype == UserType.GENERAL_CONTRACTOR) {
            if(userToDelete.getType() != UserType.SUBCONTRACTOR){
                return;
            } else {

                    userRepository.delete(userToDelete);
            }
        }
        return;


    }

    public List<UserType> getUserTypesList(User logUser) {

        List<UserType> collect = Arrays.stream(UserType.values()).collect(Collectors.toList());
        if(logUser.getType() == UserType.GENERAL_CONTRACTOR){
            collect.remove(UserType.GEODESY);
        }
    return collect;
    }
}
