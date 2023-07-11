package com.karimCheikh.libreria.service;

import com.karimCheikh.libreria.entity.UserWorker;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface UserWorkerService extends UserDetailsService {

    UserWorker findByUserNameWorker(String userNameWorker);

    List<UserWorker> findAll();

    UserWorker findById(Integer id);

    UserWorker save(UserWorker userWorker);

    void deleteById(Integer id);
}
