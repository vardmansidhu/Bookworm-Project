package com.bookworm.bookworm_middleware.dtos;

public class InvoiceDetailDto {
    private Integer productId;
    private Integer quantity;
    private Float basePrice;
    private Float sellingPrice;
    private Integer transactionTypeId;
    private Integer rentingDays;
    private Integer invoiceId;

    public Integer getInvoiceId() {
        return invoiceId;
    }

    public void setInvoiceId(Integer invoiceId) {
        this.invoiceId = invoiceId;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Float getBasePrice() {
        return basePrice;
    }

    public void setBasePrice(Float basePrice) {
        this.basePrice = basePrice;
    }

    public Float getSellingPrice() {
        return sellingPrice;
    }

    public void setSellingPrice(Float sellingPrice) {
        this.sellingPrice = sellingPrice;
    }

    public Integer getTransactionTypeId() {
        return transactionTypeId;
    }

    public void setTransactionTypeId(Integer transactionTypeId) {
        this.transactionTypeId = transactionTypeId;
    }

    public Integer getRentingDays() {
        return rentingDays;
    }

    public void setRentingDays(Integer rentingDays) {
        this.rentingDays = rentingDays;
    }

    // getters and setters
}