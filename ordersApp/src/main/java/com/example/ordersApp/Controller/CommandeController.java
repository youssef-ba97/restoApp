package com.example.ordersApp.Controller;

import com.example.ordersApp.Service.CommandeService;
import com.example.ordersApp.model.Commande;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "api/commande")
public class CommandeController {

    private final CommandeService commandeService;

    @Autowired
    public CommandeController(CommandeService commandeService){  //<----Constructor of this Service (commandeService)
        this.commandeService = commandeService;
    }

    @GetMapping
    public ResponseEntity<?> findAllCommandes() {
        return new ResponseEntity<List<Commande>>(commandeService.findAllCommandes(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findCommandeById(@PathVariable Long id) {
        Optional<Commande> commandeOpt = commandeService.findCommandeById(id);

        if (commandeOpt.isPresent()) {
            return new ResponseEntity<Commande>(commandeOpt.get(), HttpStatus.OK);
        }
        return new ResponseEntity<Void>(HttpStatus.NOT_FOUND) ;
    }

    @PostMapping("/add")
    public ResponseEntity<?> add(@Validated @RequestBody Commande commande){
        commandeService.add(commande);

        return new ResponseEntity<Void>(HttpStatus.CREATED);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteCommande(@PathVariable Long id){
        Optional<Commande> optionalCommande = commandeService.deleteCommande(id);

        if (optionalCommande.isPresent()){
            return new ResponseEntity<Commande>(optionalCommande.get(), HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
    }

    @PutMapping("/update")
    public ResponseEntity<?> updateCommande(@RequestBody Commande commande){
        Optional<Commande> optionalCommande = commandeService.updateCommande(commande);

        if (optionalCommande.isPresent()){
            return new ResponseEntity<Commande>(optionalCommande.get(), HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
    }
}
