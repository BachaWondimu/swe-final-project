package rentacar.org.rentalcarmgntapp.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import rentacar.org.rentalcarmgntapp.domain.Reservation;

@Repository
public interface ReservationRepository extends JpaRepository<Reservation, Long> {

}


