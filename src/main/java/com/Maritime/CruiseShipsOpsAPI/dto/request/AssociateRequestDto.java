package com.Maritime.CruiseShipsOpsAPI.dto.request;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Data
public class AssociateRequestDto {
    private Long portId;
    private Long shipId;
}
