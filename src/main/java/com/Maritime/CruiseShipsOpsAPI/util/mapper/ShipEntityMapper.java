package com.Maritime.CruiseShipsOpsAPI.util.mapper;


import com.Maritime.CruiseShipsOpsAPI.dto.request.ShipRequestDto;
import com.Maritime.CruiseShipsOpsAPI.dto.response.ShipResponseDto;
import com.Maritime.CruiseShipsOpsAPI.entity.Ship;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ShipEntityMapper {

    @Mapping(source = "homePort.id", target = "homePortId")
    ShipResponseDto shipEntityToDto(Ship ship);

    @Mapping(source = "homePortId", target = "homePort.id")
    Ship shipDtoToEntity(ShipRequestDto dto);

    List<ShipResponseDto> shipEntityToDtoList(List<Ship> ships);

}
