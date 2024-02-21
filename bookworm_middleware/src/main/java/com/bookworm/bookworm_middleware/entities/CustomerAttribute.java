package com.bookworm.bookworm_middleware.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "customer_attribute")
public class CustomerAttribute {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int custAttId;

    @Column(name = "attribute_desc")
    private String attributeDesc;

    public CustomerAttribute() {

    }

    public CustomerAttribute(String attributeDesc) {
        this.attributeDesc = attributeDesc;
    }

    public int getCustAttId() {
        return custAttId;
    }

    public void setCustAttId(int custAttId) {
        this.custAttId = custAttId;
    }

    public String getAttributeDesc() {
        return attributeDesc;
    }

    public void setAttributeDesc(String attributeDesc) {
        this.attributeDesc = attributeDesc;
    }

    @Override
    public String toString() {
        return "CustomerAttribute{" +
                "custAttId=" + custAttId +
                ", attributeDesc='" + attributeDesc + '\'' +
                '}';
    }
}
