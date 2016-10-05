package com.alonmack.racer.service;

import com.alonmack.racer.domein.Racer;
import com.alonmack.racer.repository.RacerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RacerService {
    @Autowired
    private RacerRepository racerRepository;

    public List<Racer> getAll(){

        return racerRepository.getAll();

    }
}
