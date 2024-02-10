package rentacar.org.rentalcarmgntapp.service;

import rentacar.org.rentalcarmgntapp.dto.request.ReservationRequestDto;
import rentacar.org.rentalcarmgntapp.dto.response.ReservationResponseDto;

import java.util.List;

public interface ReservationService {
    List<ReservationResponseDto> getAllReservations();
    ReservationResponseDto getReservationById(Long id);
    ReservationResponseDto addReservation(ReservationRequestDto reservationRequestDto);
    ReservationResponseDto updateReservation(Long id, ReservationRequestDto updatedReservationRequestDto);
    void deleteReservation(Long id);
    void checkoutReservation(Long id);
}
