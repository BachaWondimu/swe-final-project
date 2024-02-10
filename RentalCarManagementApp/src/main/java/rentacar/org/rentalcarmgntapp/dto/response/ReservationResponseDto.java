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
public class ReservationResponseDto {
    private String pickupLocation;
    private String dropOffLocation;
    private LocalDate startDate;
    private LocalDate endDate;
    private boolean isPickedUp;
    //customer info
    private String customerNumber;
    private String name;
    private String email;
    //vehicle info
    private String make;
    private String model;
    private int year;
    private String registrationNum;
}
