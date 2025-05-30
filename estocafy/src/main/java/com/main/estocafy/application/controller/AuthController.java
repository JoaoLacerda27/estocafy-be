package com.main.estocafy.application.controller;

import com.main.estocafy.application.controller.documentation.AuthDoc;
import com.main.estocafy.application.controller.request.LoginRequest;
import com.main.estocafy.application.controller.response.LoginResponse;
import com.main.estocafy.application.repository.UserRepository;
import com.main.estocafy.shared.security.model.RefreshTokenRequest;
import com.main.estocafy.shared.security.model.TokenResponse;
import com.main.estocafy.shared.security.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/v1/auth")
public class AuthController implements AuthDoc {

    private final AuthService authService;
    private final UserRepository repository;

    @PostMapping("/login")
    public ResponseEntity<LoginResponse> login(@RequestBody LoginRequest loginRequest) {
        TokenResponse tokenResponse = authService.authenticate(loginRequest.getEmail(), loginRequest.getPassword());

        var user = repository.findByEmail(loginRequest.getEmail())
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));

        LoginResponse response = new LoginResponse(
                tokenResponse.getAccessToken(),
                tokenResponse.getTokenType(),
                user.getName(),
                user.getEmail(),
                user.getRoles()
        );

        return ResponseEntity.ok(response);
    }

    @PostMapping("/refresh")
    public ResponseEntity<TokenResponse> refreshToken(@RequestBody RefreshTokenRequest request) {
        TokenResponse tokenResponse = authService.refreshToken(request.getRefreshToken());
        return ResponseEntity.ok(tokenResponse);
    }
}
