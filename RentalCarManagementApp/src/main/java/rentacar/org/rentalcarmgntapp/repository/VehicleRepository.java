package rentacar.org.rentalcarmgntapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import rentacar.org.rentalcarmgntapp.domain.Vehicle;


@Repository
public interface VehicleRepository extends JpaRepository<Vehicle, Long> {

}


