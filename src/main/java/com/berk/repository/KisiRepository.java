package com.berk.repository;

import com.berk.repository.entity.Kisi;
import com.berk.utility.MyFactoryRepository;

public class KisiRepository extends MyFactoryRepository<Kisi,Long> {


    public KisiRepository() {
        super(new Kisi());
    }
}
