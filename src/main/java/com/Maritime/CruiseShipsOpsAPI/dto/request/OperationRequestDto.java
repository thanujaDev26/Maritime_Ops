package com.Maritime.CruiseShipsOpsAPI.dto.request;

import com.Maritime.CruiseShipsOpsAPI.entity.enums.OperationStatus;
import com.Maritime.CruiseShipsOpsAPI.entity.enums.OperationType;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class OperationRequestDto {
    private Long id;
    private OperationType operationType;
    private OperationStatus operationStatus;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private Long shipId;
    private Long portId;
}
