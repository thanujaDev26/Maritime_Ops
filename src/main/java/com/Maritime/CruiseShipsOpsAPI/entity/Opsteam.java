package com.Maritime.CruiseShipsOpsAPI.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Opsteam {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String teamName;

    private String description;

    // Ships managed by this team
    @OneToMany(mappedBy = "managingTeam")
    private Set<Ship> ships;

    // Operations handled by this team
    @OneToMany(mappedBy = "operationTeam")
    private Set<Operation> operations;

    // Crew members in this team
    @OneToMany(mappedBy = "opsteam")
    private Set<Crew> crew;

}
