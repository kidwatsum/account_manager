package org.example.account_manager.mapper;

import org.example.account_manager.dto.MainUserDto;
import org.example.account_manager.model.MainUser;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * Mapped interface used for main user
 * mapping
 */
@Mapper(componentModel = "spring")
public interface MainUserMapper {

    MainUserMapper INSTANCE = Mappers.getMapper(MainUserMapper.class);

    /**
     * Method used for mapping main user dto to main
     * user entity
     *
     * @param mainUserDto - the main user dto
     *                    that's supposed to be mapped
     * @return - returns a main user entity
     */
    MainUser mapToEntity(MainUserDto mainUserDto);

    /**
     * Method used for mapping main user entity to
     * main user dto
     *
     * @param mainUser - the main user entity that's
     *                 supposed to be mapped
     *
     * @return - returns a main user dto
     */
    MainUserDto mapToDto(MainUser mainUser);
}
