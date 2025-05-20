package com.Maritime.CruiseShipsOpsAPI.util.mapper;

import com.Maritime.CruiseShipsOpsAPI.dto.request.PortRequestDto;
import com.Maritime.CruiseShipsOpsAPI.dto.response.PortResponseDto;
import com.Maritime.CruiseShipsOpsAPI.dto.response.PortResponseWithShipDto;
import com.Maritime.CruiseShipsOpsAPI.entity.Port;
import org.mapstruct.Mapper;

import java.util.List;
import java.util.Optional;

@Mapper(componentModel = "spring")
public interface PortEntityMapper {
    PortResponseDto portEntityToDto(Port port);

    Port portDtoToEntity(PortRequestDto dto);

    List<PortResponseDto> portEntityToDtoList(List<Port> ports);

    PortResponseWithShipDto portWithShipsEntityToDto(Port port);

    List<PortResponseWithShipDto> portWithShipsEntityToDtoList(List<Port> ports);

    PortResponseWithShipDto portWithShipsEntityToDto(Optional<Port> byId);
}
