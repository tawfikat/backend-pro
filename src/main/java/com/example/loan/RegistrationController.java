package com.example.loan;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class RegistrationController {

    private final RegistrationService registrationService;


    @Autowired
    public RegistrationController(RegistrationService registrationService) {
        this.registrationService = registrationService;
    }

    @PostMapping("/register")
    public User registerUser(@RequestBody User user) {
        return registrationService.registerNewUser(user);
    }

    @GetMapping("/user/{email}")
    public User getUserByEmail(@PathVariable String email) {
        return registrationService.findByEmail(email);
    }
}
