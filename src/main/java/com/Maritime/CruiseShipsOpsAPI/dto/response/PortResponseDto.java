package com.Maritime.CruiseShipsOpsAPI.dto.response;


import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Data
public class PortResponseDto {
    private Long id;
    private String name;
    private String country;
}
