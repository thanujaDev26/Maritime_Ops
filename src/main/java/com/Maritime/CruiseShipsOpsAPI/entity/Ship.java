package com.Maritime.CruiseShipsOpsAPI.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Set;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Ship {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String type;

    private String manufacturedCountry;

    private int capacity;

    private LocalDate launchDate;

    private LocalDateTime arrivalDateTime;

    private String notes;

    // Home port
    @ManyToOne
    @JoinColumn(name = "home_port_id")
    private Port homePort;

    // Previous port
    @ManyToOne
    @JoinColumn(name = "previous_port_id")
    private Port previousPort;

    // Current port
    @ManyToOne
    @JoinColumn(name = "current_port_id")
    private Port currentPort;

    // Next port
    @ManyToOne
    @JoinColumn(name = "next_port_id")
    private Port nextPort;

    // Images URLs or image entities (simplified as a list of Strings for URLs)
    @ElementCollection
    private Set<String> images;

    // Managing operation team
    @ManyToOne
    @JoinColumn(name = "opsteam_id")
    private Opsteam managingTeam;

    // Crew members
    @OneToMany(mappedBy = "ship")
    private Set<Crew> crew;

    // Operations (history or queue)
    @OneToMany(mappedBy = "ship")
    private Set<Operation> operations;

}
