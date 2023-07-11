package com.karimCheikh.libreria.service;

import com.karimCheikh.libreria.entity.Editore;
import com.karimCheikh.libreria.entity.Libro;
import com.karimCheikh.libreria.repository.EditoreRepository;
import com.karimCheikh.libreria.repository.LibroRepository;
import com.karimCheikh.libreria.utils.WrapperLibro;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LibroServiceImpl implements LibroService {
    @Autowired
    private LibroRepository libroRepository;

    @Autowired
    private EditoreRepository editoreRepository;


    public LibroServiceImpl(LibroRepository libroRepository,  EditoreRepository editoreRepository){
        this.libroRepository = libroRepository;
        this.editoreRepository = editoreRepository;
    }

    @Override
    public Libro findByNomeTitolo(String nomeTitolo) {
        Optional<Libro> risultato = libroRepository.findByTitolo(nomeTitolo);
        if (risultato.isPresent()){
            return risultato.get();
        }else{
            throw new RuntimeException("Non ho trovato nessun libro con quetso titolo: " + nomeTitolo);
        }
    }

    @Override
    public List<Libro> findAll() {
        return libroRepository.findAll();
    }

    @Override
    public Libro findById(Integer theId) {
        Optional<Libro> risultato = libroRepository.findById(theId);
        if (risultato.isPresent()){
            return risultato.get();
        }else {
            throw new RuntimeException("Non ho trovato il libro con l'id: " + theId);
        }
    }

    @Override
    public Libro save(Libro libro) {
        return libroRepository.save(libro);
    }

    @Override
    public Libro save(WrapperLibro libro) {
        Optional<Editore> editore = editoreRepository.findById(libro.getIdEditore());
        if (editore.isPresent()){
            libro.getLibro().setEditore(editore.get());
            return libroRepository.save(libro.getLibro());
        }else {
            throw new RuntimeException("Non ho trovato l'editore con questo id: " + libro.getIdEditore());
        }
    }

    @Override
    public void deleteById(Integer theId) {
        libroRepository.deleteById(theId);
    }
}
