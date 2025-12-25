package com.UrlShortner.Domain.Port;

import com.UrlShortner.Domain.internal_dto.UrlMappingDto;

public interface IUrlShortnerDBPort {
    public abstract void saveUrlMapping(String originalUrl, String shortenedUrl);
    public abstract UrlMappingDto getOriginalUrl(String shortenedUrl);
}
