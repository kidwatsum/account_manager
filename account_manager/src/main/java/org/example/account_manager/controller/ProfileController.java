package org.example.account_manager.controller;

import jakarta.validation.Valid;
import org.example.account_manager.dto.ProfileDto;
import org.example.account_manager.service.ProfileService;
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
 * A Rest Controller used for handling
 * profile requests
 */
@RestController
@RequestMapping("/api/profiles")
public class ProfileController {

    private final ProfileService profileService;

    public ProfileController(ProfileService profileService) {
        this.profileService = profileService;
    }

    /**
     * Method used for getting a profile by id
     *
     * @param id - the id param used for searching
     *           for the profile
     *
     * @return - returns the found profile if it
     *          exists
     */
    @GetMapping("/{id}")
    public ResponseEntity<ProfileDto> getProfileById(@PathVariable Long id) {
        return ResponseEntity.ok(profileService.getProfileById(id));
    }

    /**
     * Method used for creating a profile
     *
     * @param profileDto - the profile dto request body
     *                   sent from the frontend
     *
     * @return - returns the created profile
     */
    @PostMapping
    public ResponseEntity<ProfileDto> createProfile(@Valid @RequestBody ProfileDto profileDto) {

        return ResponseEntity.ok(profileService.createProfile(profileDto));
    }

    /**
     * Method used for updating a profile
     *
     * @param id - the id param used for searching
     *           for the profile that's going
     *           to be updated
     *
     * @param profileDto - profile dto that's used to update
     *                   the saved profile
     *
     * @return - returns the updated profile
     */
    @PutMapping("/{id}")
    public ResponseEntity<ProfileDto> updateProfile(@PathVariable Long id, @Valid @RequestBody ProfileDto profileDto) {

        return ResponseEntity.ok(profileService.updateProfile(id, profileDto));
    }

    /**
     * Method used for deleting a profile
     *
     * @param id - the id param used for searching
     *           for the profile that's going to
     *           be deleted
     *
     * @return - returns no content
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProfile(@PathVariable Long id) {

        profileService.deleteProfileById(id);

        return ResponseEntity.noContent().build();
    }
}
