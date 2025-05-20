package com.Maritime.CruiseShipsOpsAPI.api;

import com.Maritime.CruiseShipsOpsAPI.dto.request.OperationRequestDto;
import com.Maritime.CruiseShipsOpsAPI.dto.request.OperationStatusRequestDto;
import com.Maritime.CruiseShipsOpsAPI.dto.response.OperationResponseDto;
import com.Maritime.CruiseShipsOpsAPI.entity.enums.OperationStatus;
import com.Maritime.CruiseShipsOpsAPI.service.IOperationService;
import com.Maritime.CruiseShipsOpsAPI.util.StandardResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/operations")
public class OperationController {

    private final IOperationService service;

    @Autowired
    public OperationController(IOperationService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<StandardResponse> createOperation(@RequestBody OperationRequestDto dto){
        return new ResponseEntity<>(
                new StandardResponse(
                        201 , "Operation has been created" , this.service.createOperation(dto)
                ), HttpStatus.CREATED
        );
    }

    @GetMapping
    public ResponseEntity<StandardResponse> getALlOperation(){
        return new ResponseEntity<>(
                new StandardResponse(
                        200 , "Operations have been fetched" , this.service.getAllOperations()
                ), HttpStatus.OK
        );
    }

    @GetMapping(params = "shipId")
    public ResponseEntity<StandardResponse> getOneOperationByShipId(@RequestParam Long shipId){
        return new ResponseEntity<>(
                new StandardResponse(
                        200 , "Operations have been fetched by Ships" , this.service.getOperationsByShipId(shipId)
                ), HttpStatus.OK
        );
    }

    @GetMapping(params = "portId")
    public ResponseEntity<StandardResponse> getOneOperationByPortId(@RequestParam Long portId){
        return new ResponseEntity<>(
                new StandardResponse(
                        200 , "Operations have been fetched by Ports" , this.service.getOperationsByPortId(portId)
                ), HttpStatus.OK
        );
    }

    @PutMapping("/{shipId}")
    public ResponseEntity<StandardResponse> updateLatestOperationStatusByShip(@PathVariable Long shipId, @RequestBody OperationStatusRequestDto dto){
        return new ResponseEntity<>(
                new StandardResponse(
                        201 , "Operation status have been changed" , this.service.updateLatestOperationStatusByShip(shipId,dto)
                ), HttpStatus.CREATED
        );
    }

//    @PutMapping("/{shipId}/all")
//    public ResponseEntity<StandardResponse> updateAllOperationsStatusByShip(@PathVariable Long shipId, @RequestBody OperationStatus status){
//        return new ResponseEntity<>(
//                new StandardResponse(
//                        201 , "All Operation status have been changed" , this.service.updateAllOperationsStatusByShip(shipId,status)
//                ), HttpStatus.CREATED
//        );
//    }






}
