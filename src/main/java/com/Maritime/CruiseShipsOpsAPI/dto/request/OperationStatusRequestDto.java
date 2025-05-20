package com.Maritime.CruiseShipsOpsAPI.dto.request;

import com.Maritime.CruiseShipsOpsAPI.entity.enums.OperationStatus;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class OperationStatusRequestDto {
    private Long operationId;

    private OperationStatus status;

    private LocalDateTime updatedAt;

    private String message;
}
