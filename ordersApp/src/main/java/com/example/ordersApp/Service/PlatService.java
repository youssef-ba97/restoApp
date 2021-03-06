package com.example.ordersApp.Service;

import com.example.ordersApp.model.Plat;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface PlatService {

     public List<Plat> findAllPlats();

     public Optional<Plat> findById(Long id);

     public Optional<Plat> delete(Long id);

     public Optional<Plat> update(Plat plat);

     public void add(Plat plat);
}
