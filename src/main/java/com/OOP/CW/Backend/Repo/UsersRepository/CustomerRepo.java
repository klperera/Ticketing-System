package com.OOP.CW.Backend.Repo.UsersRepository;

import com.OOP.CW.Backend.Model.Users.Customer;
import com.OOP.CW.Backend.Model.Users.UserCredentials;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CustomerRepo extends JpaRepository<Customer, Integer> {

    Optional<Customer> findByUserCredentials_EmailAndUserCredentials_Password(String email, String password);

    Optional<Customer> findByUserCredentials_Email(String email);

    Optional<Customer> findById(Integer customerID);



}
