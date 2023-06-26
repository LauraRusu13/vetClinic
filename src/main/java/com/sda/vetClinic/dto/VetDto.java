package com.sda.vetClinic.dto;


import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@Builder
@NoArgsConstructor
@ToString
public class VetDto {

    private String name;

    private String gender;

    private String dateOfBirth;

    private String speciality;

    private String degree;

    private String skills;

    private String type;

}
