package com.example.sweater.domain;

import javax.persistence.*;

@Entity
public class Product {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer idProduct;

    private String modelProduct;
    private String vin;
    private String number;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    private User author;

    public Product() {
    }

    public Product(String modelProduct, String vin, String number, User user) {
        this.author = user;
        this.modelProduct = modelProduct;
        this.vin = vin;
        this.number = number;
    }

    public Product(Integer idProduct, String vin, String number, String modelProduct,User user) {
        this.idProduct = idProduct;
        this.modelProduct = modelProduct;
        this.vin = vin;
        this.number = number;
        this.author = user;
    }

    public Integer getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(Integer idProduct) {
        this.idProduct = idProduct;
    }

    public String getModelProduct() {
        return modelProduct;
    }

    public void setModelProduct(String modelProduct) {
        this.modelProduct = modelProduct;
    }

    public String getVin() {
        return vin;
    }

    public void setVin(String vin) {
        this.vin = vin;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public User getAuthor() {
        return author;
    }

    public void setAuthor(User author) {
        this.author = author;
    }

    @Override
    public String toString() {
        return "Product{" +
                "idProduct=" + idProduct +
                ", modelProduct='" + modelProduct + '\'' +
                ", vin='" + vin + '\'' +
                ", number='" + number + '\'' +
                ", author=" + author +
                '}';
    }
}
