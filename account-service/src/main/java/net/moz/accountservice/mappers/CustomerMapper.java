package net.moz.accountservice.mappers;

import net.moz.accountservice.model.Customer;
import net.moz.customerservice.stub.CustomerServiceOuterClass;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class CustomerMapper {
    private ModelMapper modelMapper=new ModelMapper();
    public Customer fromSoapCustomer(net.moz.customerservice.web.Customer soapCustomer){
        return modelMapper.map(soapCustomer,Customer.class);
    }
    public Customer fromGrpcCustomer(CustomerServiceOuterClass.Customer grpcCustomer){
        return modelMapper.map(grpcCustomer, Customer.class);
    }
}
