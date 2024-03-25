package ru.junior.test_task.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import ru.junior.test_task.dto.HouseDto;
import ru.junior.test_task.entity.House;


@Mapper(componentModel = "spring")
public interface HouseMapper {
    //TODO
    // скорректировать маппинг для пользователей
    @Mapping(source = "id", target = "id")
    @Mapping(source = "address", target = "address")
    @Mapping(source = "ownerId", target = "ownerId")
    @Mapping(target = "usersId", ignore = true)
    HouseDto toDto(House house);

    @Mapping(source = "id", target = "id")
    @Mapping(source = "address", target = "address")
    @Mapping(source = "ownerId", target = "ownerId")
    @Mapping(target = "usersId", ignore = true)
    House toEntity(HouseDto house);
}
