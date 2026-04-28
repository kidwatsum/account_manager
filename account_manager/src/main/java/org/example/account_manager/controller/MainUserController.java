package org.example.account_manager.controller;

import jakarta.validation.Valid;
import org.example.account_manager.dto.MainUserDto;
import org.example.account_manager.service.MainUserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * A Rest Controller for handling
 * main user requests
 */
@RestController
@RequestMapping("/api/users")
public class MainUserController {

    private final MainUserService mainUserService;

    public MainUserController(MainUserService mainUserService) {
        this.mainUserService = mainUserService;
    }

    /**
     * Method to get main user by id
     *
     * @param id - the id parameter
     *           used for searching
     *
     * @return - returns the main user
     *          if it exists
     */
    @GetMapping("/{id}")
    public ResponseEntity<MainUserDto> getUserById(@PathVariable Long id) {

        return ResponseEntity.ok(mainUserService.getById(id));
    }

    /**
     * Method used to create a main user
     *
     * @param mainUserDto - the main user
     *                    request body
     *
     * @return - returns the created user
     */
    @PostMapping
    public ResponseEntity<MainUserDto> createUser(@Valid @RequestBody MainUserDto mainUserDto) {

        return ResponseEntity.ok(mainUserService.createUser(mainUserDto));
    }

    /**
     * Method used for updating a
     * main user
     *
     * @param mainUserDto - the main user
     *                    body used for
     *                    updating
     *
     * @param id - the id param used for
     *           finding the user for
     *           updating
     *
     * @return - returns the updated user
     */
    @PutMapping("/{id}")
    public ResponseEntity<MainUserDto> updateUser(@Valid @RequestBody MainUserDto mainUserDto, @PathVariable Long id) {

        return ResponseEntity.ok(mainUserService.updateUser(id, mainUserDto));
    }

    /**
     * Method used for deleting
     * a main user
     *
     * @param id - the id param used for
     *           searching for the main
     *           user that's supposed to
     *           be deleted
     *
     * @return - returns no content
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id) {

        mainUserService.deleteUserById(id);

        return ResponseEntity.noContent().build();
    }
}
