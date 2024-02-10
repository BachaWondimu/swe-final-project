package rentacar.org.rentalcarmgntapp.service;

import rentacar.org.rentalcarmgntapp.domain.Vehicle;
import rentacar.org.rentalcarmgntapp.dto.request.VehicleRequestDto;

import java.util.List;

public interface VehicleService {
    List<Vehicle> getAllVehicles();
    Vehicle getVehicleById(Long id);
    Vehicle addVehicle(VehicleRequestDto vehicleRequestDto);
    Vehicle updateVehicle(Vehicle updatedVehicle);
    void deleteVehicle(Long id);
}
