package com.example.sweater.domain;

import javax.persistence.*;

@Entity
public class Customer {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer idCustomer;

    private String customerName;
    private String year;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    private User author;

    public Customer() {
    }

    public Customer(String customerName, String year, User user) {
        this.customerName = customerName;
        this.year = year;
        this.author = user;
    }

    public Customer(String customerName, String year, Integer idCustomer, User user) {
        this.customerName = customerName;
        this.year = year;
        this.author = user;
        this.idCustomer = idCustomer;
    }

    public String getAuthorName() {
        return author != null ? author.getUsername() : "<none>";
    }

    public User getAuthor() {
        return author;
    }

    public void setAuthor(User author) {
        this.author = author;
    }

    public Integer getIdCustomer() {
        return idCustomer;
    }

    public void setIdCustomer(Integer idCustomer) {
        this.idCustomer = idCustomer;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }




    @Override
    public String toString() {
        return "Customer{" +
                "idCustomer=" + idCustomer +
                ", customerName='" + customerName + '\'' +
                ", year='" + year + '\'' +
                ", author=" + author +
                '}';
    }
}
