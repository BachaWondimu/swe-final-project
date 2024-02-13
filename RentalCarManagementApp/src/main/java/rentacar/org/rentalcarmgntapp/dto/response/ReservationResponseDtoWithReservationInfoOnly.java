package rentacar.org.rentalcarmgntapp.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ReservationResponseDtoWithReservationInfoOnly {
    private String pickupLocation;
    private String dropOffLocation;
    private LocalDate startDate;
    private LocalDate endDate;
    private boolean isPickedUp;
    private CarResponseDtoWithCarInfoOnly car;
}
