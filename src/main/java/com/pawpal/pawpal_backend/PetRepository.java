package com.pawpal.pawpal_backend;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

//find all pets belonging to a user using their email and userID
public interface PetRepository extends JpaRepository<Pet, Long> {
    List<Pet> findByUserEmail(String email);
    List<Pet> findByUserId(Long userId);
}