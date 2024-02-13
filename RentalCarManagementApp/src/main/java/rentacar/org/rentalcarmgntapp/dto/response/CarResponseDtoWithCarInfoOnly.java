package rentacar.org.rentalcarmgntapp.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CarResponseDtoWithCarInfoOnly {
    private String make;
    private String model;
    private int year;
    private String registrationNum;
}
