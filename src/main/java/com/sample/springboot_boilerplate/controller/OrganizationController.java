package com.sample.springboot_boilerplate.controller;

import com.sample.springboot_boilerplate.dto.OrganizationDTO;
import com.sample.springboot_boilerplate.exception.ResourceNotFoundException;
import com.sample.springboot_boilerplate.service.OrganizationService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/org")
public class OrganizationController {

    private final OrganizationService organizationService;

    public OrganizationController(OrganizationService organizationService) {
        this.organizationService = organizationService;
    }

    @GetMapping("/list")
    public ResponseEntity<List<OrganizationDTO>> getAllOrganizations() {
        List<OrganizationDTO> organizations = organizationService.getAllOrganizations();
        return ResponseEntity.ok(organizations);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<?> getOrganizationById(@PathVariable Integer id) {
        try {
            OrganizationDTO organization = organizationService.getOrganizationById(id);
            return ResponseEntity.ok(organization);
        } catch (ResourceNotFoundException ex) {
            // Send a default 404 Not Found response
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
}
