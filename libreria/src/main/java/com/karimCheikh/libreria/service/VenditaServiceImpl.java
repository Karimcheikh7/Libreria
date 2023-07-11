package com.karimCheikh.libreria.service;

import com.karimCheikh.libreria.entity.Libro;
import com.karimCheikh.libreria.entity.User;
import com.karimCheikh.libreria.entity.Vendita;
import com.karimCheikh.libreria.repository.VenditaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class VenditaServiceImpl implements VenditaService {

    @Autowired
    private LibroServiceImpl libroService;

    @Autowired
    private UserServiceImpl userService;

    @Autowired
    private VenditaRepository venditaRepository;

    public VenditaServiceImpl(LibroServiceImpl libroService, UserServiceImpl userService, VenditaRepository venditaRepository) {
        this.libroService = libroService;
        this.userService = userService;
        this.venditaRepository = venditaRepository;
    }

    @Override
    public List<Vendita> findAll() {
        return venditaRepository.findAll();
    }

    @Override
    public Vendita findById(Integer theId) {
        Optional<Vendita> risultato = venditaRepository.findById(theId);
        if (risultato.isPresent()){
            return risultato.get();
        }else {
            throw new RuntimeException("Non ho trovato il libro con l'id: " + theId);
        }
    }

    @Override
    public Vendita save(Integer userId, Integer libroId) {
        Libro libro = libroService.findById(libroId);
        User user = userService.findById(userId);
        if (libro != null && libroId.equals(libro.getId()) &&
                user != null && userId.equals(user.getId()) &&
                    libro.getQuantita() > 0) {
            Vendita vendita = new Vendita(userId, libroId, LocalDate.now());
            return venditaRepository.save(vendita);
        }else {
            throw new RuntimeException("Controllare se sono ancora disponibili questi libri o uno dei campi forniti non è valido: " + userId + " " + libroId);
        }
    }

    @Override
    public void deleteById(Integer theId) {
        venditaRepository.deleteById(theId);
    }

    @Override
    public LocalDate findDateOfSale(Integer numeroVendita) {
        Optional<Vendita> vendita = venditaRepository.findById(numeroVendita);
        if (vendita.isPresent()){
            return vendita.get().getLocalDate();
        }else {
            throw new RuntimeException("Non ho trovato la vendita con l'id: " + numeroVendita);
        }
    }

    @Override
    public Integer verificaDisponibilitaLibro(Integer idLibro) {
        Libro libro = libroService.findById(idLibro);
        Integer quantita = libro.getQuantita();
        Integer libriVenduti = venditaRepository.findAll().stream().filter(i -> i.getLibroId().equals(idLibro)).collect(Collectors.toList()).size();
        Integer disponibilita = quantita - libriVenduti;
        return disponibilita;
    }

    @Override
    public List<Vendita> findVenditaByIdLibro(Integer idLibro) {
        Optional<List<Vendita>> listaVendite = venditaRepository.findByLibroId(idLibro);
        if (listaVendite.isPresent()) {
            return listaVendite.get();
        } else {
            throw new RuntimeException("Non ho trovato il libro con l'id: " + idLibro);
        }
    }

    @Override
    public List<Vendita> findVenditaByLocalDate(LocalDate localDate) {
        Optional<List<Vendita>> listaVendite = venditaRepository.findVenditaByLocalDate(localDate);
        if (listaVendite.isPresent()) {
            return listaVendite.get();
        } else {
            throw new RuntimeException("Non ho trovato nessuna vendita per questa data: " + localDate);
        }
    }
}