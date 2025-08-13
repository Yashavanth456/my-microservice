package com.student_service.request;


import lombok.Data;

@Data
public class StudentRequest {

    private String firstName;

    private String lastName;

    private String email;

    private long addressId;
}
