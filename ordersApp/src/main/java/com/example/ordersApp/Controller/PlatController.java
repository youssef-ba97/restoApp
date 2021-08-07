package com.example.ordersApp.Controller;

import com.example.ordersApp.Service.PlatService;
import com.example.ordersApp.model.Plat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "api/plat")
public class PlatController {

    private final PlatService platService;

    @Autowired
    public PlatController(PlatService platService){  //<----Constructor of this Service (platService)
        this.platService = platService;
    }

    @GetMapping
    public ResponseEntity<?> findAllPlats() {
        return new ResponseEntity<List<Plat>>(platService.findAllPlats(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id) {
        Optional<Plat> platOpt = platService.findById(id);

        if (platOpt.isPresent()) {
            return new ResponseEntity<Plat>(platOpt.get(), HttpStatus.OK);
        }
        return new ResponseEntity<Void>(HttpStatus.NOT_FOUND) ;
    }

    @PostMapping("/add")
    public ResponseEntity<?> add(@Validated @RequestBody Plat plat){
        platService.add(plat);

        return new ResponseEntity<Void>(HttpStatus.CREATED);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){
        Optional<Plat> optionalPlat = platService.delete(id);

        if (optionalPlat.isPresent()){
            return new ResponseEntity<Plat>(optionalPlat.get(), HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
    }

    @PutMapping("/update")
    public ResponseEntity<?> update(@RequestBody Plat plat){
        Optional<Plat> optionalPlat = platService.update(plat);

        if (optionalPlat.isPresent()){
            return new ResponseEntity<Plat>(optionalPlat.get(), HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
    }
}
