package com.springacademy.pointofsale.service;

import com.springacademy.pointofsale.dto.CustomerDTO;
import com.springacademy.pointofsale.dto.request.CustomerSaveRequest;
import com.springacademy.pointofsale.dto.request.CustomerUpdateNameDTO;
import com.springacademy.pointofsale.dto.request.CustomerUpdateRequestDTO;
import com.springacademy.pointofsale.dto.response.ResponseActiveCustomerDTO;
import javassist.NotFoundException;

import java.util.List;

public interface CustomerService {
    String saveCustomer(CustomerSaveRequest customerSaveRequest);

    List<CustomerDTO> getCustomerByName(String customerName) throws NotFoundException;

    boolean deleteCustomer(int id) throws NotFoundException;

    String updateCustomer(CustomerUpdateRequestDTO customerUpdateRequestDTO);

    CustomerDTO getCustomerById(int id);

    List<CustomerDTO> getAllCustomers();

    List<CustomerDTO> getCustomerByActiveStatus() throws NotFoundException;

    List<ResponseActiveCustomerDTO> getCustomerByActiveStatusOnlyName() throws NotFoundException;

    String updateCustomerByName(CustomerUpdateNameDTO customerUpdateNameDTO, int id);
}
