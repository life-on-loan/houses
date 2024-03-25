package ru.junior.test_task.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import ru.junior.test_task.dto.HouseDto;
import ru.junior.test_task.dto.InfoDto;
import ru.junior.test_task.service.HouseService;

import java.util.List;

@RestController
public class HouseControllerImpl implements HouseController{
    private final HouseService houseService;

    public HouseControllerImpl(HouseService houseService) {
        this.houseService = houseService;
    }

    @Override
    public ResponseEntity<InfoDto> create(HouseDto houseDto) {
        InfoDto infoDto = houseService.create(houseDto);
        return infoDto.getCorrect()
                ? new ResponseEntity<>(infoDto, HttpStatus.OK)
                : new ResponseEntity<>(infoDto, HttpStatus.BAD_REQUEST);
    }

    @Override
    public ResponseEntity<List<HouseDto>> read() {
        List<HouseDto> listHouses = houseService.read();
        return listHouses != null && !listHouses.isEmpty()
                ? new ResponseEntity<>(listHouses, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @Override
    public ResponseEntity<InfoDto> delete(HouseDto houseDto) {
        return null;
    }

    @Override
    public ResponseEntity<InfoDto> update(HouseDto houseDto) {
        return null;
    }
}
