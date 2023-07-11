package com.karimCheikh.libreria.repository;

import com.karimCheikh.libreria.entity.UserWorker;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserWorkerRepository extends JpaRepository<UserWorker, Integer> {
    UserWorker findByUserNameWorker(String userNameWorker);
}
