package com.phu.service.employee;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient("employee-service")
public interface EmployeeClient {

    @GetMapping("/employees/department/{departmentId}")
    List<Employee> findEmployeeByDepartmentId(@PathVariable String departmentId);
}
