package com.example.SaleCampaign.Model;

import jakarta.persistence.*;


import java.time.LocalDate;
import java.util.List;

@Entity
public class Campaign {

    @Id
    @Column(name = "cid")
    private int cId;
    @Column(name = "c_name")
    private String cName;
    @Column(name = "start_date")
    private LocalDate startDate;
    @Column(name = "end_date")
    private LocalDate endDate;
    @OneToMany(mappedBy = "campaign", cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    private List<Discount> discounts;

    public Campaign(int cId, String cName, LocalDate startDate, LocalDate endDate, List<Discount> discounts) {
        this.cId = cId;
        this.cName = cName;
        this.startDate = startDate;
        this.endDate = endDate;
        this.discounts = discounts;
    }

    public int getcId() {
        return cId;
    }

    public void setcId(int cId) {
        this.cId = cId;
    }

    public String getcName() {
        return cName;
    }

    public void setcName(String cName) {
        this.cName = cName;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public List<Discount> getDiscounts() {
        return discounts;
    }

    public void setDiscounts(List<Discount> discounts) {
        this.discounts = discounts;
    }

    public Campaign() {
    }
}