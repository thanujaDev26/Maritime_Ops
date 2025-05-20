package com.Maritime.CruiseShipsOpsAPI.service;

import com.Maritime.CruiseShipsOpsAPI.dto.request.PortRequestDto;
import com.Maritime.CruiseShipsOpsAPI.dto.response.PortResponseDto;
import com.Maritime.CruiseShipsOpsAPI.dto.response.PortResponseWithShipDto;

import java.util.List;

public interface IPortService {

    PortResponseDto getPortDetails(Long id);

    List<PortResponseDto> getAllPortsDetails();

    PortResponseDto updatePortDetails(Long id, PortRequestDto dto);

    int deletePortDetails(Long id);

    PortResponseDto createOnePort(PortRequestDto dto);

    PortResponseWithShipDto associateNewShipToPort(Long portId, Long shipId);

    PortResponseWithShipDto disassociateShipFromPort(Long portId, Long shipId);
}
