package com.Maritime.CruiseShipsOpsAPI.util.mapper;


import com.Maritime.CruiseShipsOpsAPI.dto.request.OperationRequestDto;
import com.Maritime.CruiseShipsOpsAPI.dto.response.OperationResponseDto;
import com.Maritime.CruiseShipsOpsAPI.entity.Operation;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface OperationEntityMapper {
    Operation portDtoToEntity(OperationRequestDto dto);

    @Mapping(source = "ship.name", target = "shipName")
    @Mapping(source = "port.name", target = "portName")
    OperationResponseDto portEntityToDto(Operation operation);


    List<OperationResponseDto> portEntityToDtoList(List<Operation> operations);

    OperationResponseDto responseDtoToRequestDto(OperationRequestDto dto);

    Operation portDtoToEntity(OperationResponseDto dto);


}
