package rentacar.org.rentalcarmgntapp.service.impl;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import rentacar.org.rentalcarmgntapp.domain.Customer;
import rentacar.org.rentalcarmgntapp.domain.Reservation;
import rentacar.org.rentalcarmgntapp.domain.Vehicle;
import rentacar.org.rentalcarmgntapp.dto.request.ReservationRequestDto;
import rentacar.org.rentalcarmgntapp.repository.ReservationRepository;
import rentacar.org.rentalcarmgntapp.service.CustomerService;
import rentacar.org.rentalcarmgntapp.service.ReservationService;
import rentacar.org.rentalcarmgntapp.service.VehicleService;

import java.util.List;
import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class ReservationServiceImpl implements ReservationService {
    private final ReservationRepository reservationRepository;
    private final CustomerService customerService;
    private final VehicleService vehicleService;
    private final ModelMapper modelMapper;

    @Override
    public List<Reservation> getAllReservations() {
        return reservationRepository.findAll();
    }

    @Override
    public Reservation getReservationById(Long id) {
        return reservationRepository.findById(id).orElseThrow(() -> new NoSuchElementException("Reservation not found"));
    }


    @Override
    public Reservation addReservation(ReservationRequestDto reservationRequestDto) {
        Customer customer = customerService.getCustomerById(reservationRequestDto.getCustomerId());
        Vehicle vehicle = vehicleService.getVehicleById(reservationRequestDto.getVehicleId());
        vehicle.setReserved(true);
        Reservation reservation = new Reservation(null, reservationRequestDto.getPickupLocation(), reservationRequestDto.getDropOffLocation(), reservationRequestDto.getStartDate(), reservationRequestDto.getEndDate(), false, customer, vehicle);

        return reservationRepository.save(reservation);
    }

    @Override
    public Reservation updateReservation(Long id, ReservationRequestDto updatedReservationRequestDto) {
        Reservation existingReservation = reservationRepository.findById(id).orElseThrow(() -> new NoSuchElementException("Reservation not found"));

        Customer customer = customerService.getCustomerById(updatedReservationRequestDto.getCustomerId());
        Vehicle vehicle = vehicleService.getVehicleById(updatedReservationRequestDto.getVehicleId());
        vehicle.setReserved(true);
        existingReservation.setPickupLocation(updatedReservationRequestDto.getPickupLocation());
        existingReservation.setDropOffLocation(updatedReservationRequestDto.getDropOffLocation());
        existingReservation.setStartDate(updatedReservationRequestDto.getStartDate());
        existingReservation.setEndDate(updatedReservationRequestDto.getEndDate());
        existingReservation.setCustomer(customer);
        existingReservation.setVehicle(vehicle);
        return reservationRepository.save(existingReservation);
    }

    @Override
    public void deleteReservation(Long id) {
        reservationRepository.deleteById(id);
    }

    @Override
    public void checkoutReservation(Long id) {
        Reservation reservation = reservationRepository.findById(id).orElseThrow(() -> new NoSuchElementException("Reservation not found"));
        // I need to calculate the cost
        reservation.setPickedUp(true);
        reservation.getVehicle().setReserved(false);
        reservationRepository.save(reservation);
    }
}

