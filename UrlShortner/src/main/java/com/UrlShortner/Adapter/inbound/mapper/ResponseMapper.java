package com.UrlShortner.Adapter.inbound.mapper;

import com.UrlShortner.Adapter.inbound.external_dto.UrlShortnerResponseBody;

public class ResponseMapper {
    public UrlShortnerResponseBody mapFromShortenedUrl(String shortUrl) {
        UrlShortnerResponseBody response = new UrlShortnerResponseBody();
        response.setShortenedUrl(shortUrl);
        return response;
    }
}
