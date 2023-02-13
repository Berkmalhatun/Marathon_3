package com.berk.repository;

import com.berk.repository.entity.Arac;
import com.berk.utility.MyFactoryRepository;

import javax.persistence.TypedQuery;
import java.util.Optional;

public class AracRepository extends MyFactoryRepository<Arac,Long> {
    public AracRepository() {
        super(new Arac());
    }

    public Optional<Arac> findByAracMarka(String marka){
        TypedQuery<Arac> typedQuery = getEntityManager()
                .createNamedQuery("Arac.findByAracMarka", Arac.class);
        typedQuery.setParameter("marka",marka);
        try {
            return Optional.of(typedQuery.getSingleResult());
        }catch (Exception e){
            return Optional.empty();
        }
    }
}
