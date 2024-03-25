package ru.junior.test_task.mapper;

import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import ru.junior.test_task.dto.HouseDto;
import ru.junior.test_task.entity.House;


import java.util.List;

@Mapper(componentModel = "spring", uses = HouseMapper.class, injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface HouseListMapper {
    List<House> toUserList(List<HouseDto> dtoList);
    List<HouseDto> toHouseDtoList(List<House> entityList);
}