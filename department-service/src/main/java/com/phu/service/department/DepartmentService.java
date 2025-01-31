package com.phu.service.department;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.phu.service.employee.Employee;
import com.phu.service.employee.EmployeeClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RibbonClient("employee-service")
public class DepartmentService {

    private final DepartmentRepository departmentRepository;
    private final EmployeeClient employeeClient;

    public DepartmentService(DepartmentRepository departmentRepository, EmployeeClient employeeClient) {
        this.departmentRepository = departmentRepository;
        this.employeeClient = employeeClient;
    }

    public List<Department> findAllDepartment() {
        return departmentRepository.findAll();
    }

    public Department addNewDepartment(Department department) {
        return departmentRepository.save(department);
    }

    public Department updateDepartment(String departmentId, Department department) {
        departmentRepository.findById(departmentId).ifPresent(d -> department.setId(d.getId()));
        return departmentRepository.save(department);
    }

    public void deleteDepartment(String departmentId) {
        departmentRepository.deleteById(departmentId);
    }

    public List<Department> findDepartmentByOrganizationId(String organizationId) {
        return departmentRepository.findByOrganizationId(organizationId);
    }

    @HystrixCommand(fallbackMethod = "findDepartmentByIdRecovery")
    public Department findDepartmentById(String id) {
        Optional<Department> department = departmentRepository.findById(id);

        department.ifPresent(d -> {
            List<Employee> employees = employeeClient.findEmployeeByDepartmentId(d.getId());
            d.setEmployees(employees);
        });

        return department.orElse(null);
    }

    public Department findDepartmentByIdRecovery(String id) {
        return departmentRepository.findById(id).orElse(null);
    }
}