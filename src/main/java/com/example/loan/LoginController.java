package com.example.loan;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class LoginController {

    @Autowired
    private UserLoginRepository userLoginRepository;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest loginRequest) {
        UserLogin userLogin = userLoginRepository.findByEmail(loginRequest.getEmail());

        if (userLogin != null && userLogin.getPassword().equals(loginRequest.getPassword())) {
            return ResponseEntity.ok("Login Successful");
        } else {
            return ResponseEntity.status(401).body("Invalid email or password");
        }
    }
}
