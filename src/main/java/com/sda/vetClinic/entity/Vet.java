package com.sda.vetClinic.entity;


import com.sda.vetClinic.enums.Gender;
import com.sda.vetClinic.enums.Speciality;
import com.sda.vetClinic.enums.Type;
import jakarta.persistence.*;
import lombok.*;


@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Getter
@Setter
public class Vet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Enumerated(value = EnumType.STRING)
    private Gender gender;

    private String dateOfBirth;

    @Enumerated(value = EnumType.STRING)
    private Speciality speciality;

    private String degree;

    private String skills;

    @Enumerated(value = EnumType.STRING)
    private Type type;


}
