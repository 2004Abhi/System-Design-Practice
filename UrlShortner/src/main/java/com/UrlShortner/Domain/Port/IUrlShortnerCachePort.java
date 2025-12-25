package com.UrlShortner.Domain.Port;

public interface IUrlShortnerCachePort {
    public abstract void saveUrlMapping(String originalUrl, String shortenedUrl);
    public abstract String getOriginalUrl(String shortenedUrl);
}
