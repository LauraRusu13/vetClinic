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

    private String ownerName;

    private String type;

    private String weight;

    private String age;

    private String pedigree;
}
