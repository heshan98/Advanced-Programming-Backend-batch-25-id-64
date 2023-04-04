package com.bumblebee.heshan.controller;

import com.bumblebee.heshan.model.Customers;
import com.bumblebee.heshan.model.Product;
import com.bumblebee.heshan.payload.response.MessageResponse;
import com.bumblebee.heshan.repository.CustomerRepository;
import com.bumblebee.heshan.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/customers")
@CrossOrigin(origins = "http://localhost:8081", maxAge = 3600, allowCredentials="true")
public class CustomersController {
    @Autowired
    CustomerService customerService;
    @Autowired
    PasswordEncoder encoder;
    @Autowired
    CustomerRepository customerRepository;
    @PostMapping(path = "/addCustomer")
    public ResponseEntity<MessageResponse> createCustomers(@RequestBody Customers customers) {

        if (customerRepository.existsByEmail(customers.getEmail())) {
            return ResponseEntity
                    .badRequest()
                    .body(new MessageResponse("Error: Email is already in use!"));
        } else {
            BCryptPasswordEncoder bCryptPasswordEncoder=new BCryptPasswordEncoder();
            String encrypt=bCryptPasswordEncoder.encode(customers.getPassword());
            customers.setPassword(encrypt);
            customerService.createCustomer(customers);
        }

        return null;
    }
    @GetMapping(path = "/getCustomers")
    public List<Customers> getCustomers(){
        return customerService.getCustomers();
    }

}
