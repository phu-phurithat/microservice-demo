package com.phu.organizationservice;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/organization")
public class OrganizationController {

    private final OrganizationService organizationService;

    public OrganizationController(OrganizationService organizationService) {
        this.organizationService = organizationService;
    }
    @GetMapping
    public List<Organization> findAllOrganization() {
        return organizationService.findAllOrganization();
    }

    @PostMapping
    public void addNewOrganization(Organization organization) {
        organizationService.addNewOrganization(organization);
    }

    @DeleteMapping
    public void deleteOrganizationById(String id) {
        organizationService.deleteOrganizationById(id);
    }

    @GetMapping("/{id}")
    public Organization findOrganizationById(String id) {
        return organizationService.findOrganizationById(id);
    }

    @PutMapping
    public Organization updateOrganizationById(String id, Organization organization) {
        return organizationService.updateOrganizationById(id, organization);
    }
}
