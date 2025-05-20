package com.Maritime.CruiseShipsOpsAPI.dto.response;

import com.Maritime.CruiseShipsOpsAPI.entity.enums.OperationStatus;
import com.Maritime.CruiseShipsOpsAPI.entity.enums.OperationType;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OperationResponseDto {
    private Long id;
    private OperationType operationType;
    private OperationStatus operationStatus;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private String shipName;
    private String portName;
}
