package com.OOP.CW.Backend.Repo.UsersRepository;

import com.OOP.CW.Backend.Model.Users.Organizer;
import com.OOP.CW.Backend.Model.Users.UserCredentials;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface OrganizerRepo extends JpaRepository<Organizer, Integer> {

    Optional<Organizer> findByUserCredentials_Email(String email);
    Optional<Organizer> findByUserCredentials_EmailAndUserCredentials_Password(String email, String password);
}
