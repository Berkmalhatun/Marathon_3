package com.berk.service;

import com.berk.repository.AracRepository;
import com.berk.repository.entity.Arac;
import com.berk.utility.MyFactoryService;

import java.util.Optional;

public class AracService extends MyFactoryService<AracRepository, Arac,Long> {

    public AracService() {
        super(new AracRepository());
    }

    public Optional<Arac> findByAracMarka(String marka){
        return getRepository().findByAracMarka(marka);
    }
}
