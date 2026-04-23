package org.example.account_manager.service.impl;

import org.example.account_manager.dto.MainUserDto;

public interface MainUserService {

    MainUserDto getById(Long id);

    MainUserDto createUser(MainUserDto mainUserDto);
    MainUserDto updateUser(Long id, MainUserDto mainUserDto);
    void deleteUserById(Long id);

}
