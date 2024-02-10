package rentacar.org.rentalcarmgntapp.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import rentacar.org.rentalcarmgntapp.repository.CustomerRepository;
import rentacar.org.rentalcarmgntapp.service.CustomerService;

@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService {
    private final CustomerRepository customerRepository;
}
