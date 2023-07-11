package com.karimCheikh.libreria.repository;

import com.karimCheikh.libreria.entity.Libro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface LibroRepository extends JpaRepository<Libro, Integer> {
    Optional<Libro> findByTitolo(String nomeTitolo);

}
