package rentacar.org.rentalcarmgntapp.service;

import rentacar.org.rentalcarmgntapp.domain.Customer;
import rentacar.org.rentalcarmgntapp.dto.request.CustomerRequestDto;
import rentacar.org.rentalcarmgntapp.dto.response.CustomerResponseDto;

import java.util.List;

public interface CustomerService {
    List<CustomerResponseDto> getAllCustomers();
    Customer getCustomerById(Long id);
    Customer addCustomer(CustomerRequestDto customerRequestDto);
    Customer updateCustomer(Customer updatedCustomer);
    void deleteCustomer(Long id);

}
