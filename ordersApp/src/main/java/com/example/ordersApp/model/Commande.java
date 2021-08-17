package com.example.ordersApp.model;

import com.sun.istack.NotNull;

import javax.persistence.*;
import java.util.Date;
import java.util.List;
import java.util.Objects;


@Entity
@Table(name = "commandes")
public class Commande {

    @Id
    @Column(nullable = false)
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


    public Commande(Long id, Date commandeDate, Double prixTotal, List<CommandeItem> commandeItemsList, User user) {
        this.id = id;
        this.commandeDate = commandeDate;
        this.prixTotal = prixTotal;
        this.commandeItemsList = commandeItemsList;
        this.user = user;
    }

    public Commande() {
    }

    public Long getCommandeId() {
        return id;
    }

    public void setCommandeId(Long id) {
        this.id = id;
    }

    public Date getCommandeDate() {
        return commandeDate;
    }

    public void setCommandeDate(Date commandeDate) {
        this.commandeDate = commandeDate;
    }

    public Double getPrixTotal() {
        return prixTotal;
    }

    public void setPrixTotal(Double prixTotal) {
        this.prixTotal = prixTotal;
    }

    public List<CommandeItem> getCommandeItemsList() {
        return commandeItemsList;
    }

    public void setCommandeItemsList(List<CommandeItem> commandeItemsList) {
        this.commandeItemsList = commandeItemsList;
    }

    public User getCommandeUser() {
        return user;
    }

    public void setCommandeUser(User user) {
        this.user = user;
    }



    @Override
    public int hashCode() {
        return Objects.hash(getCommandeId(), getCommandeDate(), getPrixTotal(), getCommandeItemsList(), getCommandeUser());
    }

    @Override
    public String toString() {
        return "Commande{" +
                "id=" + id +
                ", commandeDate=" + commandeDate +
                ", prixTotal=" + prixTotal +
                ", commandeItemsList=" + commandeItemsList +
                ", user=" + user +
                '}';
    }
}
