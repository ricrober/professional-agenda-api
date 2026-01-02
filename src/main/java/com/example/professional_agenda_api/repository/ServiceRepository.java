package com.example.professional_agenda_api.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.professional_agenda_api.entity.Service;

public interface ServiceRepository extends JpaRepository<Service, UUID> {}