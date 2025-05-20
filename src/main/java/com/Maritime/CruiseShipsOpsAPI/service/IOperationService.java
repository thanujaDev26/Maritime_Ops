package com.Maritime.CruiseShipsOpsAPI.service;

import com.Maritime.CruiseShipsOpsAPI.dto.request.OperationRequestDto;
import com.Maritime.CruiseShipsOpsAPI.dto.request.OperationStatusRequestDto;
import com.Maritime.CruiseShipsOpsAPI.dto.response.OperationResponseDto;
import com.Maritime.CruiseShipsOpsAPI.dto.response.OperationStatusResponseDto;
import com.Maritime.CruiseShipsOpsAPI.entity.enums.OperationStatus;

import java.util.List;

public interface IOperationService {

    OperationResponseDto createOperation(OperationRequestDto dto);

    List<OperationResponseDto> getAllOperations();

    List<OperationResponseDto> getOperationsByShipId(Long shipId);

    List<OperationResponseDto> getOperationsByPortId(Long portId);

//    OperationStatusResponseDto updateOperationStatus(Long operationId, OperationStatus status);

    OperationStatusResponseDto updateLatestOperationStatusByShip(Long shipId, OperationStatusRequestDto dto);

//    List<OperationStatusResponseDto> updateAllOperationsStatusByShip(Long shipId, OperationStatus status);

}
