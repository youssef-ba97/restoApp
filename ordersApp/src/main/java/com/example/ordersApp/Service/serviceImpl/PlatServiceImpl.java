package com.example.ordersApp.Service.serviceImpl;

import com.example.ordersApp.Service.PlatService;
import com.example.ordersApp.model.Plat;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PlatServiceImpl implements PlatService {

    public static List<Plat> platsList = new ArrayList();

    private static Long COUNTER = 1L;

    static {
        Plat plat = new Plat(COUNTER++, "couscous", 15.5);
        platsList.add(plat);

        plat = new Plat(COUNTER++, "spaghetti", 13.0);
        platsList.add(plat);

        plat = new Plat(COUNTER++, "pizza 4 fromages", 22.00);
        platsList.add(plat);

        plat = new Plat(COUNTER++, "gnocchi gorgonzola", 25.5);
        platsList.add(plat);

    }
    @Override
    public List<Plat> findAllPlats() {
        return platsList.stream().sorted(Comparator.comparing(Plat::getId)).collect(Collectors.toList());
    }

    @Override
    public Optional<Plat> findById(Long id) {
        return platsList.stream().filter(plat -> plat.getId() == id).findFirst();
    }

    @Override
    public Optional<Plat> delete(Long id) {
        Optional<Plat> platOptional = platsList.stream().filter(plat -> plat.getId() == id).findFirst();

        if (platOptional.isPresent()){
            platsList = platsList.stream().filter(plat -> plat.getId() != platOptional.get().getId()).collect(Collectors.toList());
            return platOptional;
        }

        return Optional.empty();
    }

    @Override
    public Optional<Plat> update(Plat plat) {
        Optional<Plat> platOptional = platsList.stream().filter(p -> p.getId() == plat.getId()).findFirst();

        if (platOptional.isPresent()){
            Plat existingPlat = platOptional.get();

            if (plat.getNomPlat() != null){
                existingPlat.setNomPlat(plat.getNomPlat());
            }

            if (plat.getPrix() != null){
                existingPlat.setPrix(plat.getPrix());
            }

           platsList = platsList
                   .stream()
                   .filter(u -> u.getId() != existingPlat.getId())
                   .collect(Collectors.toList());
            platsList.add(existingPlat);

            return Optional.of(existingPlat);
        }
        return Optional.empty();
    }

    @Override
    public void add(Plat plat) {
        plat.setId(COUNTER++);
        platsList.add(plat);
    }


}
