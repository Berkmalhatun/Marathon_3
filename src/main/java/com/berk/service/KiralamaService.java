package com.berk.service;

import com.berk.repository.KiralamaRepository;
import com.berk.repository.entity.Arac;
import com.berk.repository.entity.Kiralama;
import com.berk.utility.MyFactoryService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class KiralamaService extends MyFactoryService<KiralamaRepository, Kiralama,Long> {
    public KiralamaService() {
        super(new KiralamaRepository());
    }
    public List<Kiralama> forRentedCar(Long kisiid){
        return getRepository().forRentedCar(kisiid);
    }
}
