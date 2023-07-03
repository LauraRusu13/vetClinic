package com.sda.vetClinic.dto;

import lombok.*;


@Getter
@Setter
@AllArgsConstructor
@Builder
@NoArgsConstructor
@ToString
public class AppointmentDto {

    private String petName;

    private String appointmentType;

    private String details;

    private String otherMedicalIssues;

    private String dateTime;

    private String vetName;



}
