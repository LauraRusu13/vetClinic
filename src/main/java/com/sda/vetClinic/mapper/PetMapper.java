package com.sda.vetClinic.mapper;

import com.sda.vetClinic.dto.PetDto;
import com.sda.vetClinic.entity.Pet;
import com.sda.vetClinic.entity.User;
import com.sda.vetClinic.enums.Gender;
import com.sda.vetClinic.enums.Pedigree;
import com.sda.vetClinic.enums.Type;
import com.sda.vetClinic.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;


@Component
public class PetMapper {

    @Autowired
    private UserRepository userRepository;

    public Pet map(PetDto petDto){

        Optional<User> optionalUser = userRepository.findByEmail(petDto.getOwnerEmail());
        if (optionalUser.isEmpty()) {
            throw new RuntimeException("User not found!");
        }

        return Pet.builder()
                .name(petDto.getName())
                .user(optionalUser.get())
                .type(Type.valueOf(petDto.getType()))
                .gender(Gender.valueOf(petDto.getGender()))
                .dateOfBirth(petDto.getDateOfBirth())
                .weight(Double.valueOf(petDto.getWeight()))
                .age(Integer.valueOf(petDto.getAge()))
                .pedigree(Pedigree.valueOf(petDto.getPedigree()))
                .build();
    }

}
