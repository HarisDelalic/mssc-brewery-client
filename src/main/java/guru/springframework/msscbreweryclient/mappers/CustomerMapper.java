package guru.springframework.msscbreweryclient.mappers;

import guru.springframework.msscbreweryclient.domain.Customer;
import guru.springframework.msscbreweryclient.web.model.CustomerDto;
import org.mapstruct.Mapper;

@Mapper
public interface CustomerMapper {
    Customer customerDtoToCustomer(CustomerDto customerDto);
    CustomerDto customerToCustomerDto(Customer customer);
}
