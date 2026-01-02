package com.example.professional_agenda_api.dto;

import java.time.Duration;
import java.util.UUID;

public class ServiceResponse {
    
    private UUID id;
    private String name;
    private String description;
    private Duration duration;
    private boolean active;

    public ServiceResponse(
        UUID id,
        String name,
        String description,
        Duration duration,
        boolean active
    ) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.duration = duration;
        this.active = active;
    }

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public Duration getDuration() {
        return duration;
    }

    public boolean isActive() {
        return active;
    }

}
