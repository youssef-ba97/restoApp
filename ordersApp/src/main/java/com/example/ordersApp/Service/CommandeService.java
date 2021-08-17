package com.example.ordersApp.Service;

import com.example.ordersApp.model.Commande;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface CommandeService {

    public List<Commande> findAllCommandes();

    public Optional<Commande> findCommandeById(Long id);

    public Optional<Commande> deleteCommande(Long id);

    public Optional<Commande> updateCommande(Commande commande);

    public void add(Commande commande);
}
