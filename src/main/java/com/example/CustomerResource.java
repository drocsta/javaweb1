package com.example;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
public class CustomerResource {

    @Autowired
    private CustomerRepository repository;

    public CustomerResource(CustomerRepository repository) {
        this.repository = repository;
    }

@RequestMapping(value ="/consumidor/", method=RequestMethod.GET)
public Iterable<Customer> buscarConsumidor(@RequestParam(required = false) String firstName) {
    return this.repository.findAll();
}

@RequestMapping(value ="/consumidor/{id}", method = RequestMethod.GET)
public Optional<Customer> buscarConsumidor(@PathVariable Long id) {
    return this.repository.findById(id);
}

@RequestMapping(value = "/consumidor/{id}", method = RequestMethod.DELETE)
public void removeConsumidor(@PathVariable Long id) {
    this.repository.deleteById(id);
}

@RequestMapping(value = "/consumidor/", method = RequestMethod.POST)
public Customer criarConsumidor(@RequestBody Customer consumidor) {
    String firstName = consumidor.getFirstName();
    String lastName = consumidor.getLastName();
    return this.repository.save(new Customer(firstName, lastName));
}

@RequestMapping(value = "/consumidor/{id}", method = RequestMethod.PUT)
public void alterarConsumidor(@PathVariable Long id, @RequestBody Customer consumidorParam) {
    Customer consumidor = this.repository.findById(id).get();
    consumidor.setFirstName(consumidorParam.getFirstName());
    consumidor.setLastName(consumidorParam.getLastName());
    this.repository.save(consumidor);
}

}