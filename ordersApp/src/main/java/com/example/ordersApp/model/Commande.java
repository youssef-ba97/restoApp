package com.example.ordersApp.model;

import java.io.Serializable;
import javax.persistence.*;
import com.example.ordersApp.model.Plat;


@Entity
public class Commande implements Serializable {

    @Id
    @SequenceGenerator(
            name = "commande_sequence",
            sequenceName = "commande_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "commande_sequence"
    )
    @Column(nullable = false, updatable = false)
    private Long id;
    private Double prix;
    private Plat[] platArray;

    public Commande() {
    }

}
