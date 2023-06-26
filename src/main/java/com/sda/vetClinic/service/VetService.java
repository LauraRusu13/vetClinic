package com.sda.vetClinic.service;

import com.sda.vetClinic.dto.VetDto;
import com.sda.vetClinic.entity.Vet;
import com.sda.vetClinic.mapper.VetMapper;
import com.sda.vetClinic.repository.VetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VetService {

    @Autowired
    private VetMapper vetMapper;

    @Autowired
    private VetRepository vetRepository;

    public void addVet(VetDto vetDto) {

        Vet vet = vetMapper.map(vetDto);
        vetRepository.save(vet);
    }

}
