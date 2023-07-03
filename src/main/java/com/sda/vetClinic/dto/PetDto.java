package com.sda.vetClinic.dto;

import com.sda.vetClinic.enums.Pedigree;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@Builder
@NoArgsConstructor
@ToString
public class PetDto {

    private String name;

    private String ownerEmail;

    private String species;

    private String breed;

    private String gender;

    private String dateOfBirth;

    private String weight;

    private String age;

    private String pedigree;
}
