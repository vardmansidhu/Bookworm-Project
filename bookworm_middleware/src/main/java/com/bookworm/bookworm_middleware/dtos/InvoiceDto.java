package com.bookworm.bookworm_middleware.dtos;

import java.util.Date;
import java.util.List;
// import com.bookworm.bookworm_middleware.dtos.InvoiceDetailDto;

public class InvoiceDto {
    private Date invoiceDate;
    private Integer customerId;
    private Float invoiceAmount;
    private int quantity;
    private List<InvoiceDetailDto> invoiceDetails;

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Date getInvoiceDate() {
        return invoiceDate;
    }

    public void setInvoiceDate(Date invoiceDate) {
        this.invoiceDate = invoiceDate;
    }

    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    public Float getInvoiceAmount() {
        return invoiceAmount;
    }

    public void setInvoiceAmount(Float invoiceAmount) {
        this.invoiceAmount = invoiceAmount;
    }

    public List<InvoiceDetailDto> getInvoiceDetails() {
        return invoiceDetails;
    }

    public void setInvoiceDetails(List<InvoiceDetailDto> invoiceDetails) {
        this.invoiceDetails = invoiceDetails;
    }

    @Override
    public String toString() {
        return "InvoiceDto [customerId=" + customerId + ", invoiceAmount=" + invoiceAmount + ", invoiceDate="
                + invoiceDate
                + ", invoiceDetails=" + invoiceDetails + ", quantity=" + quantity + "]";
    }

}