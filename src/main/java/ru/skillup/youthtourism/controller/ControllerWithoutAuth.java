package ru.skillup.youthtourism.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import ru.skillup.youthtourism.auth.domain.AuthenticationRequest;
import ru.skillup.youthtourism.auth.domain.AuthenticationResponse;
import ru.skillup.youthtourism.auth.domain.RegisterRequest;
import ru.skillup.youthtourism.auth.service.AuthenticationService;
import ru.skillup.youthtourism.service.UserService;
import ru.skillup.youthtourism.service.VkServicePosting;

@RestController
@RequestMapping("/api/v2")
@RequiredArgsConstructor
public class ControllerWithoutAuth {

    private final AuthenticationService authenticationService;
    private final VkServicePosting vkServicePosting;
    private final UserService userService;

    @PostMapping("/auth/register")
    public ResponseEntity<AuthenticationResponse> register(@RequestBody RegisterRequest request) {
        return ResponseEntity.ok(authenticationService.register(request));
    }

    @PostMapping("/auth/authenticate")
    public ResponseEntity<AuthenticationResponse> authenticate(@RequestBody AuthenticationRequest request) {
        return ResponseEntity.ok(authenticationService.authenticate(request));
    }

    @GetMapping("/check_email/{email}")
    public ResponseEntity<Boolean> authenticate(@PathVariable String email) {
        return ResponseEntity.ok(userService.checkUniqueEmail(email));
    }

    @PostMapping("/post")
    public void post(@RequestParam() String messages) {
        vkServicePosting.postOnWall(messages);
    }
}
