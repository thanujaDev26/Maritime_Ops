package com.Maritime.CruiseShipsOpsAPI.service;

import com.Maritime.CruiseShipsOpsAPI.dto.request.ShipRequestDto;
import com.Maritime.CruiseShipsOpsAPI.dto.response.ShipResponseDto;

import java.time.LocalDate;
import java.util.List;

public interface IShipService {

    ShipResponseDto createNewShip(ShipRequestDto shipDto);

    ShipResponseDto getShipById(Long id);

    List<ShipResponseDto> getAllShips();

//    List<ShipResponseDto> getAllShipsToday(LocalDate date);

    ShipResponseDto updateShip(Long id, ShipRequestDto shipRequestDto);

    int deleteShip(Long id);
}
