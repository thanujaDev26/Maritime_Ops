package com.Maritime.CruiseShipsOpsAPI.dto.response;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Data
public class PortResponseWithShipDto {
    private Long id;
    private String name;
    private String country;
    private List<ShipResponseDto> ships;
}
