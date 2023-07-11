package com.karimCheikh.libreria.repository;

import com.karimCheikh.libreria.entity.Vendita;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public interface VenditaRepository extends JpaRepository<Vendita, Integer> {
    Optional<List<Vendita>> findByLibroId(Integer idLibro);

    Optional<List<Vendita>> findVenditaByLocalDate(LocalDate localDate);


}
