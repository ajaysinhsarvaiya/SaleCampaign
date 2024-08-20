package com.example.SaleCampaign.Model;

import jakarta.persistence.*;


@Entity
public class Discount {
    @Id
    @Column(name = "did")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int dId;
    @Column(name = "d_rate")
    private double dRete;
    @ManyToOne
    private Product product;
    @ManyToOne
    private Campaign campaign;

    public Discount(int dId, double dRete, Product product, Campaign campaign) {
        this.dId = dId;
        this.dRete = dRete;
        this.product = product;
        this.campaign = campaign;
    }

    public int getdId() {
        return dId;
    }

    public void setdId(int dId) {
        this.dId = dId;
    }

    public double getdRete() {
        return dRete;
    }

    public void setdRete(double dRete) {
        this.dRete = dRete;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Campaign getCampaign() {
        return campaign;
    }

    public void setCampaign(Campaign campaign) {
        this.campaign = campaign;
    }

    public Discount() {
    }
}
