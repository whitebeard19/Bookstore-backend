package com.bookstorelite.backend.controller;

import com.bookstorelite.backend.dto.AuthRequest;
import com.bookstorelite.backend.dto.AuthResponse;
import com.bookstorelite.backend.dto.RegisterRequest;
import com.bookstorelite.backend.service.AuthService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/register")
    public ResponseEntity<AuthResponse> register(@Valid @RequestBody RegisterRequest req){
        var resp = authService.register(req);
        return ResponseEntity.ok(resp);
    }

    @PostMapping("/login")
    public ResponseEntity<AuthResponse> login(@Valid @RequestBody AuthRequest req){
        var resp = authService.login(req);
        return ResponseEntity.ok(resp);
    }

}
