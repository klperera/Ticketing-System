package com.OOP.CW.Backend.Repo;

import com.OOP.CW.Backend.Model.Users.Organizer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrganizerRepo extends JpaRepository<Organizer, Integer> {
}
