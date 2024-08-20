package com.example.SaleCampaign.Model;

import jakarta.persistence.*;


import java.time.LocalDate;

@Entity
public class History {

    @Id
    @Column(name = "h_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int hid;
    @Column(name = "price")
    private double price;
    @Column(name = "date")
    private LocalDate localDate;
    @Column(name = "discount")
    private double discount;
    @ManyToOne
    private Product product;

    public History(int hid, double price, LocalDate localDate, double discount, Product product) {
        this.hid = hid;
        this.price = price;
        this.localDate = localDate;
        this.discount = discount;
        this.product = product;
    }

    public int getHid() {
        return hid;
    }

    public void setHid(int hid) {
        this.hid = hid;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public LocalDate getLocalDate() {
        return localDate;
    }

    public void setLocalDate(LocalDate localDate) {
        this.localDate = localDate;
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public History() {
    }
}
