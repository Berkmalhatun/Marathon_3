package com.berk.repository;

import com.berk.repository.entity.Arac;
import com.berk.repository.entity.Kiralama;
import com.berk.utility.MyFactoryRepository;

import javax.persistence.TypedQuery;
import java.util.List;
import java.util.Optional;

public class KiralamaRepository extends MyFactoryRepository<Kiralama,Long> {
    public KiralamaRepository() {
        super(new Kiralama());
    }

    public List<Kiralama> forRentedCar(Long kisiid){
        TypedQuery<Kiralama> typedQuery = getEntityManager()
                .createNamedQuery("Kiralama.forRentedCar", Kiralama.class);
        typedQuery.setParameter("kisiid",kisiid);
            System.out.println("Kiraladigi araclar.");
            return typedQuery.getResultList();
        }
    }

