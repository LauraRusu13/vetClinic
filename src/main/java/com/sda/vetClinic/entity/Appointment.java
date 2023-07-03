package com.sda.vetClinic.entity;

import com.sda.vetClinic.enums.AppointmentType;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Getter
@Setter
public class Appointment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn
    private Pet pet;

    @ManyToOne
    @JoinColumn
    private User vet;

    private String details;

    private AppointmentType appointmentType;

    private String otherMedicalIssues;

    private LocalDateTime dateTime;


}
