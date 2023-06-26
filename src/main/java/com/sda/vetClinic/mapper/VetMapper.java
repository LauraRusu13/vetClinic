package com.sda.vetClinic.mapper;


import com.sda.vetClinic.dto.VetDto;
import com.sda.vetClinic.entity.Vet;
import com.sda.vetClinic.enums.Gender;
import com.sda.vetClinic.enums.Speciality;
import com.sda.vetClinic.enums.Type;
import org.springframework.stereotype.Component;

@Component
public class VetMapper {

    public Vet map(VetDto vetDto) {
        return Vet.builder()
                .name(vetDto.getName())
                .gender(Gender.valueOf(vetDto.getGender()))
                .dateOfBirth(vetDto.getDateOfBirth())
                .speciality(Speciality.valueOf(vetDto.getSpeciality()))
                .degree(vetDto.getDegree())
                .skills(vetDto.getSkills())
                .type(Type.valueOf(vetDto.getType()))
                .build();
    }

}
