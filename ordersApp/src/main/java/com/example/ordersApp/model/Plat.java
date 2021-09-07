package com.example.ordersApp.model;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "plats")
public class Plat {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    //@Column(nullable = false, updatable = false)
    private Long id;
    @NotNull
    @Column(name = "nom_plat")
    private String nomPlat;

    @NotNull
    @Column(name = "prix")
    private Double prix;


}
