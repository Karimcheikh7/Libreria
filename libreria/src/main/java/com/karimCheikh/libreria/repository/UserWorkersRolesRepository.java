package com.karimCheikh.libreria.repository;

import com.karimCheikh.libreria.entity.UserWorkersRoles;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserWorkersRolesRepository extends JpaRepository<UserWorkersRoles, Integer> {
}
