package com.sda.vetClinic.repository;

import com.sda.vetClinic.entity.Pet;
import org.springframework.data.repository.CrudRepository;

import java.util.List;


public interface PetRepository extends CrudRepository<Pet, Long> {

    List<Pet> findByUserEmail(String email);

    Pet findByName(String name);



}
