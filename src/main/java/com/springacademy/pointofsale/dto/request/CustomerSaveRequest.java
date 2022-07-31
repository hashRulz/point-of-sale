package com.springacademy.pointofsale.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.ArrayList;

@AllArgsConstructor
@NoArgsConstructor
@ToString
@Data
public class CustomerSaveRequest {
    private String customerName;
    private String customeAddress;
    private double customerSalary;
    private ArrayList contactNumbers;
    private String nic;
}
