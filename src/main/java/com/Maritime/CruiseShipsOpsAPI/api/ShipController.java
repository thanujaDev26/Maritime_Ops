package com.Maritime.CruiseShipsOpsAPI.api;


import com.Maritime.CruiseShipsOpsAPI.dto.request.ShipRequestDto;
import com.Maritime.CruiseShipsOpsAPI.service.IShipService;
import com.Maritime.CruiseShipsOpsAPI.util.StandardResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/ships")
public class ShipController {

    private final IShipService _service;

    @Autowired
    public ShipController(IShipService _service) {
        this._service = _service;
    }

    @PostMapping
    public ResponseEntity<StandardResponse> saveNewShipDetails(@RequestBody ShipRequestDto dto){
        return new ResponseEntity<>(
                new StandardResponse(
                        201 , "Successfully Added a New CruiseShip" , this._service.createNewShip(dto)
                ), HttpStatus.CREATED
        );
    }

    @GetMapping("/{id}")
    public ResponseEntity<StandardResponse> getOneShipDetails(@PathVariable Long id){
        return new ResponseEntity<>(
                new StandardResponse(
                        200, "Ship data are fetched successfully", this._service.getShipById(id)
                ),HttpStatus.OK
        );
    }

    @GetMapping()
    public ResponseEntity<StandardResponse> getALlShipsDetails(){
        return new ResponseEntity<>(
                new StandardResponse(
                        200 , "Ships Data are Successfully Fetched", this._service.getAllShips()
                ),HttpStatus.OK
        );
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<StandardResponse> deleteOneShipDetails(@PathVariable Long id){
        int result = this._service.deleteShip(id);
        if (result == 1){
            return new ResponseEntity<>(
                    new StandardResponse(
                            200 , "Data is successfully Deleted!" , null
                    ),HttpStatus.NO_CONTENT
            );
        }
        else {
            throw new RuntimeException("Error happens While deleting");
        }

    }

    @PutMapping("/{id}")
    public ResponseEntity<StandardResponse> updateOneShipDetails(@PathVariable Long id, @RequestBody ShipRequestDto dto){
        return new ResponseEntity<>(
                new StandardResponse(
                        201 , "Data is successfully Updated" , this._service.updateShip(id,dto)
                ),HttpStatus.CREATED
        );
    }

}
