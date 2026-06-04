package com.example.securityApplication.SecurityApp.services;

import com.example.securityApplication.SecurityApp.dto.LoginDTO;
import com.example.securityApplication.SecurityApp.dto.SignUpDTO;
import com.example.securityApplication.SecurityApp.dto.UserDTO;
import com.example.securityApplication.SecurityApp.entities.User;
import com.example.securityApplication.SecurityApp.exceptions.ResouceNotFoundException;
import com.example.securityApplication.SecurityApp.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService implements UserDetailsService {

    private final UserRepository userRepository;
    private final ModelMapper modelMapper;
    private final PasswordEncoder passwordEncoder;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository.findByEmail(username).orElseThrow(()->
                new ResouceNotFoundException("User with email "+username+" not found"));
    }

    public UserDTO signUp(SignUpDTO signUpDTO) {
        Optional<User>user=userRepository.findByEmail(signUpDTO.getEmail());
        if (user.isPresent()){
            throw new BadCredentialsException("User is alrady exists with email "+signUpDTO.
                    getEmail());
        }

        User toBeCreatedUser=modelMapper.map(signUpDTO,User.class);
        toBeCreatedUser.setPassword(passwordEncoder.encode(toBeCreatedUser.getPassword()));
        User savedUser=userRepository.save(toBeCreatedUser);
        return modelMapper.map(savedUser,UserDTO.class);

    }


}
