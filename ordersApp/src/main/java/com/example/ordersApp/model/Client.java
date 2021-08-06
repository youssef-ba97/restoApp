package com.example.ordersApp.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Client implements Serializable {

    @Id
    @SequenceGenerator(
            name = "commande_sequence",
            sequenceName = "commande_sequence",
            allocationSize = 1
    )
    @Column(nullable = false)
    private Long tel;
    private String nom;
    private String prenom;

}
