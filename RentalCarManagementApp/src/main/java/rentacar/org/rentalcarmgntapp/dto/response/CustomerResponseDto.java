package rentacar.org.rentalcarmgntapp.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CustomerResponseDto {
    private String customerNumber;
    private String name;
    private String email;
    private List<ReservationResponseDtoWithReservationInfoOnly> reservations;
}
