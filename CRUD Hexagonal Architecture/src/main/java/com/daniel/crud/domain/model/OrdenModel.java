package com.daniel.crud.domain.model;

public class OrdenModel {
    private Long id;
    private String product;
    private int quantity;

    public OrdenModel(Long id, int quantity, String product) {
        this.id = id;
        this.quantity = quantity;
        this.product = product;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
