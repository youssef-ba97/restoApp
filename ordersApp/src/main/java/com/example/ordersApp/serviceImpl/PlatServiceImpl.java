package com.example.ordersApp.serviceImpl;

import com.example.ordersApp.Service.PlatService;
import com.example.ordersApp.model.Plat;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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
        return platsList;
    }

    @Override
    public Optional<Plat> findById(Long id) {
        return platsList.stream().filter(plat -> plat.getId() == id).findFirst();
    }

    @Override
    public void add(Plat plat) {
        plat.setId(COUNTER++);
        platsList.add(plat);
    }


}
