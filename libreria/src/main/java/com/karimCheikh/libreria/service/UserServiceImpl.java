package com.karimCheikh.libreria.service.Impl;

import com.karimCheikh.libreria.entity.User;
import com.karimCheikh.libreria.repository.UserRepository;
import com.karimCheikh.libreria.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;
    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User findByUserName(String userName) {
        // check the database if the user already exists
        Optional<User> risultato = Optional.ofNullable(userRepository.findByUserName(userName));
        if (risultato.isPresent()){
            return risultato.get();
        }else {
            throw new RuntimeException("Non ho trovato l'user con il nome: " + userName);
        }
    }

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public User findById(Integer theId) {
        Optional<User> risultato = userRepository.findById(theId);
        if (risultato.isPresent()){
            return risultato.get();
        }else {
            throw new RuntimeException("Non ho trovato l'user con l'id: " + theId);
        }
    }

    @Override
    public User save(User user) {
        return userRepository.save(user);
    }

    @Override
    public void deleteById(Integer theId) {
        userRepository.deleteById(theId);
    }

}