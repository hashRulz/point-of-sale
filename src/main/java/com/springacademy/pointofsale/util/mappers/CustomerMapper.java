package com.springacademy.pointofsale.util.mappers;

import com.springacademy.pointofsale.dto.CustomerDTO;
import com.springacademy.pointofsale.dto.response.CustomerSalaryNameDTO;
import com.springacademy.pointofsale.dto.response.ResponseActiveCustomerDTO;
import com.springacademy.pointofsale.entity.Customer;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CustomerMapper {

    CustomerDTO enitityToDto(Customer customer);

    List<CustomerDTO> entityListToDtoList(List<Customer> customers);

    List<ResponseActiveCustomerDTO> entityListToResponseDtoList(List<Customer> customers);

    CustomerSalaryNameDTO customerDto(Customer customer);
}
