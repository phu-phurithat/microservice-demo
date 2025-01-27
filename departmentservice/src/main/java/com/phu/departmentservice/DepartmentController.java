package com.phu.departmentservice;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/departments")
public class DepartmentController {

    private final DepartmentService departmentService;

    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @PostMapping
    public Department createNewDepartment(Department department) {
        return departmentService.addNewDepartment(department);
    }

    @GetMapping
    public List<Department> findAllDepartment() {
        return departmentService.findAllDepartment();
    }

    @GetMapping("/{id}")
    public Department findDepartmentById(String id) {
        return departmentService.findDepartmentById(id);
    }

    @DeleteMapping
    public void deleteDepartmentById(String id) {
        departmentService.deleteDepartmentById(id);
    }

    @PutMapping
    public Department updateDepartmentById(String id, Department department) {
        return departmentService.updateDepartmentById(id, department);
    }
}
