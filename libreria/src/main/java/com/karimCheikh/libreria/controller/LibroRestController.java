package com.karimCheikh.libreria.controller;

import com.karimCheikh.libreria.entity.Libro;
import com.karimCheikh.libreria.service.LibroServiceImpl;
import com.karimCheikh.libreria.utils.WrapperLibro;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class LibroRestController {
    private LibroServiceImpl libroServiceImpl;

    @Autowired
    public LibroRestController(LibroServiceImpl libroService) {
        libroServiceImpl = libroService;
    }

    @GetMapping("/libri")
    public List<Libro> findAll() {
        return libroServiceImpl.findAll();
    }

    @GetMapping("/libri/{libroId}")
    public Libro getLibro(@PathVariable Integer libroId) {
        Libro libro = libroServiceImpl.findById(libroId);

        if (libro == null) {
            throw new RuntimeException("L'id del libro che hai messo non è presente: " + libroId);
        }return libro;
    }

//    @PostMapping("/libri")
//    public Libro addLibro(@RequestBody Libro ilLibro){
//
//        Libro libroDb = libroServiceImpl.save(ilLibro);
//        return libroDb;
//    }

    @PostMapping("/libri")
    public Libro addLibro(@RequestBody WrapperLibro libro){
        Libro libroDb = libroServiceImpl.save(libro);
        return libroDb;
    }

    @PutMapping("/libri")
    public Libro updateLibro(@RequestBody Libro libro){
        Libro libroDb = libroServiceImpl.save(libro);
        return libroDb;
    }

    @DeleteMapping("/libri/{libroId}")
    public String deleteLibro(@PathVariable Integer libroId){
        Libro libroTemp = libroServiceImpl.findById(libroId);

        if (libroTemp == null){
            throw new RuntimeException("L'id che hai ,esso non è presente: " + libroId);
        }else libroServiceImpl.deleteById(libroId);

        return "Eliminato il libro con l'id: " + libroId;

    }

}
