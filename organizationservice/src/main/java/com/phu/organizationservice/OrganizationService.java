package com.phu.organizationservice;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrganizationService {

    private final OrganizationRepository organizationRepository;

    public OrganizationService(OrganizationRepository organizationRepository) {
        this.organizationRepository = organizationRepository;
    }

    public List<Organization> findAllOrganization() {
        return organizationRepository.findAll();
    }

    public void addNewOrganization(Organization organization) {
        organizationRepository.save(organization);
    }

    public void deleteOrganizationById(String id) {
        organizationRepository.deleteById(id);
    }

    public Organization findOrganizationById(String id) {
        return organizationRepository.findById(id).orElse(null);
    }

    public Organization updateOrganizationById(String id, Organization organization) {
        organizationRepository.findById(id).ifPresent(o -> organization.setId(o.getId()));
        return organizationRepository.save(organization);
    }
}
