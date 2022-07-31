package com.springacademy.pointofsale.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomerUpdateRequestDTO {

    private int customerId;
    private String customerName;
    private String customeAddress;
    private double customerSalary;
    private ArrayList contactNumbers;
    private String nic;
}
