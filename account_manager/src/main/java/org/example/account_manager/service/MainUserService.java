package org.example.account_manager.service;

import org.example.account_manager.dto.MainUserDto;

/**
 * Service interface for the MainUser
 */
public interface MainUserService {

    /**
     * Method used for getting a main
     * user by id
     *
     * @param id - the id param used for
     *           searching for the main user
     *
     * @return - returns the found user if it
     *          exists
     */
    MainUserDto getById(Long id);

    /**
     * Method used for creating a main user
     *
     * @param mainUserDto - the main user dto sent
     *                    from the frontend
     *
     * @return - returns the created main user
     */
    MainUserDto createUser(MainUserDto mainUserDto);

    /**
     * Method used for updating a user
     *
     * @param id - the id param used for searching
     *           for the main user to be updated
     *
     * @param mainUserDto - the main user dto that's
     *                    supposed to be used for updating
     *                    the main user
     *
     * @return - returns teh updated main user
     */
    MainUserDto updateUser(Long id, MainUserDto mainUserDto);

    /**
     * Method used for deleting a main user
     *
     * @param id - the id param used for searching
     *           for the main user that's supposed
     *           to be deleted
     */
    void deleteUserById(Long id);

}
