package com.daniel.crud.model;


import jakarta.persistence.*;

@Entity
@Table(name = "users") //se crea una tabla que se llama users
public class libraryModel {
    @Id // se crea un identificador principal autoincremental
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;
    @Column(unique = true) //nombre debe ser unico
    private String bookName;
    private Long fechaPrestamo;
    private Long fechaDevolucion;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getFechaDevolucion() {
        return fechaDevolucion;
    }

    public void setFechaDevolucion(Long fechaDevolucion) {
        this.fechaDevolucion = fechaDevolucion;
    }

    public Long getFechaPretamo() {
        return fechaPrestamo;
    }

    public void setFechaPretamo(Long fechaPretamo) {
        this.fechaPrestamo = fechaPretamo;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }
}
