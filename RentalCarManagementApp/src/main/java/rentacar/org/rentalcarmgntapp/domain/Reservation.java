package rentacar.org.rentalcarmgntapp.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String pickupLocation;
    private String dropOffLocation;
    private LocalDate startDate;
    private LocalDate endDate;
    private boolean isPickedUp;

    @ManyToOne(cascade = CascadeType.PERSIST)
//    @NotBlank
    private Customer customer;
    @ManyToOne(cascade = CascadeType.PERSIST)
//    @NotBlank
    private Vehicle vehicle;

}
