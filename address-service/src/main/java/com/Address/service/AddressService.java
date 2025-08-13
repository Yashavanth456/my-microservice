package com.Address.service;

import com.Address.request.AddressRequest;
import com.Address.response.AddressResponse;

public interface AddressService {
    public AddressResponse createAddress(AddressRequest request);
    public AddressResponse getAddressById(long id);
}
