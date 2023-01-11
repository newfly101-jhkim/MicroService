package com.jhkim.microservice.model;


import lombok.Data;
import lombok.ToString;

@ToString
@Data
public class License {
    private int id;
    private String licenseId;
    private String description;
    private String organizationId;
    private String productName;
    private String licenseType;

}
