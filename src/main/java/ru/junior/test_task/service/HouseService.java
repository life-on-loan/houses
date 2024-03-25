package ru.junior.test_task.service;

import jakarta.validation.Valid;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import ru.junior.test_task.dto.HouseDto;
import ru.junior.test_task.dto.InfoDto;
import ru.junior.test_task.entity.House;
import ru.junior.test_task.mapper.HouseListMapper;
import ru.junior.test_task.mapper.HouseMapper;
import ru.junior.test_task.repository.HouseRepository;
import ru.junior.test_task.repository.UserRepository;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

import static ru.junior.test_task.utils.TextMessage.*;

@Service
@Validated
public class HouseService {
    private final HouseRepository houseRepository;
    private final UserRepository userRepository;
    private final HouseMapper houseMapper;
    private final HouseListMapper houseListMapper;

    public HouseService(HouseRepository houseRepository, UserRepository userRepository, HouseMapper houseMapper, HouseListMapper houseListMapper) {
        this.houseRepository = houseRepository;
        this.userRepository = userRepository;
        this.houseMapper = houseMapper;
        this.houseListMapper = houseListMapper;
    }

    // TODO
    // добавить проверку, что адрес занят другим хозяином во избежание неоднократной регистрации

    public InfoDto create(@Valid HouseDto houseDto) {
        InfoDto infoDto = new InfoDto();
        String time = new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime());
        infoDto.setTime(time);
        try {
            Integer ownerId = houseDto.getOwnerId();
            if (userRepository.existsById(ownerId)) {
                House house = houseMapper.toEntity(houseDto);
                houseRepository.save(house);
                infoDto.setCorrect(true);
                infoDto.setMessage(SUCCESS_CREATED_HOUSE);
            } else {
                infoDto.setCorrect(false);
                infoDto.setMessage(FAIL_CREATED_HOUSE);
            }
        } catch (Exception e) {
            infoDto.setCorrect(false);
            infoDto.setMessage(e.getMessage());
        }
        return infoDto;
    }

    public List<HouseDto> read() {
        return houseListMapper.toHouseDtoList(houseRepository.findAll());
    }
}
