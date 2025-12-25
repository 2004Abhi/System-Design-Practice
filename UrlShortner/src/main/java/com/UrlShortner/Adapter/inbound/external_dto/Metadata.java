package com.UrlShortner.Adapter.inbound.external_dto;

import lombok.Getter;
import lombok.Setter;

/*
 * Metadata class for storing key-value pairs
 * 
 * Purpose:
 * This is used to store additional information about the URL being shortened.
 * May be used for future extensions like tracking, categorization, etc.
 */

@Getter
@Setter
public class Metadata {
    private String key;
    private String value;
}
