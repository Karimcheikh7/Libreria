package com.karimCheikh.libreria.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "ordini")
public class Ordine {

    @Id
    @GeneratedValue
    @Column(name = "id_ordine")
    private Integer id;
    @Column(name = "libro_id")
    private Integer libroId;
    @Column(name = "quantita_ordine")
    private Integer quantitaOrdine;

    public Ordine() {
    }

    public Ordine(Integer libroId, Integer quantitaOrdine) {
        this.libroId = libroId;
        this.quantitaOrdine = quantitaOrdine;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getLibroId() {
        return libroId;
    }

    public void setLibroId(Integer libroId) {
        this.libroId = libroId;
    }

    public Integer getQuantitaOrdine() {
        return quantitaOrdine;
    }

    public void setQuantitaOrdine(Integer quantitaOrdine) {
        this.quantitaOrdine = quantitaOrdine;
    }

    @Override
    public String toString() {
        return "Ordine{" +
                "id=" + id +
                ", libroId=" + libroId +
                ", quantitaOrdine=" + quantitaOrdine +
                '}';
    }
}
