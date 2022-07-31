package com.springacademy.pointofsale.entity;


import com.vladmihalcea.hibernate.type.json.JsonType;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Objects;

@Entity
@Table(name = "customer")
@TypeDefs({
        @TypeDef(name = "json",typeClass = JsonType.class)
})
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "customer_id", length = 45)
    private int customerId;

    @Column(name = "customer_name", length = 100 , nullable = false)
    private String customerName;

    @Column(name = "customer_address", length = 150)
    private String customerAddress;

    @Column(name = "customer_salary", length = 25)
    private double customerSalary;

    @Type(type ="json" )
    @Column(name = "contact_numbers", columnDefinition = "json")
    private ArrayList contactNumbers;

    @Column(name = "nic", length = 12, unique = true)
    private String nic;

    @Column(name = "active_state", columnDefinition = "TINYINT default 1")
    private boolean activeState;

    public Customer() {
    }

    public Customer(int customerId, String customerName, String customeAddress, double customerSalary, ArrayList contactNumbers, String nic, boolean activeState) {
        this.customerId = customerId;
        this.customerName = customerName;
        this.customerAddress = customeAddress;
        this.customerSalary = customerSalary;
        this.contactNumbers = contactNumbers;
        this.nic = nic;
        this.activeState = activeState;
    }

    public Customer(String customerName, String customeAddress, String nic, ArrayList contactNumbers, boolean activeState) {
    }

    public Customer(String customerName, String customeAddress, double customerSalary, ArrayList contactNumbers, String nic, boolean activeState) {
        this.customerName = customerName;
        this.customerAddress = customeAddress;
        this.customerSalary = customerSalary;
        this.contactNumbers = contactNumbers;
        this.nic = nic;
        this.activeState = activeState;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerAddress() {
        return customerAddress;
    }

    public void setCustomerAddress(String customeAddress) {
        this.customerAddress = customeAddress;
    }

    public double getCustomerSalary() {
        return customerSalary;
    }

    public void setCustomerSalary(double customerSalary) {
        this.customerSalary = customerSalary;
    }

    public ArrayList getContactNumbers() {
        return contactNumbers;
    }

    public void setContactNumbers(ArrayList contactNumbers) {
        this.contactNumbers = contactNumbers;
    }

    public String getNic() {
        return nic;
    }

    public void setNic(String nic) {
        this.nic = nic;
    }

    public boolean isActiveState() {
        return activeState;
    }

    public void setActiveState(boolean activeState) {
        this.activeState = activeState;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "customerId=" + customerId +
                ", customerName='" + customerName + '\'' +
                ", customeAddress='" + customerAddress + '\'' +
                ", customerSalary=" + customerSalary +
                ", contactNumbers=" + contactNumbers +
                ", nic='" + nic + '\'' +
                ", activeState=" + activeState +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Customer customer = (Customer) o;
        return customerId == customer.customerId &&
                Double.compare(customer.customerSalary, customerSalary) == 0 &&
                activeState == customer.activeState &&
                Objects.equals(customerName, customer.customerName) &&
                Objects.equals(customerAddress, customer.customerAddress) &&
                Objects.equals(contactNumbers, customer.contactNumbers) &&
                Objects.equals(nic, customer.nic);
    }

    @Override
    public int hashCode() {
        return Objects.hash(customerId, customerName, customerAddress, customerSalary, contactNumbers, nic, activeState);
    }
}
