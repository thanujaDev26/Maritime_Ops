package com.Maritime.CruiseShipsOpsAPI.repository;

import com.Maritime.CruiseShipsOpsAPI.entity.Operation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@EnableJpaRepositories
public interface  OperationRepo extends JpaRepository<Operation,Long> {


    List<Operation> findByShipId(Long shipId);


    List<Operation> findByPortId(Long portId);


    Optional<Operation> findTopByShipIdOrderByStartTimeDesc(Long shipId);


    List<Operation> findAllByShipId(Long shipId);

}
