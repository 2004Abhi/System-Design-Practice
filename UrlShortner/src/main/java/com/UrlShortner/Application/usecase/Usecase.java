package com.UrlShortner.Application;

import com.UrlShortner.Domain.UrlShortnerService;

import lombok.RequiredArgsConstructor;

/*
 * Usecase class to encapsulate the business logic for URL shortening.
 *
 * Purpose:
 * This class is responsible for orchestrating the URL shortening process
 * by delegating to the domain service.
 */
@RequiredArgsConstructor
public class Usecase {
    private final UrlShortnerService urlShortnerService;
    public String generateShortUrl(String originalUrl) {
        return urlShortnerService.generateShortUrl(originalUrl);
    }
}
