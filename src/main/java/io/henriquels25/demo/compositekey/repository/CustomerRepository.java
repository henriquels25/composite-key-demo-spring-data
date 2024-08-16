package io.henriquels25.demo.compositekey.repository;

import io.henriquels25.demo.compositekey.model.Customer;
import io.henriquels25.demo.compositekey.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
}

