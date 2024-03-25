package ru.junior.test_task.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import ru.junior.test_task.dto.InfoDto;
import ru.junior.test_task.dto.UserDto;
import ru.junior.test_task.service.UserService;

import java.util.List;

@RestController
public class UserControllerImpl implements UserController{
    private final UserService userService;
    public UserControllerImpl(UserService userService) {
        this.userService = userService;
    }

    @Override
    public ResponseEntity<InfoDto> create(@RequestBody UserDto userDto) {
        InfoDto infoDto = userService.create(userDto);
        return infoDto.getCorrect()
                ? new ResponseEntity<>(infoDto, HttpStatus.OK)
                : new ResponseEntity<>(infoDto, HttpStatus.BAD_REQUEST);
    }

    @Override
    public ResponseEntity<List<UserDto>> read() {
        List<UserDto> listUsers = userService.read();
        return listUsers != null && !listUsers.isEmpty()
                ? new ResponseEntity<>(listUsers, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @Override
    public ResponseEntity<InfoDto> delete() {
        return null;
    }

    @Override
    public ResponseEntity<InfoDto> update() {
        return null;
    }
}
