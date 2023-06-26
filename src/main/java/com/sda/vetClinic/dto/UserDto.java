package com.sda.vetClinic.dto;

import lombok.*;



@Getter
@Setter
@AllArgsConstructor
@Builder
@NoArgsConstructor
@ToString
public class UserDto {

    private String firstName;

    private String lastName;

    private String email;

    private String password;

    private String dateOfBirth;

    private String role;

}
