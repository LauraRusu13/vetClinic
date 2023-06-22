package com.sda.vetClinic.entity;


import com.sda.vetClinic.enums.Pedigree;
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

    private String ownerName;

    private String type;

    private Double weight;

    private Integer age;

    @Enumerated(value = EnumType.STRING)
    private Pedigree pedigree;
}
