package com.karimCheikh.libreria.service;


import com.karimCheikh.libreria.entity.User;

import java.util.List;

public interface UserService {

    User findByUserName(String userName);

    List<User> findAll();

    User findById(Integer theId);

    User save(User loUser);

    void deleteById(Integer theId);

}