package com.Maritime.CruiseShipsOpsAPI.entity;

import com.Maritime.CruiseShipsOpsAPI.entity.enums.OperationStatus;
import com.Maritime.CruiseShipsOpsAPI.entity.enums.OperationType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Operation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private OperationType operationType;

    @Enumerated(EnumType.STRING)
    private OperationStatus operationStatus;

    private LocalDateTime startTime;

    private LocalDateTime endTime;

    // Link to ship
    @ManyToOne
    @JoinColumn(name = "ship_id")
    private Ship ship;

    // Link to port where operation occurs
    @ManyToOne
    @JoinColumn(name = "port_id")
    private Port port;

    // Managing operation team
    @ManyToOne
    @JoinColumn(name = "opsteam_id")
    private Opsteam operationTeam;

    private String notes;  // Optional

    private Integer queuePosition; // To keep track of operation order if needed

}
