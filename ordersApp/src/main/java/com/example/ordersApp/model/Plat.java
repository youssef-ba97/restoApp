package com.example.ordersApp.model;

import com.sun.istack.NotNull;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;

import javax.persistence.*;
import java.util.Objects;

@Table
public class Plat {

    @Id
    @SequenceGenerator(
            name = "plat_sequence",
            sequenceName = "plat_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE, ///on peut changer le type d'id ou bien ca marche avec seq ?? :/
            generator = "plat_sequence"
    )
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


    public Plat(String nomPlat, Double prix) {
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
