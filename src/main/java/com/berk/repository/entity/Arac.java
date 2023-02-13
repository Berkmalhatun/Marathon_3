package com.berk.repository.entity;

import lombok.*;

import javax.persistence.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@NamedQueries({
        @NamedQuery(name = "Arac.findByAracMarka",
        query = "Select a from Arac a where a.marka = :marka")


})
public class Arac {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String marka;
    String model;
    String hasarKaydi;
    int km;
    boolean kiralikmi; //ilk ekledigim araclar kiralik olmasın diye false olarak belirttim.



}
