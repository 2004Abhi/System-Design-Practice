package com.UrlShortner.Adapter.inbound.external_dto;

import java.util.List;

import jakarta.annotation.Nullable;
import lombok.Getter;
import lombok.Setter;

/*
 * UrlShortnerRequestBody class to represent the request body for URL shortening
 * 
 * Purpose:
 * This class encapsulates the data required to shorten a URL, including the original URL
 * and optional metadata that may provide additional context or information.
 */
@Getter
@Setter
public class UrlShortnerRequestBody {
    private String originalUrl;
    private @Nullable List<Metadata> metadata;
}