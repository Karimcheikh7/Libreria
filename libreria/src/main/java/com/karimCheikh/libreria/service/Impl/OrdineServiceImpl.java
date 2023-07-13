package com.karimCheikh.libreria.service.Impl;

import com.karimCheikh.libreria.entity.Libro;
import com.karimCheikh.libreria.entity.Ordine;
import com.karimCheikh.libreria.repository.OrdineRepository;
import com.karimCheikh.libreria.service.OrdineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class OrdineServiceImpl implements OrdineService {

    @Autowired
    private LibroServiceImpl libroServiceImpl;

    @Autowired
    private OrdineRepository ordineRepository;

    public OrdineServiceImpl(LibroServiceImpl libroServiceImpl, OrdineRepository ordinerepository) {
        this.libroServiceImpl = libroServiceImpl;
        this.ordineRepository = ordinerepository;
    }

    @Override
    public Ordine findById(Integer idOrdine) {
        Optional<Ordine> ordine = ordineRepository.findById(idOrdine);
        if (ordine.isPresent()) {
            return ordine.get();
        }else {
         throw new RuntimeException("Non ho trovato l'ordino con l'id: " + idOrdine);
        }
    }

    @Override
    public List<Ordine> findAll() {
        return ordineRepository.findAll();
    }

    @Override
    public Ordine save(Integer idLibro, Integer quantitaOrdine) {
        Libro libro = libroServiceImpl.findById(idLibro);
        Integer quantita = libro.getQuantita();
        if (libro != null && idLibro.equals(libro.getId()) &&
                libro.getQuantita() < 3) {
            Ordine ordine = new Ordine(idLibro, quantitaOrdine);
            quantitaOrdine = ordine.getQuantitaOrdine() + quantita;
            libro.setQuantita(quantitaOrdine);
            return ordineRepository.save(ordine);
        }else {
            throw new RuntimeException("Controllare che i campi inseriti sia corretti: " + idLibro + " /" + quantitaOrdine);
        }
    }

    @Override
    public void deleteById(Integer idOrdine) {
        Optional<Ordine> ordine = ordineRepository.findById(idOrdine);
        Integer idLibro = ordine.get().getLibroId();
        Libro libro = libroServiceImpl.findById(idLibro);
        Integer quantita = libro.getQuantita();
        Integer quantitaOrdine = ordine.get().getQuantitaOrdine();
        libro.setQuantita(quantita - quantitaOrdine);
        ordineRepository.deleteById(idOrdine);
    }

    @Override
    public List<Ordine> findOrdineBylibroId(Integer idLibro) {
        Optional<List<Ordine>> listaOrdini = ordineRepository.findOrdineByLibroId(idLibro);
        if (listaOrdini.isPresent()) {
            return listaOrdini.get();
        } else {
            throw new RuntimeException("Non ho trovato il libro con l'id: " + idLibro);
        }
    }
}
