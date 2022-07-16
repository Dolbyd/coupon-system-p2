package com.jb.couponsystemp2.repos;

import com.jb.couponsystemp2.beans.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer> {

    boolean existsByEmail(String email);

    boolean existsByEmailAndPassword(String email, String password);

    Customer findByEmail(String email);
}
