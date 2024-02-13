package rentacar.org.rentalcarmgntapp.service.impl;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import rentacar.org.rentalcarmgntapp.domain.Customer;
import rentacar.org.rentalcarmgntapp.domain.Reservation;
import rentacar.org.rentalcarmgntapp.dto.request.CustomerRequestDto;
import rentacar.org.rentalcarmgntapp.dto.response.CarResponseDtoWithCarInfoOnly;
import rentacar.org.rentalcarmgntapp.dto.response.CustomerResponseDto;
import rentacar.org.rentalcarmgntapp.dto.response.ReservationResponseDtoWithReservationInfoOnly;
import rentacar.org.rentalcarmgntapp.repository.CustomerRepository;
import rentacar.org.rentalcarmgntapp.service.CustomerService;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService {
    private final CustomerRepository customerRepository;
    private final ModelMapper modelMapper;

    @Override
    public List<CustomerResponseDto> getAllCustomers() {
        var customers = customerRepository.findAll();
       List<CustomerResponseDto> customerResponseDtos=new ArrayList<>();

       for(Customer c: customers){
           List<ReservationResponseDtoWithReservationInfoOnly> reservationDTos = new ArrayList<>();
           List<CarResponseDtoWithCarInfoOnly> carInfoOnlyList = new ArrayList<>();
          List<Reservation> reservations = c.getReservations();
           for(Reservation reservation: reservations){
               reservationDTos .add(
                      new ReservationResponseDtoWithReservationInfoOnly(
                            reservation.getPickupLocation(),
                            reservation.getDropOffLocation(),
                            reservation.getStartDate(),
                            reservation.getEndDate(),
                            reservation.isPickedUp(),
                            modelMapper.map(reservation.getVehicle(), CarResponseDtoWithCarInfoOnly.class)
                       ));

               customerResponseDtos.add(
                       new CustomerResponseDto(c.getCustomerNumber(), c.getName(),c.getEmail()
                               ,reservationDTos
                       )
               );
           }

       }




        return customerResponseDtos;
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
