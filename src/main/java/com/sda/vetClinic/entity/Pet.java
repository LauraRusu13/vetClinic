package com.sda.vetClinic.entity;


import com.sda.vetClinic.enums.Gender;
import com.sda.vetClinic.enums.Pedigree;
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
public class Pet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Enumerated(value = EnumType.STRING)
    private Type type;

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
}
