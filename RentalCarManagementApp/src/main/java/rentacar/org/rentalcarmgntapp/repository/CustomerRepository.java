package rentacar.org.rentalcarmgntapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import rentacar.org.rentalcarmgntapp.domain.Customer;

public interface CustomerRepository extends JpaRepository<Customer,Long> {
}
