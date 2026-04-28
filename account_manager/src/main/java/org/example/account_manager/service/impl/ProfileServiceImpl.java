package org.example.account_manager.service.impl;

import jakarta.persistence.EntityNotFoundException;
import org.example.account_manager.dto.ProfileDto;
import org.example.account_manager.mapper.ProfileMapper;
import org.example.account_manager.model.Profile;
import org.example.account_manager.repository.ProfileRepository;
import org.example.account_manager.service.ProfileService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Service Implementation class for the ProfileService
 * interface
 */
@Service
public class ProfileServiceImpl implements ProfileService {

    private final ProfileRepository profileRepository;
    private final ProfileMapper profileMapper;

    public ProfileServiceImpl(ProfileRepository profileRepository, ProfileMapper profileMapper) {
        this.profileRepository = profileRepository;
        this.profileMapper = profileMapper;
    }


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
    @Override
    public ProfileDto getProfileById(Long id) {
        return profileRepository.findById(id).map(profileMapper::toProfileDto).orElseThrow(() -> new EntityNotFoundException("Profile not found!"));
    }

    /**
     * Method used for creating a profile
     *
     * @param profileDto - the profile
     *                   request body sent from
     *                   the frontend
     *
     * @return - returns the created profile
     */
    @Transactional
    @Override
    public ProfileDto createProfile(ProfileDto profileDto) {

        Profile profile = profileMapper.toProfile(profileDto);


        return profileMapper.toProfileDto(profileRepository.save(profile));
    }

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
    @Transactional
    @Override
    public ProfileDto updateProfile(Long id, ProfileDto profileDto) {

        Profile profile = profileRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Profile not found!"));

        profile.setProfileName(profileDto.getProfileName());
        profile.setUsername(profileDto.getUsername());
        profile.setPassword(profileDto.getPassword());

        return profileMapper.toProfileDto(profileRepository.save(profile));
    }

    /**
     * Method used for deleting a profile
     *
     * @param id - the id param used for
     *           searching for the profile
     *           that's supposed to be deleted
     */
    @Transactional
    @Override
    public void deleteProfileById(Long id) {

        Profile profile = profileRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Profile not found!"));

        profileRepository.delete(profile);
    }
}
