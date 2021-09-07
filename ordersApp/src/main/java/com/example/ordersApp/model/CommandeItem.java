package com.example.ordersApp.model;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity@Table(name = "commande_items")
public class CommandeItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;


    @Column(name = "quantite")
    @NotNull
    private int quantite;

    @Column(name = "prix")
    @NotNull
    private double prix;




}
