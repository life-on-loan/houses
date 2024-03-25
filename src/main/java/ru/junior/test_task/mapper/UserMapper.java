package ru.junior.test_task.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import ru.junior.test_task.dto.UserDto;
import ru.junior.test_task.entity.User;

@Mapper(componentModel = "spring")
public interface UserMapper {
    @Mapping(source = "id", target = "id")
    @Mapping(source = "name", target = "name")
    @Mapping(source = "age", target = "age")
    @Mapping(source = "login", target = "login")
    @Mapping(source = "password", target = "password")
    UserDto toDto(User user);

    @Mapping(source = "id", target = "id")
    @Mapping(source = "name", target = "name")
    @Mapping(source = "age", target = "age")
    @Mapping(source = "login", target = "login")
    @Mapping(source = "password", target = "password")
    User toEntity(UserDto user);
}
