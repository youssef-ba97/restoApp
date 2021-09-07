package com.example.ordersApp.Service.serviceImpl;

import com.example.ordersApp.Service.CommandeService;
import com.example.ordersApp.model.Commande;
import org.springframework.stereotype.Service;


import java.util.*;
import java.util.stream.Collectors;

@Service
public class CommandeServiceImpl implements CommandeService {

    public static List<Commande> commandesList = new ArrayList();

    private static Long COUNTER = 1L;




    static {
        Commande commande = new Commande(COUNTER++, new Date(), 15.5, null, null);
        commandesList.add(commande);



    }
    @Override
    public List<Commande> findAllCommandes() {
        return commandesList.stream().sorted(Comparator.comparing(Commande::getId)).collect(Collectors.toList());
    }

    @Override
    public Optional<Commande> findCommandeById(Long id) {
        return commandesList.stream().filter(commande -> commande.getId() == id).findFirst();
    }

    @Override
    public Optional<Commande> deleteCommande(Long id) {
        Optional<Commande> commandeOptional = commandesList.stream().filter(commande -> commande.getId() == id).findFirst();

        if (commandeOptional.isPresent()){
            commandesList = commandesList.stream().filter(commande -> commande.getId() != commandeOptional.get().getId()).collect(Collectors.toList());
            return commandeOptional;
        }

        return Optional.empty();
    }

    @Override
    public Optional<Commande> updateCommande(Commande commande) {
        Optional<Commande> commandeOptional = commandesList.stream().filter(c -> c.getId() == commande.getId()).findFirst();

        if (commandeOptional.isPresent()){
            Commande existingCommande = commandeOptional.get();

            if (commande.getId() != null){
                existingCommande.setId(commande.getId());
            }
            if (commande.getCommandeDate() != null){
                existingCommande.setCommandeDate(commande.getCommandeDate());
            }

            if (commande.getPrixTotal() != null){
                existingCommande.setPrixTotal(commande.getPrixTotal());
            }

            if (commande.getUser() != null){
                existingCommande.setUser(commande.getUser());
            }

            if (commande.getCommandeItemsList() != null){
                existingCommande.setCommandeItemsList(commande.getCommandeItemsList());
            }


            commandesList = commandesList
                    .stream()
                    .filter(u -> u.getId() != existingCommande.getId())
                    .collect(Collectors.toList());
            commandesList.add(existingCommande);

            return Optional.of(existingCommande);
        }
        return Optional.empty();
    }

    @Override
    public void add(Commande commande) {
        commande.setId(COUNTER++);
        commandesList.add(commande);
    }


}
