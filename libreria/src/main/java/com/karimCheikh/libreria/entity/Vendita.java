package com.karimCheikh.libreria.entity;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "vendite")
public class Vendita {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "numero_vendita")
    private Integer numeroVendita;
    @Column(name = "user_id")
    private Integer userId;
    @Column(name = "libro_id")
    private Integer libroId;
    @Column
    private LocalDate localDate;

    public Vendita() {
    }

    public Vendita(Integer userId, Integer libroId, LocalDate localDate) {
        this.userId = userId;
        this.libroId = libroId;
        this.localDate = localDate;
    }

    public Integer getNumeroVendita() {
        return numeroVendita;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getLibroId() {
        return libroId;
    }

    public void setLibroId(Integer libroId) {
        this.libroId = libroId;
    }

    public LocalDate getLocalDate() {
        return localDate;
    }

    public void setLocalDate(LocalDate localDate) {
        this.localDate = localDate;
    }

    @Override
    public String toString() {
        return "Vendita{" +
                "numeroVendita=" + numeroVendita +
                ", userId=" + userId +
                ", libroId=" + libroId +
                ", localDate=" + localDate +
                '}';
    }
}
