package com.sda.vetClinic.mapper;

import com.sda.vetClinic.dto.AppointmentDto;
import com.sda.vetClinic.dto.PetDto;
import com.sda.vetClinic.entity.Appointment;
import com.sda.vetClinic.entity.Pet;
import com.sda.vetClinic.entity.User;
import com.sda.vetClinic.enums.AppointmentType;
import com.sda.vetClinic.enums.Role;
import com.sda.vetClinic.repository.PetRepository;
import com.sda.vetClinic.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class AppointmentMapper {

    @Autowired
    private PetMapper petMapper;

    @Autowired
    private PetRepository petRepository;

    @Autowired
    private UserRepository userRepository;


    public AppointmentDto map(Appointment appointment){
        PetDto petDto = petMapper.map(appointment.getPet());
        return AppointmentDto.builder()
                .petName(appointment.getPet().getName())
                .appointmentType(String.valueOf(appointment.getAppointmentType()))
                .details(appointment.getDetails())
                .otherMedicalIssues(appointment.getOtherMedicalIssues())
                .dateTime(String.valueOf(appointment.getDateTime()))
                .build();
    }

    public Appointment map(AppointmentDto appointmentDto){
        Optional<Pet> optionalPet = Optional.ofNullable(petRepository.findByName(appointmentDto.getPetName()));
        if (optionalPet.isEmpty()) {
            throw new RuntimeException("Pet not found!");
        }
        String[] firstAndLastName = appointmentDto.getVetName().split(" ");
        Optional<User> optionalVet = userRepository.findByRoleAndFirstNameAndLastName(Role.ROLE_VETERINARIAN, firstAndLastName[0], firstAndLastName[1]);
        if (optionalVet.isEmpty()) {
            throw new RuntimeException("Vet not found!");
        }
        return Appointment.builder()
                .pet(optionalPet.get())
                .vet(optionalVet.get())
                .appointmentType(AppointmentType.valueOf(appointmentDto.getAppointmentType()))
                .details(appointmentDto.getDetails())
                .otherMedicalIssues(appointmentDto.getOtherMedicalIssues())
                .dateTime(LocalDateTime.parse(appointmentDto.getDateTime()))
                .build();
    }

    public List<AppointmentDto> map(List<Appointment> appointmentList) {
        List<AppointmentDto> appointmentDtoList = new ArrayList<>();
        for (Appointment appointment : appointmentList) {
            AppointmentDto appointmentDto = map(appointment);
            appointmentDtoList.add(appointmentDto);
        }
        System.out.println(appointmentDtoList);
        return appointmentDtoList;
    }

}
