package com.Maritime.CruiseShipsOpsAPI.dto.request;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@Data
public class ShipRequestDto {
    private Long id;
    private String name;
    private String type;
    private LocalDate launchDate;
    private Long homePortId;
}
