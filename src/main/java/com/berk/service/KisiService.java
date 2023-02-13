package com.berk.service;

import com.berk.repository.KisiRepository;
import com.berk.repository.entity.Kisi;
import com.berk.utility.MyFactoryService;

public class KisiService extends MyFactoryService<KisiRepository, Kisi,Long> {
    public KisiService() {
        super(new KisiRepository());
    }
}
