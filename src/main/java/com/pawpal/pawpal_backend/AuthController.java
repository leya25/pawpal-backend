package com.pawpal.pawpal_backend;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin(origins = "*") // dev only; later restrict

public class AuthController {

    private final UserRepository userRepository;
    private final BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

    public AuthController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    //user sign-up process
    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody AuthDtos.RegisterRequest req) {
    	
    	//check if email and password inputs are valid
        if (req.email == null || req.email.trim().isEmpty() || req.password == null || req.password.length() < 6) {
            return ResponseEntity.badRequest().body("Email is empty and password must be a minimum of 6 characters.");
        }

        String email = req.email.trim().toLowerCase();

        //if user already exists, send a bad request to prevent duplicate accounts
        if (userRepository.existsByEmail(email)) {
            return ResponseEntity.badRequest().body("Email already registered.");
        }

        User u = new User();
        u.setEmail(email);
        u.setPasswordHash(encoder.encode(req.password));  //save a hashed password

        User saved = userRepository.save(u);
        return ResponseEntity.ok(new AuthDtos.AuthResponse(saved.getId(), saved.getEmail()));
    }

    //user login process
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody AuthDtos.LoginRequest req) {
        if (req.email == null || req.password == null) {
            return ResponseEntity.badRequest().body("Email and password are empty.");
        }

        String email = req.email.trim().toLowerCase();

        return userRepository.findByEmail(email)
                .map(user -> {
                    boolean ok = encoder.matches(req.password, user.getPasswordHash());
                    if (!ok) return ResponseEntity.status(401).body("Invalid email or password.");
                    return ResponseEntity.ok(new AuthDtos.AuthResponse(user.getId(), user.getEmail()));
                })
                .orElse(ResponseEntity.status(401).body("Invalid email or password."));
    }
}
