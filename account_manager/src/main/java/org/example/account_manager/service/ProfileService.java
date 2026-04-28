package org.example.account_manager.service;

import org.example.account_manager.dto.ProfileDto;

/**
 * Service interface for the Profile
 */
public interface ProfileService {

    /**
     * Method used for getting a profile
     * by id
     *
     * @param id - the id param used for
     *           searching for the profile
     *
     * @return - returns the found profile
     *          if it exists
     */
    ProfileDto getProfileById(Long id);

    /**
     * Method used for creating a profile
     *
     * @param profileDto - the profile
     *                   request body sent from
     *                   the frontend
     *
     * @return - returns the created profile
     */
    ProfileDto createProfile(ProfileDto profileDto);

    /**
     * Method used for updating a profile
     *
     * @param id - the id param used for
     *           searching for the profile
     *           that's supposed to be
     *           updated
     *
     * @param profileDto - profile dto used
     *                   for updating the
     *                   saved profile
     *
     * @return - returns the updated profile
     */
    ProfileDto updateProfile(Long id, ProfileDto profileDto);

    /**
     * Method used for deleting a profile
     *
     * @param id - the id param used for
     *           searching for the profile
     *           that's supposed to be deleted
     */
    void deleteProfileById(Long id);
}
