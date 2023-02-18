package ru.skillup.youthtourism.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.skillup.youthtourism.domain.User;
import ru.skillup.youthtourism.domain.UserDto;
import ru.skillup.youthtourism.service.UserService;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1")
public class MainRestController {

    private final UserService userService;

    @GetMapping
    public ResponseEntity<String> sayHello() {
        return ResponseEntity.ok("Hello from secured endpoint");
    }

    @GetMapping("/user")
    public ResponseEntity<UserDto> getUser(@RequestParam long id) {
        return ResponseEntity.ok(userService.getUserById(id));
    }

}