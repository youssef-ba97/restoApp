package com.example.ordersApp.Service;

import com.example.ordersApp.model.Livraison;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface LivraisonService {

    public List<Livraison> findAllLivraisons();

    public Optional<Livraison> findLivraisonById(Long id);

    public Optional<Livraison> deleteLivraison(Long id);

    public Optional<Livraison> updateLivraison(Livraison livraison);

    public void add(Livraison livraison);
}
