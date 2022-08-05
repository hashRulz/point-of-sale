package com.springacademy.pointofsale.controller;

import com.springacademy.pointofsale.dto.CustomerDTO;
import com.springacademy.pointofsale.dto.request.CustomerSaveRequest;
import com.springacademy.pointofsale.dto.request.CustomerUpdateNameDTO;
import com.springacademy.pointofsale.dto.request.CustomerUpdateRequestDTO;
import com.springacademy.pointofsale.dto.response.CustomerSalaryNameDTO;
import com.springacademy.pointofsale.dto.response.ResponseActiveCustomerDTO;
import com.springacademy.pointofsale.service.CustomerService;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.converter.json.GsonBuilderUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("api/v1/customer")

public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @PostMapping(path = "/save")
    public CustomerSaveRequest saveCustomer(@RequestBody CustomerSaveRequest customerSaveRequest) {
        System.out.println("came" + customerSaveRequest.getCustomerName());
        customerService.saveCustomer(customerSaveRequest);
        return customerSaveRequest;
    }

    @PutMapping(path = "/update")
    public String updateCustomer(@RequestBody CustomerUpdateRequestDTO customerUpdateRequestDTO) {
        String updated = customerService.updateCustomer(customerUpdateRequestDTO);
        return updated;
    }

    @DeleteMapping(path = "delete-customer/{id}")
    public String deleteCustomer(@PathVariable(value = "id") int id) throws NotFoundException {
        boolean deletedCustomer = customerService.deleteCustomer(id);
        return "deleted";
    }

    @GetMapping(path = "/get-by-id", params = "id")
    public CustomerDTO getCustomerById(@RequestParam(value = "id") int id) {
        CustomerDTO customerDTO = customerService.getCustomerById(id);
        return customerDTO;
    }


    @GetMapping(path = {"/get-by-name"}, params = {"name"})
    public List<CustomerDTO> getCustomerByName(@RequestParam(value = "name") String customerName) throws NotFoundException {
        List<CustomerDTO> customerDTOList = customerService.getCustomerByName(customerName);
        return customerDTOList;
    }

    @GetMapping(path = "/getAll")
    public List<CustomerDTO> getAllCustomers() {
        List<CustomerDTO> customerDTOS = customerService.getAllCustomers();
        return customerDTOS;
    }

    @GetMapping(path = "/get-by-active-status")
    public List<CustomerDTO> getCustomerByActiveStatus() throws NotFoundException {
        List<CustomerDTO> customerDTOS= customerService.getCustomerByActiveStatus();
        return customerDTOS;
    }

    @GetMapping(path = "/get-by-active-status-only-name")
    public List<ResponseActiveCustomerDTO> getCustomerByActiveStatusOnlyName() throws NotFoundException {
        List<ResponseActiveCustomerDTO> customerDTOS= customerService.getCustomerByActiveStatusOnlyName();
        return customerDTOS;
    }

    @PutMapping(path = "/update-customer/{id}")
    public String updateCustomer(@RequestBody CustomerUpdateNameDTO customerUpdateNameDTO, @PathVariable(value = "id") int id) {
        String updated = customerService.updateCustomerByName(customerUpdateNameDTO,id);
        return updated;
    }

    @GetMapping(path = {"/get-by-nic"}, params = {"nic"})
    public CustomerDTO getCustomerByNic(@RequestParam(value = "nic") String nic) throws NotFoundException {
        CustomerDTO customerDTO = customerService.getCustomerByNic(nic);
        return customerDTO;
    }

    @GetMapping(path = "/get-salary-address-id", params = "id")
    public CustomerSalaryNameDTO getCustomerSalaryAndAddressById(@RequestParam(value = "id") int id) {
        CustomerSalaryNameDTO customerDTO = customerService.getCustomerSalaryAndAddressById(id);
        return customerDTO;
    }

    @GetMapping(path = "/get-customer-details-by-status/{id}")
    public CustomerDTO getCustomerDetailsByStatus(@PathVariable (value = "id") int id) throws NotFoundException {
        CustomerDTO customerDTO= customerService.getCustomerDetailsByStatus(id);
        return customerDTO;
    }



}
