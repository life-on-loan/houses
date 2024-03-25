package ru.junior.test_task.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.junior.test_task.dto.HouseDto;
import ru.junior.test_task.dto.InfoDto;

import java.util.List;

@RequestMapping("/house")
public interface HouseController {
    @PostMapping("/create")
    ResponseEntity<InfoDto> create(@RequestBody HouseDto houseDto);
    @GetMapping("/read")
    ResponseEntity<List<HouseDto>> read();
    @DeleteMapping("/delete")
    ResponseEntity<InfoDto> delete(@RequestBody HouseDto houseDto);
    @PutMapping("/update")
    ResponseEntity<InfoDto> update(@RequestBody HouseDto houseDto);
}
