package com.sda.vetClinic.service;

import com.sda.vetClinic.dto.UserDto;
import com.sda.vetClinic.entity.User;
import com.sda.vetClinic.enums.Role;
import com.sda.vetClinic.mapper.UserMapper;
import com.sda.vetClinic.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private UserRepository userRepository;


    public void createUser(UserDto userDto) {
        User user = userMapper.map(userDto);
        userRepository.save(user);
    }

    public List<String> getAllVetNameList() {
            List<User> vetList = userRepository.findByRole(Role.ROLE_VETERINARIAN);
            return vetList.stream()
                    .map(User::getFullName)
                    .toList();

    }
}
