package com.sda.vetClinic.service;


import com.sda.vetClinic.dto.LoginDto;
import com.sda.vetClinic.entity.User;
import com.sda.vetClinic.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class LoginService {

    @Autowired
    private UserRepository userRepository;


    public boolean login(LoginDto loginDto) {
        Optional<User> optionalUser = userRepository.findByEmail(loginDto.getEmail());

        if (optionalUser.isEmpty()) {
            return false;
        }
        User user = optionalUser.get();
        return loginDto.getPassword().equals(user.getPassword());


    }

}
