package com.alonmack.racer.repository;

import com.alonmack.racer.domein.Racer;
import org.springframework.stereotype.Repository;

import java.util.List;

import static java.util.Arrays.asList;


@Repository
public class RacerRepository {
    public List<Racer> getAll() {
        Racer racer = new Racer();
        racer.setName("Max");
        racer.setSurname("Popovich");
        Racer racer2 = new Racer();
        racer2.setName("Andrey");
        racer2.setSurname("Datsenko");
        racer2.setCity("Kioto");
        return asList(racer, racer2);
    }
}
