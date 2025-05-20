package com.Maritime.CruiseShipsOpsAPI.api;


import com.Maritime.CruiseShipsOpsAPI.dto.request.AssociateRequestDto;
import com.Maritime.CruiseShipsOpsAPI.dto.request.PortRequestDto;
import com.Maritime.CruiseShipsOpsAPI.dto.request.ShipRequestDto;
import com.Maritime.CruiseShipsOpsAPI.service.IPortService;
import com.Maritime.CruiseShipsOpsAPI.util.StandardResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/ports")
public class PortController {

    private final IPortService service;

    public PortController(IPortService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<StandardResponse> createPort(@RequestBody PortRequestDto dto){
        return new ResponseEntity<>(
                new StandardResponse(
                        201 , "Port created Successfully" , this.service.createOnePort(dto)
                ), HttpStatus.CREATED
        );
    }

    @GetMapping("/{id}")
    public ResponseEntity<StandardResponse> getPortDetails(@PathVariable Long id){
        return new ResponseEntity<>(
                new StandardResponse(
                        200, "Data are fetched" , this.service.getPortDetails(id)
                ),HttpStatus.OK
        );
    }

    @GetMapping
    public ResponseEntity<StandardResponse> getAllPortDetails(){
        return new ResponseEntity<>(
                new StandardResponse(
                        200 , "Ports Details are fetched" , this.service.getAllPortsDetails()
                ),HttpStatus.OK
        );
    }

    @PutMapping("/{id}")
    public ResponseEntity<StandardResponse> updatePortDetails(@PathVariable Long id, @RequestBody PortRequestDto dto){
        return new ResponseEntity<>(
                new StandardResponse(
                        201 , "Data has been updated" , this.service.updatePortDetails(id,dto)
                ),HttpStatus.CREATED
        );
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<StandardResponse> deletePortDetails(@PathVariable Long id){
        return new ResponseEntity<>(
                new StandardResponse(
                        204, "Port Data has been deleted from the server" , this.service.deletePortDetails(id)
                ),HttpStatus.NO_CONTENT
        );
    }

    @PostMapping("/associate")
    public ResponseEntity<StandardResponse> associateNewShipToPort(@RequestBody AssociateRequestDto dto){
        return new ResponseEntity<>(
                new StandardResponse(
                        201, "A new ship has been associated" , this.service.associateNewShipToPort(dto.getPortId(), dto.getShipId())
                ),HttpStatus.OK
        );
    }

    @PostMapping("/disassociate")
    public ResponseEntity<StandardResponse> disassociateShipFromPort(@RequestBody AssociateRequestDto dto){
        return new ResponseEntity<>(
                new StandardResponse(
                        201, "The ship has been detached" , this.service.disassociateShipFromPort(dto.getPortId(), dto.getShipId())
                ),HttpStatus.OK
        );
    }



}
