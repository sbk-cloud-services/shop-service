package de.leuphana.shop.connector.mapper;

import de.leuphana.shop.component.structure.Customer;
import de.leuphana.shop.connector.dto.CustomerDTO;

public class CustomerMapper {

    public static CustomerDTO mapCustomertoCustomerDTO(Customer customer) {
        CustomerDTO customerDTO = new CustomerDTO();

        customerDTO.setFirstname(customer.getFirstname());
        customerDTO.setLastname(customer.getLastname());
        customerDTO.setId(customer.getId());
        customerDTO.setPostAddress(PostAddressMapper.mapPostAddresstoPostAddressDTO(customer.getPostAddress()));

        return customerDTO;
    }

    public static Customer mapCustomerDTOtoCustomer(CustomerDTO customerDTO) {
        Customer customer = new Customer();

        customer.setFirstname(customerDTO.getFirstname());
        customer.setLastname(customerDTO.getLastname());
        customer.setId(customerDTO.getId());
        customer.setPostAddress(PostAddressMapper.mapPostAddressDTOtoPostAddress(customerDTO.getPostAddress()));

        return customer;
    }

}
