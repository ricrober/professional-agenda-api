package com.example.professional_agenda_api.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.professional_agenda_api.dto.CreateServiceRequest;
import com.example.professional_agenda_api.dto.ServiceResponse;
import com.example.professional_agenda_api.entity.Service;
import com.example.professional_agenda_api.service.ServiceApplicationService;

import jakarta.validation.Valid;

import java.util.List;
import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@RestController
@RequestMapping("/services")
public class ServiceController {
    
    private final ServiceApplicationService serviceApplicationService;

    public ServiceController(ServiceApplicationService serviceApplicationService) {
        this.serviceApplicationService = serviceApplicationService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ServiceResponse create(@RequestBody @Valid CreateServiceRequest request) {
        Service service = new Service(
            request.getName(),
            request.getDescription(),
            request.getDuration(),
            true
        );

        Service saved = serviceApplicationService.create(service);

        return toResponse(saved);
    }

    @GetMapping
    public List<ServiceResponse> findAll() {
        return serviceApplicationService.findAll()
            .stream()
            .map(this::toResponse)
            .toList();
    }

    @GetMapping("/{id}")
    public ServiceResponse findById(@PathVariable UUID id) {
        return toResponse(serviceApplicationService.findById(id));
    }
    
    
    private ServiceResponse toResponse(Service service) {
        return new ServiceResponse(
            service.getId(),
            service.getName(),
            service.getDescription(),
            service.getDuration(),
            service.isActive()
        );
    }

}
