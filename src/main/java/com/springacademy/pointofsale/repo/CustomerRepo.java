package com.springacademy.pointofsale.repo;

import com.springacademy.pointofsale.dto.CustomerDTO;
import com.springacademy.pointofsale.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@EnableJpaRepositories
@Repository
@Transactional
public interface CustomerRepo extends JpaRepository<Customer,Integer> {

    List<Customer> findAllByCustomerNameEquals(String name);

    List<Customer> findAllByActiveState(boolean b);

    @Modifying
    @Query(value=" update customer set customer_name = ?1 ,nic = ?2 where customer_id = ?3" ,nativeQuery=true)
    void updateCustomerByNameAndNic(String customerName, String nic, int id);
}
