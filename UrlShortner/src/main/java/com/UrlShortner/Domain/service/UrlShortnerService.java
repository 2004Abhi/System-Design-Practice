package com.UrlShortner.Domain;

import org.springframework.beans.factory.annotation.Value;

import com.UrlShortner.Domain.Port.IUrlShortnerCachePort;
import com.UrlShortner.Domain.Port.IUrlShortnerDBPort;
import com.UrlShortner.Domain.internal_dto.UrlMappingDto;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class UrlShortnerService{
    private IUrlShortnerCachePort cachePort;
    private IUrlShortnerDBPort dbPort;
    @Value("${app.base-url}")
    private String BASE_URL;
    @Value("${app.TTL.minutes}")
    private long TTL;
    public String generateShortUrl(String originalUrl) {
        try{
            // check if URL already exists in cache
            String existingShortUrl = null;
            existingShortUrl=cachePort.getOriginalUrl(originalUrl); 
            if(existingShortUrl != null){
                return existingShortUrl;
            }
            // check if URL exists in DB
            UrlMappingDto urlMappingDto = dbPort.getOriginalUrl(originalUrl);
            if(urlMappingDto != null&& urlMappingDto.getExpiresAt()< urlMappingDto.getCreatedAt()+TTL){
                // save to cache for future requests
                cachePort.saveUrlMapping(originalUrl, urlMappingDto.getShortenedUrl());
                return urlMappingDto.getShortenedUrl();
            }
        }catch(Exception e){
            throw e;
        }
        // Simple hash-based shortening (for demonstration purposes)
        String shortUrl = Integer.toHexString(originalUrl.hashCode());
        // Here, you would typically save the mapping between originalUrl and shortUrl to a db via a port
        try{
            // save to db
            dbPort.saveUrlMapping(originalUrl, shortUrl);
        }catch(Exception e){
            throw e;
        }
        return BASE_URL + shortUrl;
    }
    public String getOriginalUrl(String shortenedUrl) {
        // Retrieval logic would go here (not implemented for brevity)
        return null;
    }
}
