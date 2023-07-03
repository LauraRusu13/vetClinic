package com.sda.vetClinic.mapper;

import com.sda.vetClinic.dto.PetDto;
import com.sda.vetClinic.entity.Pet;
import com.sda.vetClinic.entity.User;
import com.sda.vetClinic.enums.Breed;
import com.sda.vetClinic.enums.Gender;
import com.sda.vetClinic.enums.Pedigree;
import com.sda.vetClinic.enums.Species;
import com.sda.vetClinic.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
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
                .species(Species.valueOf(petDto.getSpecies()))
                .breed(Breed.valueOf(petDto.getBreed()))
                .gender(Gender.valueOf(petDto.getGender()))
                .dateOfBirth(petDto.getDateOfBirth())
                .weight(Double.valueOf(petDto.getWeight()))
                .age(Integer.valueOf(petDto.getAge()))
                .pedigree(Pedigree.valueOf(petDto.getPedigree()))
                .build();
    }

    public PetDto map(Pet pet) {
        return PetDto.builder()
                .name(pet.getName())
                .species(String.valueOf(pet.getSpecies()))
                .breed(String.valueOf(pet.getBreed()))
                .ownerEmail(pet.getUser().getEmail())
                .gender(String.valueOf(pet.getGender()))
                .dateOfBirth(pet.getDateOfBirth())
                .weight(String.valueOf(pet.getWeight()))
                .age(String.valueOf(pet.getAge()))
                .pedigree(String.valueOf(pet.getPedigree()))
                .build();
    }

    public List<PetDto> map(List<Pet> petList) {
        List<PetDto> petDtoList = new ArrayList<>();
        for (Pet pet : petList) {
            PetDto petDto = map(pet);
            petDtoList.add(petDto);
        }
        return petDtoList;
    }

}
