package rentacar.org.rentalcarmgntapp.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ReservationRequestDto {
    private String pickupLocation;
    private String dropOffLocation;
    private LocalDate startDate;
    private LocalDate endDate;
    private Long customerId;
    private Long vehicleId;
}
