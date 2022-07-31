package com.springacademy.pointofsale.service.impl;

import com.springacademy.pointofsale.dto.CustomerDTO;
import com.springacademy.pointofsale.dto.request.CustomerSaveRequest;
import com.springacademy.pointofsale.dto.request.CustomerUpdateNameDTO;
import com.springacademy.pointofsale.dto.request.CustomerUpdateRequestDTO;
import com.springacademy.pointofsale.dto.response.ResponseActiveCustomerDTO;
import com.springacademy.pointofsale.entity.Customer;
import com.springacademy.pointofsale.repo.CustomerRepo;
import com.springacademy.pointofsale.service.CustomerService;
import com.springacademy.pointofsale.util.mappers.CustomerMapper;
import javassist.NotFoundException;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerServiceIMPL implements CustomerService {

    @Autowired
    private CustomerRepo customerRepo;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private CustomerMapper customerMapper;

    @Override
    public String saveCustomer(CustomerSaveRequest saveRequest) {
        Customer customer = new Customer(
                saveRequest.getCustomerName(),
                saveRequest.getCustomeAddress(),
                saveRequest.getCustomerSalary(),
                saveRequest.getContactNumbers(),
                saveRequest.getNic(),
                true
        );
        if (!customerRepo.existsById(customer.getCustomerId())) {
            customerRepo.save(customer);
            return customer.getCustomerName() + "saved";
        } else {
            System.out.println("already exists customer");
            return "customer id already exists";
        }
    }

    @Override
    public List<CustomerDTO> getCustomerByName(String customerName) throws NotFoundException {
        List<Customer> customers = customerRepo.findAllByCustomerNameEquals(customerName);
        if (customers.size() != 0) {
            List<CustomerDTO> customerDTOList = modelMapper
                    .map(customers, new TypeToken<List<CustomerDTO>>(){}.getType());
            return customerDTOList;
        } else {
            throw new NotFoundException("no results");
        }
    }

    @Override
    public String updateCustomer(CustomerUpdateRequestDTO customerUpdateRequestDTO) {
        if (customerRepo.existsById(customerUpdateRequestDTO.getCustomerId())) {
            Customer customer = customerRepo.getById(customerUpdateRequestDTO.getCustomerId());

            customer.setCustomerName(customerUpdateRequestDTO.getCustomerName());
            customer.setCustomerSalary(customerUpdateRequestDTO.getCustomerSalary());
            customer.setContactNumbers(customerUpdateRequestDTO.getContactNumbers());

            System.out.println("Customer" + customer);
            return customerRepo.save(customer).getCustomerName();
        } else {
            System.out.println("this customer not in database");
            return "this customer not in database";
        }

    }

    @Override
    public CustomerDTO getCustomerById(int id) {
        Optional<Customer> customer = customerRepo.findById(id);
        if (customer.isPresent()) {
//            CustomerDTO customerDTO = new CustomerDTO(
//                    customer.get().getCustomerId(),
//                    customer.get().getCustomerName(),
//                    customer.get().getCustomerAddress(),
//                    customer.get().getCustomerSalary(),
//                    customer.get().getContactNumbers(),
//                    customer.get().getNic(),
//                    customer.get().isActiveState()
//            );

//            CustomerDTO customerDTO = modelMapper.map(customer.get(), CustomerDTO.class);
            CustomerDTO customerDTO = customerMapper.enitityToDto(customer.get());
            return customerDTO;

        } else {
            return null;
        }
    }

    @Override
    public boolean deleteCustomer(int id) throws NotFoundException {
        if(customerRepo.existsById(id)){
            customerRepo.deleteById(id);
        }else {
            throw new NotFoundException("not found");
        }
        return true;
    }

    @Override
    public List<CustomerDTO> getAllCustomers() {
        List<Customer> customers = customerRepo.findAll();
//        List<CustomerDTO> customerDTOS = new ArrayList<>();

//        for (Customer c : customers) {
//            CustomerDTO customerDTO = new CustomerDTO(
//                    c.getCustomerId(),
//                    c.getCustomerName(),
//                    c.getCustomerAddress(),
//                    c.getCustomerSalary(),
//                    c.getContactNumbers(),
//                    c.getNic(),
//                    c.isActiveState()
//            );
//            customerDTOS.add(customerDTO);
//        }

//        List<CustomerDTO> customerDTOList = modelMapper
//                .map(customers, new TypeToken<List<CustomerDTO>>(){}.getType());

        List<CustomerDTO> customerDTOList = customerMapper.entityListToDtoList(customers);
        return customerDTOList;
    }

    @Override
    public List<CustomerDTO> getCustomerByActiveStatus() throws NotFoundException {
        List<Customer> customers =customerRepo.findAllByActiveState(true);
        if (customers.size() != 0) {
            List<CustomerDTO> customerDTOList = customerMapper.entityListToDtoList(customers);
            return customerDTOList;
        }
        else {
            throw new NotFoundException("no active customers found");
        }
    }

    @Override
    public List<ResponseActiveCustomerDTO> getCustomerByActiveStatusOnlyName() throws NotFoundException {
        List<Customer> customers =customerRepo.findAllByActiveState(true);
        if (customers.size() != 0) {
            List<ResponseActiveCustomerDTO> customerDTOList = customerMapper.entityListToResponseDtoList(customers);
            return customerDTOList;
        }
        else {
            throw new NotFoundException("no active customers found");
        }
    }

    @Override
    public String updateCustomerByName(CustomerUpdateNameDTO customerUpdateNameDTO, int id) {
        if(customerRepo.existsById(id)){
//            Customer customer = customerRepo.getById(id);
//            customer.setCustomerName(customerUpdateNameDTO.getCustomerName());
//            customer.setNic(customerUpdateNameDTO.getNic());
//            customerRepo.save(customer);
            customerRepo.updateCustomerByNameAndNic(customerUpdateNameDTO.getCustomerName(),customerUpdateNameDTO.getNic(),id);
            return "updated"+id;
        }else{
            System.out.println("customer not found");
            return "customer not found";
        }

    }
}

