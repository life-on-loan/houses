package ru.junior.test_task.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.junior.test_task.dto.InfoDto;
import ru.junior.test_task.dto.UserDto;

import java.util.List;

@RequestMapping("/user")
public interface UserController {
    @PostMapping("/create")
    ResponseEntity<InfoDto> create(@RequestBody UserDto userDto);
    @GetMapping("/read")
    ResponseEntity<List<UserDto>> read();
    @DeleteMapping("/delete")
    ResponseEntity<InfoDto> delete();
    @PutMapping("/update")
    ResponseEntity<InfoDto> update();
}
