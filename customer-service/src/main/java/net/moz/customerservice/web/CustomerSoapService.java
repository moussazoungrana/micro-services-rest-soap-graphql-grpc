package net.moz.customerservice.web;

import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import jakarta.jws.WebService;
import lombok.AllArgsConstructor;
import net.moz.customerservice.dto.CustomerRequest;
import net.moz.customerservice.entities.Customer;
import net.moz.customerservice.mappers.CustomerMapper;
import net.moz.customerservice.repository.CustomerRepository;
import org.springframework.stereotype.Component;

import java.util.List;

@WebService(serviceName = "CustomerWS")
@Component
@AllArgsConstructor
public class CustomerSoapService {
    private CustomerRepository customerRepository;
    private CustomerMapper customerMapper;

    @WebMethod
    public List<Customer> customerList(){
        return customerRepository.findAll();
    }

    @WebMethod
    public Customer customerById(@WebParam(name="id") Long id){
        return customerRepository.findById(id).get();
    }

    public Customer saveCustomer(@WebParam(name = "customer") CustomerRequest customerRequest){
        Customer customer = customerMapper.from(customerRequest);
        return customerRepository.save(customer);

    }

}
