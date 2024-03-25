package ru.junior.test_task.mapper;

import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import ru.junior.test_task.dto.UserDto;
import ru.junior.test_task.entity.User;

import java.util.List;

@Mapper(componentModel = "spring", uses = UserMapper.class, injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface UserListMapper {
    List<User> toUserList(List<UserDto> dtoList);
    List<UserDto> toUserDtoList(List<User> entityList);
}
