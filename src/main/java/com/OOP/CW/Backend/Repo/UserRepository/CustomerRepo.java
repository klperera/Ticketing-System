package com.OOP.CW.Backend.Repo.UserRepository;

import com.OOP.CW.Backend.Model.Users.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CustomerRepo extends JpaRepository<Customer, Integer> {
    boolean existsByEmail(String email);

    Optional<Customer> findByEmail(String email);
}
