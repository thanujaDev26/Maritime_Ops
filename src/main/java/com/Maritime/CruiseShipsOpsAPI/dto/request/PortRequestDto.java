package com.Maritime.CruiseShipsOpsAPI.dto.request;

import com.Maritime.CruiseShipsOpsAPI.entity.Ship;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
@Data
public class PortRequestDto {
    private String name;
    private String country;
}
