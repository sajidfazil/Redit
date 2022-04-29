package com.anjaniy.redditclonebackend.services;

import com.anjaniy.redditclonebackend.dto.RegisterRequest;
import com.anjaniy.redditclonebackend.models.User;
import com.anjaniy.redditclonebackend.repositories.UserRepo;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.Instant;

@Service
@AllArgsConstructor
public class AuthService {

//    @Autowired
    private final PasswordEncoder passwordEncoder;

//    @Autowired
    private final UserRepo userRepo;

    @Transactional
    public void signup(RegisterRequest registerRequest){
        User user = new User();
        user.setEmail(registerRequest.getEmail());
        user.setUsername(registerRequest.getUsername());
        user.setPassword(passwordEncoder.encode(registerRequest.getPassword()));
        user.setCreateDate(Instant.now());
        user.setEnabled(false);

        userRepo.save(user);
    }
}