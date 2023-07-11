package com.karimCheikh.libreria.service;

import com.karimCheikh.libreria.entity.Ordine;


import java.util.List;


public interface OrdineService {

    Ordine findById(Integer idOrdine);

    List<Ordine> findAll();

    Ordine save(Integer idLibro, Integer quantitaOrdine);

    void deleteById(Integer idOrdine);

    List<Ordine> findOrdineBylibroId(Integer idLibro);
}
