package com.OOP.CW.Backend.Repo.UserRepository;

import com.OOP.CW.Backend.Model.Users.Customer;
import com.OOP.CW.Backend.Model.Users.Organizer;
import com.OOP.CW.Backend.Model.Users.UserCredentials;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface OrganizerRepo extends JpaRepository<Organizer, Integer> {

    Optional<UserCredentials> findByuserCredentials(String email);

}
