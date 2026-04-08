package com.pawpal.pawpal_backend;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class AuthDtos {

	//validation rules for registering
    public static class RegisterRequest {

        @NotBlank(message = "Email is required")
        @Email(message = "Please enter a valid email address")
        public String email;

        @NotBlank(message = "Password is required")
        @Size(min = 6, message = "Password must be at least 6 characters")
        public String password;
    }

    //validation rules for logging in
    public static class LoginRequest {

        @NotBlank(message = "Email is required")
        @Email(message = "Please enter a valid email address")
        public String email;

        @NotBlank(message = "Password is required")
        public String password;
    }

    //data returned after user successfully logs in/registers
    public static class AuthResponse {
        public Long id;
        public String email;

        public AuthResponse(Long id, String email) {
            this.id = id;
            this.email = email;
        }
    }
}