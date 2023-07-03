package com.sda.vetClinic.entity;


import com.sda.vetClinic.enums.Breed;
import com.sda.vetClinic.enums.Gender;
import com.sda.vetClinic.enums.Pedigree;
import com.sda.vetClinic.enums.Species;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Getter
@Setter
public class Pet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Enumerated(value = EnumType.STRING)
    private Species species;

    @Enumerated(value = EnumType.STRING)
    private Breed breed;

    @Enumerated(value = EnumType.STRING)
    private Gender gender;

    private String dateOfBirth;

    private Double weight;

    private Integer age;

    @Enumerated(value = EnumType.STRING)
    private Pedigree pedigree;

    @ManyToOne
    @JoinColumn
    private User user;

    @OneToMany(mappedBy = "pet")
    private List<Appointment> appointmentsList;
}
