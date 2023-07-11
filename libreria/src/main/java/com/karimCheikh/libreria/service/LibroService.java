package com.karimCheikh.libreria.service;

import com.karimCheikh.libreria.entity.Libro;
import com.karimCheikh.libreria.utils.WrapperLibro;

import java.util.List;

public interface LibroService {
    Libro findByNomeTitolo(String nomeTitolo);

    List<Libro> findAll();

    Libro findById(Integer theId);

    Libro save(WrapperLibro ilLibro);

    Libro save(Libro ilLibro);

    void deleteById(Integer theId);

}
