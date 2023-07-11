package com.karimCheikh.libreria.service;

import com.karimCheikh.libreria.entity.Editore;

import java.util.List;

public interface EditoreService {
    Editore findByNomeEditore(String nomeEditore);
    List<Editore> findAll();

    Editore findById(Integer theId);

    Editore save(Editore theEditore);

    void deleteById(Integer theId);
}
