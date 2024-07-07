package com.daniel.crud.domain.model;



public class OrdenModel {
    private String product;
    private int quantity;

    public OrdenModel(int quantity, String product) {
        this.quantity = quantity;
        this.product = product;
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
