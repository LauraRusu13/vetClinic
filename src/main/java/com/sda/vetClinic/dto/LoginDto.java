package com.sda.vetClinic.dto;


import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@Builder
@NoArgsConstructor
@ToString
public class LoginDto {

    private String email;

    private String password;
}
