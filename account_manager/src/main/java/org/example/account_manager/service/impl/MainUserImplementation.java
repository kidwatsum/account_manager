package org.example.account_manager.service.impl;

import jakarta.persistence.EntityNotFoundException;
import org.example.account_manager.dto.MainUserDto;
import org.example.account_manager.mapper.MainUserMapper;
import org.example.account_manager.model.MainUser;
import org.example.account_manager.repository.MainUserRepository;
import org.example.account_manager.service.MainUserService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Service implementation class for the
 * MainUserService interface
 */
@Service
public class MainUserImplementation implements MainUserService {

    private final MainUserRepository mainUserRepository;
    private final MainUserMapper mainUserMapper;

    public MainUserImplementation(MainUserRepository mainUserRepository, MainUserMapper mainUserMapper) {
        this.mainUserRepository = mainUserRepository;
        this.mainUserMapper = mainUserMapper;
    }

    /**
     * Method used to get a main user
     * by id
     *
     * @param id - the id param used
     *           for searching
     *
     * @return - returns the found user
     *          if it exists
     */
    @Override
    public MainUserDto getById(Long id) {
        return mainUserRepository.findById(id).map(mainUserMapper::mapToDto).orElseThrow(() -> new EntityNotFoundException("User with provided id not found"));
    }

    /**
     * Method used for creating
     * a main user
     *
     * @param mainUserDto - the main user dto
     *                    that's sent from the
     *                    frontend
     *
     * @return - returns the created user
     */
    @Transactional
    @Override
    public MainUserDto createUser(MainUserDto mainUserDto) {

        return mainUserMapper.mapToDto(mainUserRepository.save(mainUserMapper.mapToEntity(mainUserDto)));
    }

    /**
     * Method used for updating a main user
     *
     * @param id - the id param used for finding
     *           the main user for updating
     *
     * @param mainUserDto - the main user dto params
     *                    to use for updating the main
     *                    user
     *
     * @return - returns the updated main user
     */
    @Transactional
    @Override
    public MainUserDto updateUser(Long id, MainUserDto mainUserDto) {

        MainUser mainUser = mainUserRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("User with provided id not found"));

        mainUser.setEmail(mainUserDto.getEmail());
        mainUser.setUsername(mainUserDto.getUsername());
        mainUser.setPassword(mainUserDto.getPassword());

        return mainUserMapper.mapToDto(mainUserRepository.save(mainUser));

    }

    /**
     * Method used for deleting a main user
     *
     * @param id - the id param used for searching
     *           for the main user for deletion
     */
    @Transactional
    @Override
    public void deleteUserById(Long id) {

        mainUserRepository.deleteById(id);
    }
}
