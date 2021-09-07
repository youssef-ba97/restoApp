package com.example.ordersApp.model;

import com.sun.istack.NotNull;
import lombok.*;

import javax.persistence.*;
import java.util.Date;
import java.util.List;


@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "commandes")
public class Commande {

    @Id
    @Column
    private Long id;

    @Column(name = "commande_date")
    private Date commandeDate;

    @Column(name = "prix_total")
    private Double prixTotal;

    @NotNull
    @OneToMany(mappedBy = "order", fetch = FetchType.LAZY)
    private List<CommandeItem> commandeItemsList;

    @ManyToOne
    @NotNull
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    //@JsonIgnore
    private User user;


    //   @NotNull
    // @OneToMany(mappedBy="commandes", cascade=CascadeType.ALL)
    //  private List<CommandeItem> elementsCommandeList;


}
