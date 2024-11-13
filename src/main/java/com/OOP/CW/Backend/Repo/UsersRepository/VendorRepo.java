package com.OOP.CW.Backend.Repo.UsersRepository;

import com.OOP.CW.Backend.Model.Users.UserCredentials;
import com.OOP.CW.Backend.Model.Users.Vendor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface VendorRepo extends JpaRepository<Vendor, Integer> {

    Optional<Vendor> findByUserCredentials_Email(String email);
}
