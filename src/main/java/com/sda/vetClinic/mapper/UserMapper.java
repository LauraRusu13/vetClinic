package com.sda.vetClinic.mapper;


import com.sda.vetClinic.dto.UserDto;
import com.sda.vetClinic.entity.User;
import com.sda.vetClinic.enums.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class UserMapper {

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    public User map(UserDto userDto) {
        return User.builder()
                .firstName(userDto.getFirstName())
                .lastName(userDto.getLastName())
                .email(userDto.getEmail())
                .dateOfBirth(LocalDate.parse(userDto.getDateOfBirth()))
                .password(bCryptPasswordEncoder.encode(userDto.getPassword()))
                .phoneNo(userDto.getPhoneNo())
                .role(Role.valueOf(userDto.getRole()))
                .build();

    }

}
