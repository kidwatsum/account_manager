package org.example.account_manager.mapper;

import org.example.account_manager.dto.ProfileDto;
import org.example.account_manager.model.Profile;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * Mapper interface used for profile mapping
 */
@Mapper(componentModel = "spring")
public interface ProfileMapper {

    ProfileMapper INSTANCE = Mappers.getMapper(ProfileMapper.class);

    /**
     * Method used for mapping profile
     * to profile dto
     *
     * @param profile - the profile entity
     *                that's supposed to be
     *                mapped
     *
     * @return - returns a profile dto
     */
    ProfileDto toProfileDto(Profile profile);

    /**
     * Method used for mapping profile dto
     * to profile
     *
     * @param profileDto - the profile dto
     *                   that's supposed to be
     *                   mapped
     *
     * @return - returns a profile entity
     */
    Profile toProfile(ProfileDto profileDto);
}
