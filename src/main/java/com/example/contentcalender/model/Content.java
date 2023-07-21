package com.example.contentcalender.model;

import java.time.LocalDateTime;

public record Content(
        Integer id,
        String title,
        String description,
        Status status,
        LocalDateTime dateCreated,
        Type contentType,
        LocalDateTime dateUpdated,
        String url
) {
    // Custom canonical constructor
    public Content(Integer id, String title, String description, Status status, Type contentType,
                   LocalDateTime dateCreated, LocalDateTime dateUpdated, String url) {
        this(id, title, description, status, dateCreated, contentType, dateUpdated, url);
    }
}
