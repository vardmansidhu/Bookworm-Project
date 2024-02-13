package com.bookworm.bookworm_middleware.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "rent")
public class Rent {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "rent_id")
    private int rentId;

    @Column(name = "product_id")
    private int productId;

    @Column(name = "customer_id")
    private int customerId;

    @Column(name = "rent_start_date")
    private String rentStartDate;

    @Column(name = "rent_end_date")
    private String rentEndDate;

    @Column(name = "total_price")
    private float totalPrice;

    @Column(name = "status")
    private String status;

    public int getRentId() {
        return rentId;
    }

    public void setRentId(int rentId) {
        this.rentId = rentId;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public String getRentStartDate() {
        return rentStartDate;
    }

    public void setRentStartDate(String rentStartDate) {
        this.rentStartDate = rentStartDate;
    }

    public String getRentEndDate() {
        return rentEndDate;
    }

    public void setRentEndDate(String rentEndDate) {
        this.rentEndDate = rentEndDate;
    }

    public float getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(float totalPrice) {
        this.totalPrice = totalPrice;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Rent{" +
                "rentId=" + rentId +
                ", productId=" + productId +
                ", customerId=" + customerId +
                ", rentStartDate='" + rentStartDate + '\'' +
                ", rentEndDate='" + rentEndDate + '\'' +
                ", totalPrice=" + totalPrice +
                ", status='" + status + '\'' +
                '}';
    }
}
