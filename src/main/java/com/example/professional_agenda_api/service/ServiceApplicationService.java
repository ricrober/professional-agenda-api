package com.example.professional_agenda_api.service;

import java.util.List;
import java.util.UUID;

import org.springframework.transaction.annotation.Transactional;

import com.example.professional_agenda_api.entity.Service;
import com.example.professional_agenda_api.repository.ServiceRepository;

@org.springframework.stereotype.Service
@Transactional
public class ServiceApplicationService {
    
    private final ServiceRepository serviceRepository;

    public ServiceApplicationService(ServiceRepository serviceRepository) {
        this.serviceRepository = serviceRepository;
    }

    public Service create(Service service) {
        return serviceRepository.save(service);
    }

    @Transactional(readOnly = true)
    public List<Service> findAll() {
        return serviceRepository.findAll();
    }

    @Transactional(readOnly = true)
    public Service findById(UUID id) {
        return serviceRepository.findById(id)
            .orElseThrow(
                () -> new IllegalArgumentException("Service not found")
            );
    }

    public void delete(UUID id) {
        serviceRepository.deleteById(id);
    }
}