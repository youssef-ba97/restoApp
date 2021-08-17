package com.example.ordersApp.model;

import com.sun.istack.NotNull;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "commande_items")
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


    @Column(name = "created_date")
    private Date createdDate;

    @ManyToOne
    @JoinColumn(name = "order_id", referencedColumnName = "id")
    private Commande commande;

    @OneToOne
    @JoinColumn(name = "plat_id", referencedColumnName = "id")
    private Plat plat;


    public CommandeItem(int quantite, double prix, Date createdDate, Commande commande, Plat plat) {
        this.quantite = quantite;
        this.prix = prix;
        this.createdDate = createdDate;
        this.commande = commande;
        this.plat = plat;
    }

    public CommandeItem() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CommandeItem)) return false;
        CommandeItem that = (CommandeItem) o;
        return getQuantite() == that.getQuantite() && Double.compare(that.getPrix(), getPrix()) == 0 && getId().equals(that.getId()) && getCreatedDate().equals(that.getCreatedDate()) && getCommande().equals(that.getCommande()) && getPlat().equals(that.getPlat());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getQuantite(), getPrix(), getCreatedDate(), getCommande(), getPlat());
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getQuantite() {
        return quantite;
    }

    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }

    public double getPrix() {
        return prix;
    }

    public void setPrix(double prix) {
        this.prix = prix;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public Commande getCommande() {
        return commande;
    }

    public void setCommande(Commande commande) {
        this.commande = commande;
    }

    public Plat getPlat() {
        return plat;
    }

    public void setPlat(Plat plat) {
        this.plat = plat;
    }




}
