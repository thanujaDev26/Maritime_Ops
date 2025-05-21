package com.Maritime.CruiseShipsOpsAPI.service.impl;

import com.Maritime.CruiseShipsOpsAPI.dto.request.OperationRequestDto;
import com.Maritime.CruiseShipsOpsAPI.dto.request.OperationStatusRequestDto;
import com.Maritime.CruiseShipsOpsAPI.dto.response.OperationResponseDto;
import com.Maritime.CruiseShipsOpsAPI.dto.response.OperationStatusResponseDto;
import com.Maritime.CruiseShipsOpsAPI.entity.Operation;
import com.Maritime.CruiseShipsOpsAPI.entity.Port;
import com.Maritime.CruiseShipsOpsAPI.entity.Ship;
import com.Maritime.CruiseShipsOpsAPI.entity.enums.OperationStatus;
import com.Maritime.CruiseShipsOpsAPI.exception.OperationNotFoundException;
import com.Maritime.CruiseShipsOpsAPI.exception.PortNotFoundException;
import com.Maritime.CruiseShipsOpsAPI.exception.ShipNotFoundException;
import com.Maritime.CruiseShipsOpsAPI.repository.OperationRepo;
import com.Maritime.CruiseShipsOpsAPI.repository.PortRepo;
import com.Maritime.CruiseShipsOpsAPI.repository.ShipRepo;
import com.Maritime.CruiseShipsOpsAPI.service.IOperationService;
import com.Maritime.CruiseShipsOpsAPI.util.mapper.OperationEntityMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@Service
public class OperationServiceImpl implements IOperationService {

    private final OperationRepo OpsRepo;
    private final ShipRepo shipRepo;
    private final PortRepo portRepo;
    private final OperationEntityMapper mapper;

    @Autowired
    public OperationServiceImpl(OperationRepo opsRepo, ShipRepo shipRepo, PortRepo portRepo, OperationEntityMapper mapper) {
        OpsRepo = opsRepo;
        this.shipRepo = shipRepo;
        this.portRepo = portRepo;
        this.mapper = mapper;
    }

    @Override
    public OperationResponseDto createOperation(OperationRequestDto dto) {
        Ship ship = this.shipRepo.findById(dto.getShipId())
                .orElseThrow(() -> new ShipNotFoundException("Ship is not found"));
        Port port = this.portRepo.findById(dto.getPortId())
                .orElseThrow(() -> new PortNotFoundException("Port is not found"));

        Operation operation = mapper.portDtoToEntity(dto);

        operation.setShip(ship);
        operation.setPort(port);

        if (dto.getOperationStatus() != null) {
            operation.setOperationStatus(dto.getOperationStatus());
        } else {
            operation.setOperationStatus(OperationStatus.PENDING);
        }

        Operation savedOperation = this.OpsRepo.save(operation);

        OperationResponseDto responseDto = mapper.portEntityToDto(savedOperation);


        responseDto.setShipName(ship.getName());
        responseDto.setPortName(port.getName());

        return responseDto;
    }


    @Override
    public List<OperationResponseDto> getAllOperations() {
        return this.mapper.portEntityToDtoList(this.OpsRepo.findAll());
    }

    @Override
    public List<OperationResponseDto> getOperationsByShipId(Long shipId) {
        List<Operation> ops = this.OpsRepo.findByShipId(shipId);
        if (ops.isEmpty()){
            throw new OperationNotFoundException("Operations are not found from this ship at the moment");
        }
        return this.mapper.portEntityToDtoList(ops);
    }

    @Override
    public List<OperationResponseDto> getOperationsByPortId(Long portId) {
        List<Operation> ops = this.OpsRepo.findByPortId(portId);
        if (ops == null){
            throw new OperationNotFoundException("Operations are not found from this ship at the moment");
        }
        return this.mapper.portEntityToDtoList(ops);
    }

    @Override
    public OperationStatusResponseDto updateLatestOperationStatusByShip(Long shipId, OperationStatusRequestDto Dto) {
        Operation ops = this.OpsRepo.findTopByShipIdOrderByStartTimeDesc(shipId).orElseThrow(()->new OperationNotFoundException("Operations cannot fetched from this ship"));

        ops.setOperationStatus(Dto.getStatus());
        Operation updated = OpsRepo.save(ops);

        OperationStatusResponseDto dto = new OperationStatusResponseDto();
        dto.setOperationId(updated.getId());
        dto.setStatus(updated.getOperationStatus());
        dto.setUpdatedAt(LocalDateTime.now());
        dto.setMessage("Latest operation status updated for ship ID: " + shipId);

        return dto;
    }

//    @Override
//    public List<OperationStatusResponseDto> updateAllOperationsStatusByShip(Long shipId, OperationStatus status) {
//        List<Operation> operations = OpsRepo.findAllByShipId(shipId);
//
//        if (operations.isEmpty()) {
//            throw new RuntimeException("No operations found for Ship ID: " + shipId);
//        }
//
//        List<OperationStatusResponseDto> responseList = new ArrayList<>();
//
//        for (Operation op : operations) {
//            op.setOperationStatus(status);
//            Operation updated = OpsRepo.save(op);
//
//            OperationStatusResponseDto dto = OperationStatusResponseDto.builder()
//                    .operationId(updated.getId())
//                    .status(updated.getOperationStatus())
//                    .message("Updated successfully")
//                    .updatedAt(LocalDateTime.now())
//                    .build();
//
//            responseList.add(dto);
//        }
//
//        return responseList;
//    }

}
