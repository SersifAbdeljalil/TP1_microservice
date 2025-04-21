package com.microservices;


import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class CustomerService{

    private final CustomerRepository customerRepository;

    public Customer createCustomer(CustomerRequest request) {
        Customer customer = Customer.builder()
                .firstName(request.firstName())
                .lastName(request.lastName())
                .email(request.email())
                .build();

        return customerRepository.saveAndFlush(customer);
    }

    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }

    public Optional<Customer> getCustomerById(Integer id) {
        System.out.println("🧪 [SERVICE] Recherche du client avec ID : " + id);
        Optional<Customer> customer = customerRepository.findById(id);
        System.out.println("Résultat → " + customer);
        return customer;
    }

    public Customer updateCustomer(Integer id, CustomerRequest request) {
        return customerRepository.findById(id).map(customer -> {
            customer.setFirstName(request.firstName());
            customer.setLastName(request.lastName());
            customer.setEmail(request.email());
            return customerRepository.save(customer);
        }).orElseGet(() -> {
            Customer customer = Customer.builder()
                    .firstName(request.firstName())
                    .lastName(request.lastName())
                    .email(request.email())
                    .build();
            return customerRepository.save(customer);
        });
    }

    public void deleteCustomer(Integer id) {
        customerRepository.deleteById(id);
    }
}
