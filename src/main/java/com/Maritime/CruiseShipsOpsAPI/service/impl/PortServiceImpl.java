package com.Maritime.CruiseShipsOpsAPI.service.impl;


import com.Maritime.CruiseShipsOpsAPI.dto.request.PortRequestDto;
import com.Maritime.CruiseShipsOpsAPI.dto.response.PortResponseDto;
import com.Maritime.CruiseShipsOpsAPI.dto.response.PortResponseWithShipDto;
import com.Maritime.CruiseShipsOpsAPI.entity.Port;
import com.Maritime.CruiseShipsOpsAPI.entity.Ship;
import com.Maritime.CruiseShipsOpsAPI.exception.PortNotFoundException;
import com.Maritime.CruiseShipsOpsAPI.exception.ShipNotFoundException;
import com.Maritime.CruiseShipsOpsAPI.repository.PortRepo;
import com.Maritime.CruiseShipsOpsAPI.repository.ShipRepo;
import com.Maritime.CruiseShipsOpsAPI.service.IPortService;
import com.Maritime.CruiseShipsOpsAPI.util.mapper.PortEntityMapper;
import com.Maritime.CruiseShipsOpsAPI.util.mapper.ShipEntityMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.expression.ExpressionException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PortServiceImpl implements IPortService {

    private final PortRepo portRepo;
    private final ShipRepo shipRepo;
    private final PortEntityMapper mapper;

    public PortServiceImpl(PortRepo portrepo, ShipRepo shipRepo, PortEntityMapper mapper) {
        portRepo = portrepo;
        this.shipRepo = shipRepo;
        this.mapper = mapper;
    }

    @Override
    public PortResponseDto getPortDetails(Long id) {
        Port port = this.portRepo.findById(id).orElseThrow(()->new PortNotFoundException(String.format("This port has not found", id)));
        this.portRepo.save(port);
        return this.mapper.portEntityToDto(port);
    }

    @Override
    public List<PortResponseDto> getAllPortsDetails() {
        List<Port> ports = this.portRepo.findAll();
        return this.mapper.portEntityToDtoList(ports);

    }

    @Override
    public PortResponseDto updatePortDetails(Long id, PortRequestDto dto) {
        Port searchedPort = this.portRepo.findById(id).orElseThrow(()->new PortNotFoundException(String.format("This port has not found", id)));
        searchedPort.setName(dto.getName());
        searchedPort.setCountry(dto.getCountry());
        return this.mapper.portEntityToDto(this.portRepo.save(searchedPort));
    }

    @Override
    public int deletePortDetails(Long id) {
//        Port searchedPort = this.portRepo.findById(id).orElseThrow(()->new RuntimeException(String.format("This port has not found", id)));
        if(!this.portRepo.existsById(id)){
            throw new PortNotFoundException(String.format("This port has not found", id));
        }
        else {
            this.portRepo.deleteById(id);
            return 1;
        }
    }

    @Override
    public PortResponseDto createOnePort(PortRequestDto dto) {
       Port newPort = this.mapper.portDtoToEntity(dto);
       return this.mapper.portEntityToDto(this.portRepo.save(newPort));
    }

    @Override
    public PortResponseWithShipDto associateNewShipToPort(Long portId, Long shipId) {
        Port port = this.portRepo.findById(portId).orElseThrow(()->new PortNotFoundException(String.format("Port not found with id ", portId)));
        Ship ship = this.shipRepo.findById(shipId).orElseThrow(()->new ShipNotFoundException(String.format("Ship not found with id ", shipId)));

        ship.setHomePort(port);
        this.shipRepo.save(ship);
//        return this.mapper.portWithShipsEntityToDto(this.portRepo.findById(portId));
        Port updatedPort = this.portRepo.findById(portId)
                .orElseThrow(() -> new PortNotFoundException(String.format("Port not found with id %d", portId)));
        return this.mapper.portWithShipsEntityToDto(updatedPort);
    }

    @Override
    public PortResponseWithShipDto disassociateShipFromPort(Long portId, Long shipId) {
        Port port = this.portRepo.findById(portId).orElseThrow(()->new PortNotFoundException(String.format("Port not found with id ", portId)));
        Ship ship = this.shipRepo.findById(shipId).orElseThrow(()->new ShipNotFoundException(String.format("Ship not found with id ", shipId)));

        if(ship.getHomePort() != null && ship.getHomePort().getId().equals(portId)){
            ship.setHomePort(null);
            this.shipRepo.save(ship);
        }
        else {
            throw new IllegalArgumentException("Ship has been disassociated");
        }

//        return this.mapper.portWithShipsEntityToDto(this.portRepo.findById(portId));
        Port updatedPort = this.portRepo.findById(portId)
                .orElseThrow(() -> new PortNotFoundException(String.format("Port not found with id %d", portId)));
        return this.mapper.portWithShipsEntityToDto(updatedPort);
    }
}
