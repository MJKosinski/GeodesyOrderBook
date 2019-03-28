package com.geohor.repository;

import com.geohor.entity.User;
import com.geohor.myenum.UserType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long>{


    List<User> findAllByTypeIs(UserType type);

    User findUserByEmail(String email);





}
