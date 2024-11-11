package com.OOP.CW.Backend.Repo.UserRepository;

import com.OOP.CW.Backend.Model.Users.Organizer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface OrganizerRepo extends JpaRepository<Organizer, Integer> {
    boolean existsByEmail(String email);

    Optional<Organizer> findByEmail(String email);

}
