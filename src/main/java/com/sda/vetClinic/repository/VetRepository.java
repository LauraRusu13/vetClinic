package com.sda.vetClinic.repository;

import com.sda.vetClinic.entity.Vet;
import org.springframework.data.repository.CrudRepository;

public interface VetRepository extends CrudRepository<Vet, Long> {
}
