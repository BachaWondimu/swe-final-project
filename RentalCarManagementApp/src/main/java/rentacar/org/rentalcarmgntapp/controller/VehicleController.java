package rentacar.org.rentalcarmgntapp.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import rentacar.org.rentalcarmgntapp.domain.Vehicle;
import rentacar.org.rentalcarmgntapp.dto.request.VehicleRequestDto;
import rentacar.org.rentalcarmgntapp.service.VehicleService;

import java.util.List;

@RestController
@RequestMapping("/rent-a-car/vehicles")
@RequiredArgsConstructor
public class VehicleController {

    private final VehicleService vehicleService;

    @GetMapping
    public ResponseEntity<List<Vehicle>> getAllVehicles() {
        List<Vehicle> vehicles = vehicleService.getAllVehicles();
        return ResponseEntity.ok(vehicles);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Vehicle> getVehicleById(@PathVariable Long id) {
        Vehicle vehicle = vehicleService.getVehicleById(id);
        return ResponseEntity.ok(vehicle);
    }
    @PostMapping("add")
    public ResponseEntity<Vehicle> addVehicle(@RequestBody VehicleRequestDto vehicleRequestDto) {
        Vehicle savedVehicle = vehicleService.addVehicle(vehicleRequestDto);
        return new ResponseEntity<>(savedVehicle, HttpStatus.CREATED);
    }

    @PutMapping("update")
    public ResponseEntity<Vehicle> updateVehicle(@RequestBody Vehicle updatedVehicle) {
        Vehicle vehicle = vehicleService.updateVehicle(updatedVehicle);
        return ResponseEntity.ok(vehicle);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteVehicle(@PathVariable Long id) {
        vehicleService.deleteVehicle(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}

