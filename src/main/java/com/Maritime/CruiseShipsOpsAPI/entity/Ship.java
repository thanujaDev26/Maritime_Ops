package com.Maritime.CruiseShipsOpsAPI.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

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

    private  String type;

    private LocalDate launchDate;

    @ManyToOne
    @JoinColumn(name = "home_port_id")
    private Port homePort;
}
