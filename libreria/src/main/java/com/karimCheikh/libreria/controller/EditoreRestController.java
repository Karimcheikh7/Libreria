package com.karimCheikh.libreria.controller;

import com.karimCheikh.libreria.entity.Editore;
import com.karimCheikh.libreria.service.Impl.EditoreServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EditoreRestController {

    private EditoreServiceImpl editoreServiceImpl;
    @Autowired
    public EditoreRestController(EditoreServiceImpl editoreServiceImpl) {
        this.editoreServiceImpl = editoreServiceImpl;
    }

    @GetMapping("/editori")
    public List<Editore> findAll(){
        return editoreServiceImpl.findAll();
    }

    @GetMapping("editori/{editoreId}")
    public Editore getEditore(@PathVariable Integer editoreId){
        Editore editore = editoreServiceImpl.findById(editoreId);

        if (editore == null){
            throw new RuntimeException("L'id dell'editore che hai messo non è presente: " + editoreId);
        }else return editore;
    }

    @GetMapping("editore/{editoreNome}")
    public Editore getEditoreByName(@PathVariable String nomeEditore) {
        Editore editore = editoreServiceImpl.findByNomeEditore(nomeEditore);
        if (editore == null) {
            throw new RuntimeException("Il nome dello user che hai messo non è corretto: " + nomeEditore);
        }return editore;
    }

    @PostMapping("/editori")
    public Editore addEditore(@RequestBody Editore editore){

        Editore editoreDb = editoreServiceImpl.save(editore);
        return editoreDb;

    }

    @PutMapping("/editori")
    public  Editore updateEditore(@RequestBody Editore editore){

        Editore editoreDb = editoreServiceImpl.save(editore);
        return editoreDb;
    }

    @DeleteMapping("/editori/{editoreId}")
    public String deleteEditore(@PathVariable Integer editoreId){
        Editore editoreTemp = editoreServiceImpl.findById(editoreId);

        if (editoreTemp == null){
            throw new RuntimeException("L'id dell'editore che hai messo non è presente: " + editoreId);
        }
        return "Eliminato editore con l'id: " + editoreId;
    }

}
