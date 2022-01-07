package com.example.demo.event;

public class ServiceInformation {
    private String serviceName;
    private String message;

    public ServiceInformation(String serviceName, String message){
        this.serviceName = serviceName;
        this.message = message;
    }

    public String getServiceName() {
        return serviceName;
    }

    public String getMessage() {
        return message;
    }

}