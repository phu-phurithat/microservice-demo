package com.phu.service;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.phu.service.department.Department;
import com.phu.service.employee.Employee;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@Document
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Organization {
    @Id
    private String id;
    private String name;
    private String address;
    private List<Department> departments;
    private List<Employee> employees;
}
