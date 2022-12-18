package com.group12.bookinghomestay.client.model;

import javax.persistence.*;

@Entity
@Table(name = "voucher")
public class Voucher {
    @Id
    @Column(name = "id")
    private String id;

    @Column(name = "rate")
    private Double rate;

    @Column(name = "description")
    private String description;

    @Column(name = "status")
    private Integer status;

    @Column(name = "expired_date")
    private java.sql.Date expiredDate;

    @Column(name = "minimum_spending")
    private Double minimumSpending;

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Double getRate() {
        return this.rate;
    }

    public void setRate(Double rate) {
        this.rate = rate;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getStatus() {
        return this.status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public java.sql.Date getExpiredDate() {
        return this.expiredDate;
    }

    public void setExpiredDate(java.sql.Date expiredDate) {
        this.expiredDate = expiredDate;
    }

    public Double getMinimumSpending() {
        return this.minimumSpending;
    }

    public void setMinimumSpending(Double minimumSpending) {
        this.minimumSpending = minimumSpending;
    }
}
