package com.Maritime.CruiseShipsOpsAPI.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Crew {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String role; // e.g., Captain, Engineer, etc.

    // Which ship they belong to (could be nullable if assigned to team only)
    @ManyToOne
    @JoinColumn(name = "ship_id")
    private Ship ship;

    // Operation team they belong to
    @ManyToOne
    @JoinColumn(name = "opsteam_id")
    private Opsteam opsteam;

}

