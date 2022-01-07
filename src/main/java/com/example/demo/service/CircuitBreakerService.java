package com.example.demo.service;

import com.example.demo.event.ServiceInformation;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.sun.org.slf4j.internal.Logger;
import com.sun.org.slf4j.internal.LoggerFactory;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;
import java.util.List;

@Service
public class CircuitBreakerService {

    private static final Logger logger = LoggerFactory.getLogger(CircuitBreakerService.class);

    private final RestTemplate restTemplate;

    public CircuitBreakerService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @HystrixCommand(fallbackMethod = "defaultStatus")
    public List<ServiceInformation> showServiceInformation() {
        List<ServiceInformation> information = restTemplate.exchange(
                "http://localhost:8081", HttpMethod.GET, null, new
                        ParameterizedTypeReference<List<ServiceInformation>>(){}).getBody();
        for(ServiceInformation serviceInformation : information) {
            logger.trace(serviceInformation.getServiceName());
            logger.trace(serviceInformation.getMessage());
        }
        return information;
    }

    public List<ServiceInformation> defaultStatus() {
        logger.error("circuit-breaker-proxy is down, running fallback method");
        return Collections.emptyList();
    }
}
