package com.example.SaleCampaign.Model;

import jakarta.persistence.*;


import java.util.List;


@Entity
public class Product {
    @Id
    @Column(name = "pid")
    private int pId;
    @Column(name = "title")
        private String title;
    @Column(name = "description")
    private String description;
    @Column(name = "mrp")
    private double mrp;
    @Column(name = "c_price")
    private double currentPrice;
    @Column(name = "Inventorycount")
    private int inventoryCount;
    @Column(name = "discount")
    private double discount;

    @OneToMany(mappedBy = "product",cascade = CascadeType.ALL)
    private List<Discount>discounts;
    @OneToMany(mappedBy = "product",cascade = CascadeType.ALL)
    private List<History>histories;

    public Product(int pId, String title, String description, double mrp, double currentPrice, int inventoryCount, double discount, List<Discount> discounts, List<History> histories) {
        this.pId = pId;
        this.title = title;
        this.description = description;
        this.mrp = mrp;
        this.currentPrice = currentPrice;
        this.inventoryCount = inventoryCount;
        this.discount = discount;
        this.discounts = discounts;
        this.histories = histories;
    }

    public Product(int pId) {
        this.pId = pId;
    }

    public int getpId() {
        return pId;
    }

    public void setpId(int pId) {
        this.pId = pId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getMrp() {
        return mrp;
    }

    public void setMrp(double mrp) {
        this.mrp = mrp;
    }

    public double getCurrentPrice() {
        return currentPrice;
    }

    public void setCurrentPrice(double currentPrice) {
        this.currentPrice = currentPrice;
    }

    public int getInventoryCount() {
        return inventoryCount;
    }

    public void setInventoryCount(int inventoryCount) {
        this.inventoryCount = inventoryCount;
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    public List<Discount> getDiscounts() {
        return discounts;
    }

    public void setDiscounts(List<Discount> discounts) {
        this.discounts = discounts;
    }

    public List<History> getHistories() {
        return histories;
    }

    public void setHistories(List<History> histories) {
        this.histories = histories;
    }

    public Product() {
    }
}
