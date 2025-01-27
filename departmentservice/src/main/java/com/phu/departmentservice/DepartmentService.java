package com.phu.departmentservice;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentService {

    private final DepartmentRepository departmentRepository;

    public DepartmentService(DepartmentRepository departmentRepository) {
        this.departmentRepository = departmentRepository;
    }

    public List<Department> findAllDepartment() {
        return departmentRepository.findAll();
    }

    public Department addNewDepartment(Department department) {
        return departmentRepository.save(department);
    }

    public void deleteDepartmentById(String id) {
        departmentRepository.deleteById(id);
    }

    public Department findDepartmentById(String id) {
        return departmentRepository.findById(id).orElse(null);
    }

    public Department updateDepartmentById(String id, Department department) {
        departmentRepository.findById(id).ifPresent(d -> department.setId(d.getId()));
        return departmentRepository.save(department);
    }
}
