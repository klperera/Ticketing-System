package com.OOP.CW.Backend.Repo;

import com.OOP.CW.Backend.Model.Users.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepo extends JpaRepository<Customer, Integer> {
}
