package com.projects.project.controllers.auth;

import com.projects.project.controllers.requests.auth.AuthenticateUserRequest;
import com.projects.project.controllers.requests.auth.RegisterUserRequest;
import com.projects.project.controllers.responses.auth.JwtResponse;
import com.projects.project.services.auth.AuthenticationService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthenticationController {

    @Autowired
    private final AuthenticationService authenticationService;

    @PostMapping("/register")
    public ResponseEntity<JwtResponse> register(
            @RequestBody RegisterUserRequest request
    ) { return authenticationService.register(request); }

    @PostMapping
    public ResponseEntity<JwtResponse> authenticate(
            @RequestBody AuthenticateUserRequest request
    ){ return authenticationService.authenticate(request);}
}
