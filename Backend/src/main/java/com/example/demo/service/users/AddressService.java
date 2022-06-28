package com.example.demo.service.users;

import com.example.demo.model.users.Address;
import com.example.demo.repository.users.AddressRepository;
import org.springframework.stereotype.Service;

@Service
public class AddressService {

    private AddressRepository addressRepository;

    public  AddressService(AddressRepository repository){ this.addressRepository=repository;}

    public Address save(Address course) {
        return addressRepository.save(course);
    }

}
