package com.sda.vetClinic.mapper;


import com.sda.vetClinic.dto.UserDto;
import com.sda.vetClinic.entity.User;
import com.sda.vetClinic.enums.Role;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class UserMapper {

    public User map(UserDto userDto) {
        return User.builder()
                .firstName(userDto.getFirstName())
                .lastName(userDto.getLastName())
                .email(userDto.getEmail())
                .dateOfBirth(LocalDate.parse(userDto.getDateOfBirth()))
                .password(userDto.getPassword())
                .role(Role.valueOf(userDto.getRole()))
                .build();

    }

}
