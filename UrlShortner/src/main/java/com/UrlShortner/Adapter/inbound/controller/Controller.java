package com.UrlShortner.Adapter.inbound;

import org.springframework.web.bind.annotation.RestController;

import com.UrlShortner.Adapter.inbound.external_dto.UrlShortnerRequestBody;
import com.UrlShortner.Adapter.inbound.external_dto.UrlShortnerResponseBody;
import com.UrlShortner.Adapter.inbound.mapper.RequestMapper;
import com.UrlShortner.Adapter.inbound.mapper.ResponseMapper;
import com.UrlShortner.Application.Usecase;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * Inbound REST controller that handles URL shortening requests and delegates
 * business logic to the application use-case layer.
 *
 * Responsibilities:
 * - Map incoming JSON DTOs to application input values and map responses back
 * to DTOs.
 * - Delegate the generation/lookup of shortened URLs to the `Usecase`.
 *
 * Implementation notes:
 * - Current implementation uses DI to instantiate mappers and use-case
 * directly.
 *
 * - Input validation and error handling not implemented yet. Should be
 * centralized (e.g., via '@Validated' and a '@RestControllerAdvice').
 */
@RestController
@RequiredArgsConstructor
public class Controller {
    public final RequestMapper requestMapper;
    public final Usecase usecase;
    public final ResponseMapper responseMapper;

    @GetMapping("/")
    /**
     * Placeholder/example GET endpoint.
     *
     * @param param simple query parameter (implementation currently returns an
     *              empty string).
     * @return an empty string (method is a placeholder; consider removing or
     *         implementing).
     */
    public String returnShortUrl(@RequestParam String param) {
        return new String();
    }

    @PostMapping("/urlShortner")
    /**
     * Create or retrieve a shortened URL for the provided request body.
     *
     * Processing:
     * 1. Maps {@code UrlShortnerRequestBody} to the original URL.
     * 2. Calls {@code Usecase.generateShortUrl(originalUrl)} and returns a DTO
     * response.
     *
     * Notes:
     * - This method is synchronous and relies on the injected use case to be
     * thread-safe.
     * - Validation (e.g., @Valid) and consistent error responses should be added.
     *
     * @param requestBody DTO containing original URL to shorten (expected JSON).
     * @return {@link UrlShortnerResponseBody} containing the shortened URL.
     */
    public UrlShortnerResponseBody generateShortUrl(@RequestBody UrlShortnerRequestBody requestBody) {
        String shortUrl = usecase.generateShortUrl(requestMapper.mapToOriginalUrl(requestBody));
        UrlShortnerResponseBody response = responseMapper.mapFromShortenedUrl(shortUrl);
        return response;
    }

}
