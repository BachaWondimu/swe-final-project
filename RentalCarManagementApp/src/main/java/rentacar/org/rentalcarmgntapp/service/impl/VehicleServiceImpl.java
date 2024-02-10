package rentacar.org.rentalcarmgntapp.service.impl;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import rentacar.org.rentalcarmgntapp.domain.Vehicle;
import rentacar.org.rentalcarmgntapp.dto.request.VehicleRequestDto;
import rentacar.org.rentalcarmgntapp.repository.VehicleRepository;
import rentacar.org.rentalcarmgntapp.service.VehicleService;

import java.util.List;
import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class VehicleServiceImpl implements VehicleService {
    private final VehicleRepository vehicleRepository;
    private final ModelMapper modelMapper;

    @Override
    public List<Vehicle> getAllVehicles() {
        return vehicleRepository.findAll();
    }

    @Override
    public Vehicle getVehicleById(Long id) {
        return vehicleRepository.findById(id).orElseThrow(() -> new NoSuchElementException("Vehicle not found"));
    }

    @Override
    public Vehicle addVehicle(VehicleRequestDto vehicleRequestDto) {
        var vehicle = modelMapper.map(vehicleRequestDto, Vehicle.class);
        return vehicleRepository.save(vehicle);
    }

    @Override
    public Vehicle updateVehicle(Vehicle updatedVehicle) {
        return vehicleRepository.save(updatedVehicle);
    }

    @Override
    public void deleteVehicle(Long id) {
        vehicleRepository.deleteById(id);
    }

}
