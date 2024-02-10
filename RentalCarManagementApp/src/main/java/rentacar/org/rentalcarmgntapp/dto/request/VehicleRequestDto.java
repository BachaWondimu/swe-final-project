package rentacar.org.rentalcarmgntapp.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class VehicleRequestDto {
    private String make;
    private String model;
    private int year;
    private String registrationNum;
}

