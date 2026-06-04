package com.example.securityApplication.SecurityApp.controllers;

import com.example.securityApplication.SecurityApp.dto.LoginDTO;
import com.example.securityApplication.SecurityApp.dto.SignUpDTO;
import com.example.securityApplication.SecurityApp.dto.UserDTO;
import com.example.securityApplication.SecurityApp.services.AuthService;
import com.example.securityApplication.SecurityApp.services.UserService;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.Data;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@Data
public class AuthController {

    private final UserService userService;
    private final AuthService authService;

    @PostMapping("/signup")
    public ResponseEntity<UserDTO>signUp(@RequestBody SignUpDTO signUpDTO){
        UserDTO userDTO=userService.signUp(signUpDTO);
        return ResponseEntity.ok(userDTO);
    }

    @PostMapping("/login")
    public ResponseEntity<String>login(@RequestBody LoginDTO loginDTO,
                                       HttpServletRequest request,
                                       HttpServletResponse response){
        String token= authService.login(loginDTO);

        Cookie cookie=new Cookie("token",token);
        cookie.setHttpOnly(true);
        response.addCookie(cookie);

        return ResponseEntity.ok(token);
    }
}
