package com.Maritime.CruiseShipsOpsAPI.repository;


import com.Maritime.CruiseShipsOpsAPI.entity.Port;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

@Repository
@EnableJpaRepositories
public interface PortRepo extends JpaRepository<Port,Long> {
}
