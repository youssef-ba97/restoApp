package com.example.ordersApp;

import com.example.ordersApp.model.Plat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlatRepository extends JpaRepository<Plat, Long> {

}
