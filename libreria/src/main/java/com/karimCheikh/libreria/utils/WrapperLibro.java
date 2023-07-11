package com.karimCheikh.libreria.utils;

import com.karimCheikh.libreria.entity.Libro;

public class WrapperLibro {

    Libro libro; //libro che andro a salvare solo dopo aver trovato l'editore nel DB
    Integer idEditore;// parametro che passo in input per cercare l'editore nel DB

    public WrapperLibro() {
    }

    public WrapperLibro(Libro libro, Integer idEditore) {
        this.libro = libro;
        this.idEditore = idEditore;
    }

    public Libro getLibro() {
        return libro;
    }

    public void setLibro(Libro libro) {
        this.libro = libro;
    }

    public Integer getIdEditore() {
        return idEditore;
    }

    public void setIdEditore(Integer idEditore) {
        this.idEditore = idEditore;
    }
//    public Editore findByName(String nome) {
//        Optional<Editore> risultato = editoreRepository.findby(theId);
//        if (risultato.isPresent()){
//            return risultato.get();
//        }else {
//            throw new RuntimeException("Non ho trovato l'editore con l'id: " + theId);
//        }
//    }


}
