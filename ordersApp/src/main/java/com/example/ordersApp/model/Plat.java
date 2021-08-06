package com.example.ordersApp.model;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;

import javax.persistence.*;
import java.util.Objects;

@EnableAutoConfiguration
@Entity
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
    private String nomPlat;

    public Plat() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Plat)) return false;
        Plat plat = (Plat) o;
        return Objects.equals(getId(), plat.getId()) && Objects.equals(getNomPlat(), plat.getNomPlat());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getNomPlat());
    }

    public Plat(String nomPlat) {   // si on change le type d'id on delete ce constructr
        this.nomPlat = nomPlat;
    }

    public Plat(Long id, String nomPlat) {
        this.id = id;
        this.nomPlat = nomPlat;
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

    @Override
    public String toString() {
        return "Plat{" +
                "id =" + id +
                ", nom ='" + nomPlat + '\'' +
                '}';
    }
}
