package com.example.car_rental_backend.service.impl;
import com.example.car_rental_backend.dao.CustomerDao;
import com.example.car_rental_backend.dto.CustomerDto;
import com.example.car_rental_backend.entity.CustomerEntity;
import com.example.car_rental_backend.service.CustomerService;
import com.example.car_rental_backend.util.Mapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class CustomerSerivceImpl implements CustomerService {

    @Autowired
    private CustomerDao customerDao;

    @Autowired
    private Mapping mapping;

    @Override
    public CustomerDto addCustomer(CustomerDto customerDto) {
        CustomerEntity customerEntity = customerDao.save(mapping.toCustomerEntity(customerDto));

        if (customerEntity == null){
            throw new RuntimeException("customer not save");
        }

        return mapping.toCustomerDTO(customerEntity);
    }

    @Override
    public List<CustomerDto> getCustomers() {
        List<CustomerEntity> customerEntities = customerDao.findAll();
        return mapping.asCustomerEntityList(customerEntities);
    }


    @Override
    public void deleteCar(String id) {
         customerDao.deleteById(id);
    }


    @Override
    public CustomerDto updateCustomer(CustomerDto customerDto) {
        Optional<CustomerEntity> existingCustomer = customerDao.findById(customerDto.getPhone());
    
        if (existingCustomer.isPresent()) {
            CustomerEntity updatedCustomer = existingCustomer.get();
            updatedCustomer.setName(customerDto.getName());
            updatedCustomer.setEmail(customerDto.getEmail());
            updatedCustomer.setLicense(customerDto.getLicense());
            updatedCustomer.setAddress(customerDto.getAddress());

            CustomerEntity savedCustomer = customerDao.save(updatedCustomer);

            return mapping.toCustomerDTO(savedCustomer);
        }
    
        throw new RuntimeException("Customer not found");
    }
    
}
