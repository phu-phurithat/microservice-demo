package com.phu.organizationservice;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document
public class Organization {
    @Id
    private String id;
    private String name;
    private String address;

}
