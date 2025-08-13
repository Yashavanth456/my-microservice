package com.Address.controller;


import com.Address.request.AddressRequest;
import com.Address.response.AddressResponse;
import com.Address.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/address")
@RefreshScope
public class AddressController {

    @Autowired
    AddressService addressService;

    @Value("${address.test}")
    private String test;

    @PostMapping("/create")
    public AddressResponse createAddress(@RequestBody AddressRequest request){
        return  addressService.createAddress(request);
    }

    @GetMapping("/getById/{id}")
    public AddressResponse getAddressById(@PathVariable long id){
        return addressService.getAddressById(id);
    }
    @GetMapping("/test")
    public String test(){
        return test;
    }

}
