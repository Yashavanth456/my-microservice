package com.student_service.service;

import com.student_service.entity.Student;
import com.student_service.feignClients.AddressFeignClient;
import com.student_service.repository.StudentRepository;
import com.student_service.request.StudentRequest;
import com.student_service.response.AddressResponse;
import com.student_service.response.StudentResponse;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Service
public class StudentService {

    @Autowired
    StudentRepository studentRepository;

    @Autowired
    AddressFeignClient addressFeignClient;

    @Autowired
    CommonService commonService;

    @Autowired
    WebClient webClient;

    Logger logger = LoggerFactory.getLogger(StudentService.class);

    public StudentResponse createStudent(StudentRequest studentRequest) {

        Student student = new Student();
        student.setFirstName(studentRequest.getFirstName());
        student.setLastName(studentRequest.getLastName());
        student.setEmail(studentRequest.getEmail());

        student.setAddressId(studentRequest.getAddressId());
        student = studentRepository.save(student);
        StudentResponse studentResponse = new StudentResponse(student);
       // studentResponse.setAddressResponse(getAddressById(student.getAddressId()));
        studentResponse.setAddressResponse(commonService.getAddressById(student.getAddressId()));
        return studentResponse;
    }

    public StudentResponse getById (long id) {
        logger.info("Inside get student by id: " + id);
        Student student = studentRepository.findById(id).get();
        StudentResponse studentResponse = new StudentResponse(student);
        //studentResponse.setAddressResponse(getAddressById(student.getAddressId()));
        studentResponse.setAddressResponse(commonService.getAddressById(student.getAddressId()));
        return studentResponse;
    }

//    public AddressResponse getAddressById(long addressId) {
//        return webClient.get()
//                .uri("/getById/" + addressId)
//                .retrieve()
//                .bodyToMono(AddressResponse.class)
//                .block();
//    }

//    @CircuitBreaker(name = "addressService", fallbackMethod = "fallbackGetAddressById")
//    public AddressResponse getAddressById(long addressId) {
//        AddressResponse addressResponse = addressFeignClient.getAddressById(addressId);
//        return addressResponse;
//    }
//    public AddressResponse fallbackGetAddressById(long addressId, Throwable th) {
//        return new AddressResponse();
//    }
}
