package com.example.sweater.domain;

import javax.persistence.*;

@Entity
public class Check_Product {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer id_check;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User author;


    private String vin;
    private String customerName;
    private String result;

    public Check_Product(){
    }

    public Check_Product(String customerName, String engineNumber, String result, User user) {
        this.author = user;
        this.vin = engineNumber;
        this.customerName = customerName;
        this.result = result;
    }

    public Integer getId_check() {
        return id_check;
    }

    public void setId_check(Integer id_check) {
        this.id_check = id_check;
    }

    public User getAuthor() {
        return author;
    }

    public void setAuthor(User author) {
        this.author = author;
    }

    public String getVin() {
        return vin;
    }

    public void setVin(String vin) {
        this.vin = vin;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }
}
