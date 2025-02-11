package com.phu.service.department;

import io.micrometer.tracing.annotation.NewSpan;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/departments")
public class DepartmentController {

    private final DepartmentService departmentService;

    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @GetMapping
    public List<Department> findAllDepartment() {
        return departmentService.findAllDepartment();
    }

    @NewSpan
    @GetMapping("/{id}")
    public Department findDepartmentById(@PathVariable String id) {
        return departmentService.findDepartmentById(id);
    }

    @PostMapping
    public Department addNewDepartment(@RequestBody Department department) {
        return departmentService.addNewDepartment(department);
    }

    @PutMapping("/{id}")
    public Department putDepartment(@PathVariable String id, @RequestBody Department department) {
        return departmentService.updateDepartment(id, department);
    }

    @DeleteMapping("/{id}")
    public void deleteDepartment(@PathVariable String id) {
        departmentService.deleteDepartment(id);
    }

    @GetMapping("/organization/{organizationId}")
    public List<Department> findDepartmentByOrganizationId(@PathVariable String organizationId) {
        return departmentService.findDepartmentByOrganizationId(organizationId);
    }

}
