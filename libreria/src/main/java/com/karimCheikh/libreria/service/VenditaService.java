package com.karimCheikh.libreria.service;

import com.karimCheikh.libreria.entity.Vendita;


import java.time.LocalDate;
import java.util.List;

public interface VenditaService {
    List<Vendita> findAll();

    Vendita findById(Integer theId);


    Vendita save(Integer userId, Integer libroId);


    void deleteById(Integer theId);


    LocalDate findDateOfSale(Integer numeroVendita);

    Integer verificaDisponibilitaLibro(Integer idLibro);

    List<Vendita> findVenditaByIdLibro(Integer idLibro);

    List<Vendita> findVenditaByLocalDate(LocalDate localDate);
}
