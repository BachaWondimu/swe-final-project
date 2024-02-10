package rentacar.org.rentalcarmgntapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import rentacar.org.rentalcarmgntapp.domain.Staff;

@Repository
public interface StaffRepository extends JpaRepository<Staff, Long> {

}

