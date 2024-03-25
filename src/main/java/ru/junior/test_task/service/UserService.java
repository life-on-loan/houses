package ru.junior.test_task.service;

import jakarta.validation.Valid;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import ru.junior.test_task.dto.InfoDto;
import ru.junior.test_task.dto.UserDto;
import ru.junior.test_task.entity.User;
import ru.junior.test_task.mapper.UserListMapper;
import ru.junior.test_task.mapper.UserMapper;
import ru.junior.test_task.repository.UserRepository;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

import static ru.junior.test_task.utils.TextMessage.SUCCESS_CREATED_USER;

@Service
@Validated
public class UserService {
    private final UserMapper userMapper;
    private final UserRepository userRepository;
    private final UserListMapper userListMapper;

    public UserService(UserMapper userMapper, UserRepository userRepository, UserListMapper userListMapper) {
        this.userMapper = userMapper;
        this.userRepository = userRepository;
        this.userListMapper = userListMapper;
    }

    public InfoDto create(@Valid UserDto userDto) {
        InfoDto infoDto = new InfoDto();
        try {
            String hashPassword = BCrypt.hashpw(userDto.getPassword(), BCrypt.gensalt());
            userDto.setPassword(hashPassword);
            User user = userMapper.toEntity(userDto);
            userRepository.save(user);
            infoDto.setCorrect(true);
            infoDto.setMessage(SUCCESS_CREATED_USER);
            String time = new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime());
            infoDto.setTime(time);
        } catch (Exception e) {
            infoDto.setCorrect(false);
            String time = new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime());
            infoDto.setTime(time);
            infoDto.setMessage(e.getMessage());
        }
        return infoDto;
    }

    public List<UserDto> read() {
        return userListMapper.toUserDtoList(userRepository.findAll());
    }
}
