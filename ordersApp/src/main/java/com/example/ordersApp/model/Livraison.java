package com.example.ordersApp.model;

import com.sun.istack.NotNull;

import javax.persistence.*;
import java.util.Date;
import java.util.List;
import java.util.Objects;


@Entity
@Table(name = "livraisons")
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


    public Livraison(Long id, Date livraisonDate, Double prixTotal, List<Commande> CommandesList, User user) {
        this.id = id;
        this.livraisonDate = livraisonDate;
        this.prixTotal = prixTotal;
        this.commandesList = CommandesList;
        this.user = user;
    }

    public Livraison() {
    }

    public Long getLivraisonId() {
        return id;
    }

    public void setLivraisonId(Long id) {
        this.id = id;
    }

    public Date getLivraisonDate() {
        return livraisonDate;
    }

    public void setLivraisonDate(Date livraisonDate) {
        this.livraisonDate = livraisonDate;
    }

    public Double getPrixTotal() {
        return prixTotal;
    }

    public void setPrixTotal(Double prixTotal) {
        this.prixTotal = prixTotal;
    }

    public List<Commande> getCommandesList() {
        return commandesList;
    }

    public void setCommandesList(List<Commande> CommandesList) {
        this.commandesList = CommandesList;
    }

    public User getLivraisonUser() {
        return user;
    }

    public void setLivraisonUser(User user) {
        this.user = user;
    }



    @Override
    public int hashCode() {
        return Objects.hash(getLivraisonId(), getLivraisonDate(), getPrixTotal(), getCommandesList(), getLivraisonUser());
    }

    @Override
    public String toString() {
        return "Livraison{" +
                "id=" + id +
                ", livraisonDate=" + livraisonDate +
                ", prixTotal=" + prixTotal +
                ", commandesList=" + commandesList +
                ", user=" + user +
                '}';
    }
}
