package rentacar.org.rentalcarmgntapp.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import rentacar.org.rentalcarmgntapp.domain.Reservation;
import rentacar.org.rentalcarmgntapp.dto.request.ReservationRequestDto;
import rentacar.org.rentalcarmgntapp.service.ReservationService;

import java.util.List;

@RestController
@RequestMapping("/rent-a-car/reservations")
@RequiredArgsConstructor
public class ReservationController {

    private final ReservationService reservationService;

    @GetMapping
    public ResponseEntity<List<Reservation>> getAllReservations() {
        List<Reservation> reservations = reservationService.getAllReservations();
        return ResponseEntity.ok(reservations);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Reservation> getReservationById(@PathVariable Long id) {
        Reservation reservation = reservationService.getReservationById(id);
        return ResponseEntity.ok(reservation);
    }

    @PostMapping("/add")
    public ResponseEntity<Reservation> addReservation( @RequestBody ReservationRequestDto reservationRequestDto) {
        Reservation savedReservation = reservationService.addReservation(reservationRequestDto);
        return new ResponseEntity<>(savedReservation, HttpStatus.CREATED);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Reservation> updateReservation(@PathVariable Long id, @RequestBody ReservationRequestDto updatedReservation) {
        Reservation reservation = reservationService.updateReservation(id,updatedReservation);
        return ResponseEntity.ok(reservation);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteReservation(@PathVariable Long id) {
        reservationService.deleteReservation(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PostMapping("/checkout/{id}")
    public ResponseEntity<Void> checkoutReservation(@PathVariable Long id) {
        reservationService.checkoutReservation(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}

