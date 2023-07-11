package com.karimCheikh.libreria.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

@Entity
@Table(name = "libri")
public class Libro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    @Column(name = "titolo")
    private String titolo;
    @Column(name = "autore")
    private String autore;
    @Column(name = "anno")
    private int anno;
    @Column(name = "prezzo")
    private Double prezzo;
    @Column(name = "quantita")
    private Integer quantita;
    @ManyToOne(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinColumn(name = "editore_id")
    @JsonIgnore
    private Editore editore;

    public Libro() {
    }

    public Libro(String titolo, String autore, int anno, Double prezzo, Integer quantita, Editore editore) {
        this.titolo = titolo;
        this.autore = autore;
        this.anno = anno;
        this.prezzo = prezzo;
        this.quantita = quantita;
        this.editore = editore;
    }

    public int getId() {
        return id;
    }

    public String getTitolo() {
        return titolo;
    }

    public void setTitolo(String titolo) {
        this.titolo = titolo;
    }

    public String getAutore() {
        return autore;
    }

    public void setAutore(String autore) {
        this.autore = autore;
    }

    public int getAnno() {
        return anno;
    }

    public void setAnno(int anno) {
        this.anno = anno;
    }

    public double getPrezzo() {
        return prezzo;
    }

    public void setPrezzo(Double prezzo) {
        this.prezzo = prezzo;
    }

    public Integer getQuantita() {
        return quantita;
    }

    public void setQuantita(Integer quantita) {
        this.quantita = quantita;
    }

    public Editore getEditore() {
        return editore;
    }

    public void setEditore(Editore editore) {
        this.editore = editore;
    }

    @Override
    public String toString() {
        return "Libro{" +
                "id=" + id +
                ", titolo='" + titolo + '\'' +
                ", autore='" + autore + '\'' +
                ", anno=" + anno +
                ", prezzo=" + prezzo +
                ", quantita=" + quantita +
                '}';
    }
}
