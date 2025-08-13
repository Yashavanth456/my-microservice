package com.student_service.feignClients;

import com.student_service.response.AddressResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

//@FeignClient(url = "${address.service.url}", value = "address-feign-client", path = "/api/address")
//public interface AddressFeignClient {
//
//    @GetMapping("/getById/{id}")
//    public AddressResponse getAddressById(@PathVariable long id);
//}


//@FeignClient(value = "api-gateway", path = "address-service/api/address")
//public interface AddressFeignClient {
//
//    @GetMapping("/getById/{id}")
//    public AddressResponse getAddressById(@PathVariable long id);
//}
@FeignClient(value = "api-gateway")
public interface AddressFeignClient {

    @GetMapping("address-service/api/address/getById/{id}")
    public AddressResponse getAddressById(@PathVariable long id);
}
