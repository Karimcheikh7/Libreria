package com.karimCheikh.libreria.controller;

import com.karimCheikh.libreria.entity.Vendita;
import com.karimCheikh.libreria.service.Impl.VenditaServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api")
public class VenditaRestController {

    @Autowired
    private VenditaServiceImpl venditaServiceImpl;

    public VenditaRestController(VenditaServiceImpl venditaServiceImpl) {
        this.venditaServiceImpl = venditaServiceImpl;
    }

    @PostMapping("/vendite")
    public Vendita addVendita(@org.jetbrains.annotations.NotNull @RequestBody Vendita vendita) {
        Vendita venditaDb = venditaServiceImpl.save(vendita.getUserId(), vendita.getLibroId());
        return vendita;
    }

    @GetMapping("/vendite")
    public List<Vendita> findAll() {
        return venditaServiceImpl.findAll();
    }

    @GetMapping("/vendite/{numeroVendita}")
    public Vendita getVendita(@PathVariable Integer numeroVendita) {
        Vendita vendita = venditaServiceImpl.findById(numeroVendita);
        if (vendita == null) {
            throw new RuntimeException("Il numero della vendità che hai messo non è presente: " + numeroVendita);
        }return vendita;
    }

    @GetMapping("/venditaLibri/{idLibro}")
    public List<Vendita> getVenditaByIdLibro(@PathVariable Integer idLibro) {
        List<Vendita> vendite = venditaServiceImpl.findVenditaByIdLibro(idLibro);
        if (vendite == null) {
            throw new RuntimeException("L'id del libro della vendità che hai messo non è presente: " + idLibro);
        }return vendite;
    }

    @GetMapping("/vendita/{idLibro}")
    public Integer getQuantitaLibro(@PathVariable Integer idLibro) {
        Integer quantita = venditaServiceImpl.verificaDisponibilitaLibro(idLibro);
        if (quantita == null) {
            throw new RuntimeException("L'id del libro della vendità che hai messo non è presente: " + idLibro);
        }return quantita;
    }

    @GetMapping("/venditaData/{numeroVendita}")
    public LocalDate getDataVendita(@PathVariable Integer numeroVendita) {
        LocalDate dataVendita = venditaServiceImpl.findDateOfSale(numeroVendita);
        return dataVendita;
    }

    @GetMapping("/venditeData/{localDate}")
    public List<Vendita> getVenditeByLocalDate(@PathVariable LocalDate localDate) {
        List<Vendita> vendite = venditaServiceImpl.findVenditaByLocalDate(localDate);
        if (vendite == null){
            throw new RuntimeException("La data inserita non è corretta: " + localDate);
        }return vendite;
    }

    @DeleteMapping("/vendite/{numeroVendita}")
    public String deleteVendita(@PathVariable Integer numeroVendita) {
        Vendita venditaTemp = venditaServiceImpl.findById(numeroVendita);
        if (venditaTemp == null) {
            throw new RuntimeException("Il numero della vendità della vendità che hai messo non è presente: " + numeroVendita);
        }else venditaServiceImpl.deleteById(numeroVendita);
        return "Eliminata la vendità con il numero: " + numeroVendita;
    }

}
