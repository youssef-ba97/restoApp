package com.example.ordersApp.Service;

import com.example.ordersApp.PlatRepository;
import com.example.ordersApp.model.Plat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlatService {

    private final PlatRepository platRepository;

    @Autowired
    public PlatService(PlatRepository platRepository) {
        this.platRepository = platRepository;
    }

    public List<Plat> getPlats() {
        return platRepository.findAll();

    }
}
