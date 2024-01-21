package com.example.springcashier.redis;


import lombok.Data;
import javax.validation.constraints.NotBlank;

@Data
public class RegistrationForm {
    @NotBlank(message = "Username is required")
    private String username;

    @NotBlank(message = "Password is required")
    private String password;

    @NotBlank(message = "Confirm Password is required")
    private String confirmPassword;

    // No need to explicitly define getters and setters


}
