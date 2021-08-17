package com.example.ordersApp.Controller;

import com.example.ordersApp.Service.LivraisonService;
import com.example.ordersApp.model.Livraison;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "api/livraison")
public class LivraisonController {

    private final LivraisonService livraisonService;

    @Autowired
    public LivraisonController(LivraisonService livraisonService){  //<----Constructor of this Service (livraisonService)
        this.livraisonService = livraisonService;
    }

    @GetMapping
    public ResponseEntity<?> findAllLivraisons() {
        return new ResponseEntity<List<Livraison>>(livraisonService.findAllLivraisons(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findLivraisonById(@PathVariable Long id) {
        Optional<Livraison> livraisonOpt = livraisonService.findLivraisonById(id);

        if (livraisonOpt.isPresent()) {
            return new ResponseEntity<Livraison>(livraisonOpt.get(), HttpStatus.OK);
        }
        return new ResponseEntity<Void>(HttpStatus.NOT_FOUND) ;
    }

    @PostMapping("/add")
    public ResponseEntity<?> add(@Validated @RequestBody Livraison livraison){
        livraisonService.add(livraison);

        return new ResponseEntity<Void>(HttpStatus.CREATED);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteLivraison(@PathVariable Long id){
        Optional<Livraison> optionalLivraison = livraisonService.deleteLivraison(id);

        if (optionalLivraison.isPresent()){
            return new ResponseEntity<Livraison>(optionalLivraison.get(), HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
    }

    @PutMapping("/update")
    public ResponseEntity<?> updateLivraison(@RequestBody Livraison livraison){
        Optional<Livraison> optionalLivraison = livraisonService.updateLivraison(livraison);

        if (optionalLivraison.isPresent()){
            return new ResponseEntity<Livraison>(optionalLivraison.get(), HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
    }
}
