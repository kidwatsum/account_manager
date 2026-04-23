package org.example.account_manager.controller;

import jakarta.validation.Valid;
import org.example.account_manager.dto.MainUserDto;
import org.example.account_manager.service.impl.MainUserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/users")
public class MainUserController {

    private final MainUserService mainUserService;

    public MainUserController(MainUserService mainUserService) {
        this.mainUserService = mainUserService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<MainUserDto> getUserById(@PathVariable Long id) {

        return ResponseEntity.ok(mainUserService.getById(id));
    }

    @PostMapping
    public ResponseEntity<MainUserDto> createUser(@Valid @RequestBody MainUserDto mainUserDto) {

        return ResponseEntity.ok(mainUserService.createUser(mainUserDto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<MainUserDto> updateUser(@Valid @RequestBody MainUserDto mainUserDto, @PathVariable Long id) {

        return ResponseEntity.ok(mainUserService.updateUser(id, mainUserDto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id) {

        mainUserService.deleteUserById(id);

        return ResponseEntity.noContent().build();
    }
}
