package com.UrlShortner.Adapter.inbound.mapper;

import com.UrlShortner.Adapter.inbound.external_dto.UrlShortnerRequestBody;

/*
 * RequestMapper class to map external DTOs to internal application values.
 *
 * Purpose:
 * This class is responsible for mapping the incoming request DTOs (like
 * UrlShortnerRequestBody) into the internal representation used by the
 * application's use-case layer.
 */
public class RequestMapper {
    public String mapToOriginalUrl(UrlShortnerRequestBody requestBody) {
        return requestBody.getOriginalUrl();
    }
}
