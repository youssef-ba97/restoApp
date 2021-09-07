package com.example.ordersApp.Service.serviceImpl;

import com.example.ordersApp.Service.LivraisonService;
import com.example.ordersApp.model.Livraison;
import org.springframework.stereotype.Service;


import java.util.*;
import java.util.stream.Collectors;

@Service
public class LivraisonServiceImpl implements LivraisonService {

    public static List<Livraison> livraisonsList = new ArrayList();

    private static Long COUNTER = 1L;




    static {
        Livraison livraison = new Livraison(COUNTER++, new Date(), 15.5, null, null);
        livraisonsList.add(livraison);

        Livraison livraison1 = new Livraison(COUNTER++, new Date(), 29.2, null, null);
        livraisonsList.add(livraison1);


    }
    @Override
    public List<Livraison> findAllLivraisons() {
        return livraisonsList.stream().sorted(Comparator.comparing(Livraison::getId)).collect(Collectors.toList());
    }

    @Override
    public Optional<Livraison> findLivraisonById(Long id) {
        return livraisonsList.stream().filter(livraison -> livraison.getId() == id).findFirst();
    }

    @Override
    public Optional<Livraison> deleteLivraison(Long id) {
        Optional<Livraison> livraisonOptional = livraisonsList.stream().filter(livraison -> livraison.getId() == id).findFirst();

        if (livraisonOptional.isPresent()){
            livraisonsList = livraisonsList.stream().filter(livraison -> livraison.getId() != livraisonOptional.get().getId()).collect(Collectors.toList());
            return livraisonOptional;
        }

        return Optional.empty();
    }

    @Override
    public Optional<Livraison> updateLivraison(Livraison livraison) {
        Optional<Livraison> livraisonOptional = livraisonsList.stream().filter(c -> c.getId() == livraison.getId()).findFirst();

        if (livraisonOptional.isPresent()){
            Livraison existingLivraison = livraisonOptional.get();

            if (livraison.getId() != null){
                existingLivraison.setId(livraison.getId());
            }
            if (livraison.getLivraisonDate() != null){
                existingLivraison.setLivraisonDate(livraison.getLivraisonDate());
            }

            if (livraison.getPrixTotal() != null){
                existingLivraison.setPrixTotal(livraison.getPrixTotal());
            }

            if (livraison.getUser() != null){
                existingLivraison.setUser(livraison.getUser());
            }

            if (livraison.getCommandesList() != null){
                existingLivraison.setCommandesList(livraison.getCommandesList());
            }


            livraisonsList = livraisonsList
                    .stream()
                    .filter(u -> u.getId() != existingLivraison.getId())
                    .collect(Collectors.toList());
            livraisonsList.add(existingLivraison);

            return Optional.of(existingLivraison);
        }
        return Optional.empty();
    }

    @Override
    public void add(Livraison livraison) {
        livraison.setId(COUNTER++);
        livraisonsList.add(livraison);
    }


}
