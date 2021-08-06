package com.example.ordersApp.Controller;

import com.example.ordersApp.Service.PlatService;
import com.example.ordersApp.model.Plat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "api/plat")
public class PlatController {

    private final PlatService platService;

    @Autowired
    public PlatController(PlatService platService){  //<----Constructor of this Service (platService)
        this.platService = platService;
    }
    @GetMapping
    public List<Plat> getPlats() {
        return platService.getPlats();
    }

}
