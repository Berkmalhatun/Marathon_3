package com.berk.repository.entity;

import lombok.*;

import javax.persistence.*;
import java.util.List;
import java.util.Map;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@NamedQueries({
        @NamedQuery(name = "Kiralama.forRentNow",
                query = "Select k from Kiralama k"),
        @NamedQuery(name = "Kiralama.forRentedCar",
                query = "Select k from Kiralama k where kisiid= :kisiid")

})
public class Kiralama {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    Long aracid;
    Long kisiid;
//
    //
}
