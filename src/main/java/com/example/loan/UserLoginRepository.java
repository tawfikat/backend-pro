package com.example.loan;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserLoginRepository extends JpaRepository<UserLogin, Long> {
    UserLogin findByEmail(String email);
}
