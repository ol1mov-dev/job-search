package com.projects.project.services.auth;

import com.projects.project.commons.Role;
import com.projects.project.controllers.requests.auth.AuthenticateUserRequest;
import com.projects.project.controllers.requests.auth.RegisterUserRequest;
import com.projects.project.controllers.responses.auth.JwtResponse;
import com.projects.project.models.User;
import com.projects.project.repositories.UserRepository;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthenticationService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private JwtService jwtService;
    @Autowired
    private PasswordEncoder passwordEncoder;

    public ResponseEntity<JwtResponse> register(@Valid RegisterUserRequest request) {
        userRepository.save(
                User
                    .builder()
                    .firstName(request.firstname())
                    .lastName(request.lastname())
                    .email(request.email())
                    .password(
                            passwordEncoder.encode(request.password())
                    )
                    .role(Role.ADMIN)
                    .build()
        );

        String jwtToken = jwtService.generateToken(request.email());
        return ResponseEntity.ok(
                JwtResponse.builder().token(jwtToken).build()
        );
    }

    public ResponseEntity<JwtResponse> authenticate(AuthenticateUserRequest request) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(request.email(), request.password())
        );

        if (authentication.isAuthenticated()) {
            return ResponseEntity.ok(
                    JwtResponse.builder()
                            .token(jwtService.generateToken(request.email()))
                            .build()
            );
        }
        return ResponseEntity.ok(JwtResponse.builder().token(null).build());
    }
}
