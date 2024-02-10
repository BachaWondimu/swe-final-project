package rentacar.org.rentalcarmgntapp.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import rentacar.org.rentalcarmgntapp.service.CustomerService;

@RestController
@RequestMapping("rent-a-car/")
@RequiredArgsConstructor
public class CustomerController {
    private final CustomerService customerService;
}
