package org.example.account_manager.mapper;

import org.example.account_manager.dto.MainUserDto;
import org.example.account_manager.model.MainUser;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface MainUserMapper {

    MainUserMapper INSTANCE = Mappers.getMapper(MainUserMapper.class);

    MainUser mapToEntity(MainUserDto mainUserDto);

    MainUserDto mapToDto(MainUser mainUser);
}
