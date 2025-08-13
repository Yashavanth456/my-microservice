//package com.student_service.feignClients;
//
//
//import feign.Feign;
//import org.springframework.cloud.client.loadbalancer.LoadBalanced;
//import org.springframework.cloud.loadbalancer.annotation.LoadBalancerClient;
//import org.springframework.context.annotation.Bean;
//
//@LoadBalancerClient(value = "address-service")
//public class AddressSerLoadBalancerConfig {
//
//    @LoadBalanced
//    @Bean
//    public Feign.Builder feignBuilder() {
//        return Feign.builder();
//    }
//}
