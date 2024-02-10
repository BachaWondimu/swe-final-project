package rentacar.org.rentalcarmgntapp.service;

import rentacar.org.rentalcarmgntapp.domain.Reservation;
import rentacar.org.rentalcarmgntapp.dto.request.ReservationRequestDto;

import java.util.List;

public interface ReservationService {
    List<Reservation> getAllReservations();
    Reservation getReservationById(Long id);
    Reservation addReservation(ReservationRequestDto reservationRequestDto);
    Reservation updateReservation(Long id, ReservationRequestDto updatedReservationRequestDto);
    void deleteReservation(Long id);
    void checkoutReservation(Long id);
}
