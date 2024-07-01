package com.daniel.crud.model;

import jakarta.persistence.*;



@Entity
@Table(name = "users") //se crea una tabla que se llama users
public class libraryModel {
    @Id // se crea un identificador principal autoincremental
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;

    @Column(unique = true, nullable = false) //nombre debe ser unico y no vacio
    private String bookName;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }
}
