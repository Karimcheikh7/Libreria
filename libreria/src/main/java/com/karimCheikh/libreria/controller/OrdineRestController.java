package com.karimCheikh.libreria.controller;

import com.karimCheikh.libreria.entity.Ordine;
import com.karimCheikh.libreria.service.Impl.OrdineServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api")
public class OrdineRestController {

    @Autowired
    private OrdineServiceImpl ordineServiceImpl;

    public OrdineRestController(OrdineServiceImpl ordineServiceImpl) {
        this.ordineServiceImpl = ordineServiceImpl;
    }

    @GetMapping("/ordini")
    public List<Ordine> getOrdini() {
        return ordineServiceImpl.findAll();
    }

    @GetMapping("/ordine/{idOrdine}")
    public Ordine getOrdine(@PathVariable Integer idOrdine) {
        Ordine ordine = ordineServiceImpl.findById(idOrdine);
        if (ordine == null) {
            throw new RuntimeException("L'id dell' ordine che hai messo non è presente: " + idOrdine);
        }return ordine;
    }

    @PostMapping("/ordini")
    public Ordine addOrdine(@RequestBody Ordine ordine) {
        Ordine ordineDb = ordineServiceImpl.save(ordine.getLibroId(), ordine.getQuantitaOrdine());
        return ordine;
    }

    @DeleteMapping("/ordini/{idOrdine}")
    public String deleteOrdine(@PathVariable Integer idOrdine) {
        Ordine ordineTemp = ordineServiceImpl.findById(idOrdine);
        if (ordineTemp == null) {
            throw new RuntimeException("L'id dell' ordine che hai inserito non è presente: " + idOrdine);
        }else ordineServiceImpl.deleteById(idOrdine);
        return "Eliminato l'ordine con l'id : " + idOrdine;
    }

}
