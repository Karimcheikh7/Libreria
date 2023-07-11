package com.karimCheikh.libreria.service;

import com.karimCheikh.libreria.entity.Editore;
import com.karimCheikh.libreria.repository.EditoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EditoreServiceImpl implements EditoreService{
    @Autowired
    private EditoreRepository editoreRepository;

    public EditoreServiceImpl(EditoreRepository editoreRepository){
        this.editoreRepository = editoreRepository;
    }

    @Override
    public Editore findByNomeEditore(String nomeEditore) {
        Optional<Editore> risultato = editoreRepository.findByNome(nomeEditore);
        if (risultato.isPresent()) {
            return risultato.get();
        }else {
            throw new RuntimeException("Non ho trovato l'editore con questo nome: " + nomeEditore);
        }
    }

    @Override
    public List<Editore> findAll() {
        return editoreRepository.findAll();
    }

    @Override
    public Editore findById(Integer theId) {
        Optional<Editore> risultato = editoreRepository.findById(theId);
        if (risultato.isPresent()){
            return risultato.get();
        }else {
            throw new RuntimeException("Non ho trovato l'editore con l'id: " + theId);
        }
    }

    @Override
    public Editore save(Editore editore) {
        return editoreRepository.save(editore);
    }

    @Override
    public void deleteById(Integer theId) {
editoreRepository.deleteById(theId);
    }
}
