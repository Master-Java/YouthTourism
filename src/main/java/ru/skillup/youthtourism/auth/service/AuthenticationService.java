package ru.skillup.youthtourism.auth.service;

import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import ru.skillup.youthtourism.auth.domain.AuthenticationRequest;
import ru.skillup.youthtourism.auth.domain.AuthenticationResponse;
import ru.skillup.youthtourism.auth.domain.RegisterRequest;
import ru.skillup.youthtourism.domain.Role;
import ru.skillup.youthtourism.domain.User;
import ru.skillup.youthtourism.service.impl.UserServiceImpl;

@Service
@RequiredArgsConstructor
public class AuthenticationService {
    private final UserServiceImpl repository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;

    public AuthenticationResponse register(RegisterRequest request) {
        User user = User.builder()
                .username(request.getUsername())
                .password(passwordEncoder.encode(request.getPassword()))
                .email(request.getEmail())
                .name(request.getName())
                .surname(request.getSurname())
                .patronymic(request.getPatronymic())
                .role(Role.USER)
                .build();
        repository.insertNewUser(user);
        String jwtToken = jwtService.generateToken(user);
        return AuthenticationResponse.builder()
                .token(jwtToken)
                .build();
    }

    public AuthenticationResponse authenticate(AuthenticationRequest request) {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword()));
        User user = repository.getUserByEmail(request.getEmail());
        String jwtToken = jwtService.generateToken(user);
        return AuthenticationResponse.builder()
                .token(jwtToken)
                .build();
    }
}