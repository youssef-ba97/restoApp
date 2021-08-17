package com.example.ordersApp.model;

import com.sun.istack.NotNull;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class Plat {

    @Id
    @Column(nullable = false, updatable = false)
    private Long id;
    @NotNull
    private String nomPlat;
    @NotNull
    private Double prix;

    public Plat() {
    }

    public Plat(Long id, String nomPlat, Double prix) {
        this.id = id;
        this.nomPlat = nomPlat;
        this.prix = prix;
    }



    @Override
    public String toString() {
        return "Plat{" +
                "id=" + id +
                ", nomPlat='" + nomPlat + '\'' +
                ", prix=" + prix +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Plat)) return false;
        Plat plat = (Plat) o;
        return getId().equals(plat.getId()) && Objects.equals(getNomPlat(), plat.getNomPlat()) && Objects.equals(getPrix(), plat.getPrix());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getNomPlat(), getPrix());
    }

    public Double getPrix() {
        return prix;
    }

    public void setPrix(Double prix) {
        this.prix = prix;
    }

    public Long getId() {
        return id;
    }

    public String getNomPlat() {
        return nomPlat;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setNomPlat(String nomPlat) {
        this.nomPlat = nomPlat;
    }

}
