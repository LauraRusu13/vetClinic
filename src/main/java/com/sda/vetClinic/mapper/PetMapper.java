package com.sda.vetClinic.mapper;

import com.sda.vetClinic.dto.PetDto;
import com.sda.vetClinic.entity.Pet;
import com.sda.vetClinic.enums.Gender;
import com.sda.vetClinic.enums.Pedigree;
import com.sda.vetClinic.enums.Type;
import org.springframework.stereotype.Component;


@Component
public class PetMapper {

    public Pet map(PetDto petDto){
        return Pet.builder()
                .name(petDto.getName())
                .ownerName(petDto.getOwnerName())
                .type(Type.valueOf(petDto.getType()))
                .gender(Gender.valueOf(petDto.getGender()))
                .dateOfBirth(petDto.getDateOfBirth())
                .weight(Double.valueOf(petDto.getWeight()))
                .age(Integer.valueOf(petDto.getAge()))
                .pedigree(Pedigree.valueOf(petDto.getPedigree()))
                .build();
    }

}
