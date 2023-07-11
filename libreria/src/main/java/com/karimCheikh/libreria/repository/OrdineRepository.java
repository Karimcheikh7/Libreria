package com.karimCheikh.libreria.repository;

import com.karimCheikh.libreria.entity.Ordine;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface OrdineRepository extends JpaRepository<Ordine, Integer> {

    Optional<List<Ordine>> findOrdineByLibroId(Integer idLibro);
}
