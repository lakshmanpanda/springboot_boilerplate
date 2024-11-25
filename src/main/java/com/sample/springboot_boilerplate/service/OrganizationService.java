package com.sample.springboot_boilerplate.service;

import com.sample.springboot_boilerplate.dto.OrganizationDTO;

import java.util.List;

public interface OrganizationService {
    List<OrganizationDTO> getAllOrganizations();
    OrganizationDTO getOrganizationById(Integer id);
}
