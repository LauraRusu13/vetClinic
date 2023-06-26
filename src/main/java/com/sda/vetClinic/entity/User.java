package com.sda.vetClinic.entity;


import com.sda.vetClinic.enums.Role;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.List;

@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Getter
@Setter
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String firstName;

    private String lastName;

    private String email;

    private String password;

    private LocalDate dateOfBirth;

    @Enumerated(value = EnumType.STRING)
    private Role role;

    @OneToMany(mappedBy = "user")
    List<Pet> pets;

}
