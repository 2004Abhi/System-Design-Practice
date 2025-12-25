package com.UrlShortner.Domain.internal_dto;

import java.security.Timestamp;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UrlMappingDto {
    private String originalUrl;
    private String shortenedUrl;
    private Timestamp createdAt;
    private Timestamp ExpiresAt;
}
