package com.example.securityApplication.SecurityApp.services;

import com.example.securityApplication.SecurityApp.exceptions.ResouceNotFoundException;
import com.example.securityApplication.SecurityApp.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

//@Service
@RequiredArgsConstructor
public class UserService implements UserDetailsService {

    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository.findByEmail(username).orElseThrow(()->
                new ResouceNotFoundException("User with email "+username+" not found"));
    }
}
