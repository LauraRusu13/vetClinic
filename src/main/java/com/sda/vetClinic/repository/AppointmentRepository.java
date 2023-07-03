package com.sda.vetClinic.repository;

import com.sda.vetClinic.entity.Appointment;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface AppointmentRepository extends CrudRepository<Appointment, Long> {

    List<Appointment> findByPetUserEmail(String email);
}
