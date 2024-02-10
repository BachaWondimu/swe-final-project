package rentacar.org.rentalcarmgntapp.service.impl;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import rentacar.org.rentalcarmgntapp.domain.Customer;
import rentacar.org.rentalcarmgntapp.dto.request.CustomerRequestDto;
import rentacar.org.rentalcarmgntapp.repository.CustomerRepository;
import rentacar.org.rentalcarmgntapp.service.CustomerService;

import java.util.List;
import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService {
    private final CustomerRepository customerRepository;
    private final ModelMapper modelMapper;

    @Override
    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }

    @Override
    public Customer getCustomerById(Long id) {
        return customerRepository.findById(id).orElseThrow(() -> new NoSuchElementException("Customer not found"));
    }

    @Override
    public Customer addCustomer(CustomerRequestDto customerRequestDto) {
        var customer = modelMapper.map(customerRequestDto, Customer.class);
        return customerRepository.save(customer);
    }

    @Override
    public Customer updateCustomer(Customer customer) {
        return customerRepository.save(customer);
    }

    @Override
    public void deleteCustomer(Long id) {
        customerRepository.deleteById(id);
    }
}
