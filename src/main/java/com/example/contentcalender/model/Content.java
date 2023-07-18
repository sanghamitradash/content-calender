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
}