package com.Address.service;

import com.Address.entity.Address;
import com.Address.repository.AddressRepository;
import com.Address.request.AddressRequest;
import com.Address.response.AddressResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class AddressServiceImpl implements AddressService{

    @Autowired
    private AddressRepository addressRepository;

    Logger LOGGER = LoggerFactory.getLogger(AddressServiceImpl.class);

    @Override
    public AddressResponse createAddress(AddressRequest request) {

        Address address = new Address();
        address.setStreet(request.getStreet());
        address.setCity(request.getCity());
        addressRepository.save(address);
        return new AddressResponse(address);
    }

    @Override
    public AddressResponse getAddressById(long id) {
        LOGGER.info("Inside get address by id: "+id);
        Address address = addressRepository.findById(id).get();
        return new AddressResponse(address);
    }
}
