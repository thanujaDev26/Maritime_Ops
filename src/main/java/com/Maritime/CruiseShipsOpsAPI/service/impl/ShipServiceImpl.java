package com.Maritime.CruiseShipsOpsAPI.service.impl;

import com.Maritime.CruiseShipsOpsAPI.dto.request.ShipRequestDto;
import com.Maritime.CruiseShipsOpsAPI.dto.response.ShipResponseDto;
import com.Maritime.CruiseShipsOpsAPI.entity.Port;
import com.Maritime.CruiseShipsOpsAPI.entity.Ship;
import com.Maritime.CruiseShipsOpsAPI.exception.PortNotFoundException;
import com.Maritime.CruiseShipsOpsAPI.exception.ShipNotFoundException;
import com.Maritime.CruiseShipsOpsAPI.repository.PortRepo;
import com.Maritime.CruiseShipsOpsAPI.repository.ShipRepo;
import com.Maritime.CruiseShipsOpsAPI.service.IShipService;
import com.Maritime.CruiseShipsOpsAPI.util.mapper.ShipEntityMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ShipServiceImpl implements IShipService {

    private final ShipRepo _repo;
    private final ShipEntityMapper _mapper;
    private final PortRepo _portRepo;

    @Autowired
    public ShipServiceImpl(ShipRepo _repo, ShipEntityMapper mapper, PortRepo portRepo) {
        this._repo = _repo;
        this._mapper = mapper;
        this._portRepo = portRepo;
    }


    @Override
    public ShipResponseDto createNewShip(ShipRequestDto shipDto){
        Ship ship = this._mapper.shipDtoToEntity(shipDto);
        Ship savedShip = this._repo.save(ship);
        return this._mapper.shipEntityToDto(savedShip);
    }

    @Override
    public ShipResponseDto getShipById(Long id){
       Ship searchedShip = this._repo.findById(id).orElseThrow(()->new ShipNotFoundException(String.format("This Ship is not found ", id)));
       return this._mapper.shipEntityToDto(searchedShip);
    }

    @Override
    public List<ShipResponseDto> getAllShips(){
        List<Ship> allShipsData = this._repo.findAll();
        return this._mapper.shipEntityToDtoList(allShipsData);
    }


    @Override
    @Transactional
    public int deleteShip(Long id) {
        if (!_repo.existsById(id)) {
            throw new ShipNotFoundException("Ship with ID " + id + " not found.");
        }
        else {
            _repo.deleteById(id);
            return 1;
        }

    }

    @Override
    public ShipResponseDto updateShip(Long id, ShipRequestDto shipRequestDto) {
       Ship searchedShip = this._repo.findById(id).orElseThrow(()->new ShipNotFoundException(String.format("This ship has not found ", id)));
       Port updatablePort = this._portRepo.findById(shipRequestDto.getHomePortId()).orElseThrow(
               ()->new PortNotFoundException(String.format("This Port has not found", shipRequestDto.getHomePortId())));
       searchedShip.setName(shipRequestDto.getName());
       searchedShip.setType(shipRequestDto.getType());
       searchedShip.setLaunchDate(shipRequestDto.getLaunchDate());
       searchedShip.setHomePort(updatablePort);

       Ship updatedShip = this._repo.save(searchedShip);
       return this._mapper.shipEntityToDto(updatedShip);
    }
}
