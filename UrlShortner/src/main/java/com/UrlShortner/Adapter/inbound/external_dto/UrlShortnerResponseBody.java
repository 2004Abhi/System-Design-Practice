package com.UrlShortner.Adapter.inbound.external_dto;

import lombok.Getter;
import lombok.Setter;

/*
 * UrlShortnerResponseBody class to represent the response body for shortened URL
 * 
 * Purpose:
 * This class encapsulates the data returned after a URL has been shortened,
 * specifically the shortened URL itself.
 */
@Getter
@Setter
public class UrlShortnerResponseBody {
    private String shortenedUrl;
}
