package com.OOP.CW.Backend.Repo.UserRepository;

import com.OOP.CW.Backend.Model.Users.Organizer;
import com.OOP.CW.Backend.Model.Users.Vendor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface VendorRepo extends JpaRepository<Vendor, Integer> {
    boolean existsByEmail(String email);

    Optional<Vendor> findByEmail(String email);
}
