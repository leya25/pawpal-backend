package com.pawpal.pawpal_backend;

import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/pets")
@CrossOrigin(origins = "*")
public class PetController {

    private final PetRepository petRepository;
    private final UserRepository userRepository;

    public PetController(PetRepository petRepository, UserRepository userRepository) {
        this.petRepository = petRepository;
        this.userRepository = userRepository;
    }

    //process of creating a pet linked to a user
    @PostMapping
    public Pet createPet(@RequestParam Long userId, @RequestBody Pet pet) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("No user found with this Id"));

        pet.setUser(user);
        return petRepository.save(pet);
    }

    @GetMapping
    public List<Pet> getAllPets() {
        return petRepository.findAll();
    }

    //returns all pets linked to a user Id
    @GetMapping("/user/{userId}")
    public List<Pet> getPetsByUserId(@PathVariable Long userId) {
        return petRepository.findByUserId(userId);
    }

    @GetMapping("/email/{email}")
    public List<Pet> getPetsByUserEmail(@PathVariable String email) {
        return petRepository.findByUserEmail(email);
    }
}