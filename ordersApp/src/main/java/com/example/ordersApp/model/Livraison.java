package com.example.ordersApp.model;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;
import java.util.List;
import java.util.Objects;


@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity@Table(name = "livraisons")
public class Livraison {

    @Id
    @Column(nullable = false)
    private Long id;

    @Column(name = "livraison_date")
    private Date livraisonDate;

    @Column(name = "prix_total")
    private Double prixTotal;


    @NotNull
    @OneToMany(mappedBy = "order", fetch = FetchType.LAZY)
    private List<Commande> commandesList;

    @ManyToOne
    @NotNull
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    //@JsonIgnore
    private User user;



    //   @NotNull
    // @OneToMany(mappedBy="livraisons", cascade=CascadeType.ALL)
    //  private List<LivraisonItem> elementsLivraisonList;


}
