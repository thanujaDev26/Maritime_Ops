package com.Maritime.CruiseShipsOpsAPI.repository;


import com.Maritime.CruiseShipsOpsAPI.entity.Ship;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

@Repository
@EnableJpaRepositories
public interface ShipRepo extends JpaRepository<Ship,Long> {
}
