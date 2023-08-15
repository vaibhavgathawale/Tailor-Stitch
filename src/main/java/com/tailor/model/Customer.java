package com.tailor.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.autoconfigure.domain.EntityScan;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Data
@NoArgsConstructor
public class Customer {


    private String id;
    @Id
    private String serialNumber;
    private String customerName;
    private String mobileNumber;
    private String dateOfBirth;



    @Override
    public String toString() {
        return "Customer{" +
                "id='" + id + '\'' +
                ", serialNumber='" + serialNumber + '\'' +
                ", customerName='" + customerName + '\'' +
                ", mobileNumber='" + mobileNumber + '\'' +
                ", dateOfBirth='" + dateOfBirth + '\'' +
                '}';
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getId() {
        return id;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public String getCustomerName() {
        return customerName;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public Customer(String id, String serialNumber, String customerName, String mobileNumber, String dateOfBirth) {
        this.id = id;
        this.serialNumber = serialNumber;
        this.customerName = customerName;
        this.mobileNumber = mobileNumber;
        this.dateOfBirth = dateOfBirth;
    }
}
