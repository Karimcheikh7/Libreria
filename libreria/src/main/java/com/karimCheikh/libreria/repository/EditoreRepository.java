package com.karimCheikh.libreria.repository;

import com.karimCheikh.libreria.entity.Editore;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface EditoreRepository extends JpaRepository<Editore, Integer> {
    Optional<Editore> findByNome(String nomeEditore);
}
