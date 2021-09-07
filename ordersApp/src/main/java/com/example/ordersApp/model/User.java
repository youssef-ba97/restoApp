package com.example.ordersApp.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.util.List;


@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
    @Table(name = "users")
    public class User {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        @Column(name = "first_name")
        private String firstName;

        @Column(name = "last_name")
        private String lastName;

        @Column(name = "email")
        private String email;

        @Enumerated(EnumType.STRING)
        @Column(name = "isAdmin")
        private Boolean isAdmin;

        @Column(name = "num")
        private Integer num;

        @Column(name = "adresse")
        private String adresse;

        @Column(name = "password")
        private String password;

        @JsonIgnore
        @OneToMany(mappedBy = "user",
                fetch = FetchType.LAZY)
        private List<Commande> commandes;







}