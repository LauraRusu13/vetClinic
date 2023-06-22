package com.sda.vetClinic.mapper;

import com.sda.vetClinic.dto.PetDto;
import com.sda.vetClinic.entity.Pet;
import com.sda.vetClinic.enums.Pedigree;
import org.springframework.stereotype.Component;


@Component
public class PetMapper {

    public Pet map(PetDto petDto){
        return Pet.builder()
                .name(petDto.getName())
                .ownerName(petDto.getOwnerName())
                .type(petDto.getType())
                .weight(Double.valueOf(petDto.getWeight()))
                .age(Integer.valueOf(petDto.getAge()))
                .pedigree(Pedigree.valueOf(petDto.getPedigree()))
                .build();
    }

}
