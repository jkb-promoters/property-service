package com.jkb.property.client;

import com.jkb.property.dto.PromoterDTO;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/**
 * HTTP client that calls promoter-service at localhost:8081.
 */
@Component
public class PromoterClient {

    private final RestTemplate restTemplate;
    private final String baseUrl;

    public PromoterClient(RestTemplate restTemplate,
                          @Value("${promoter.service.url}") String baseUrl) {
        this.restTemplate = restTemplate;
        this.baseUrl = baseUrl;
    }

    public PromoterDTO getById(Long id) {
        return restTemplate.getForObject(baseUrl + "/api/promoters/" + id, PromoterDTO.class);
    }

    public List<PromoterDTO> getAll() {
        ResponseEntity<List<PromoterDTO>> response = restTemplate.exchange(
                baseUrl + "/api/promoters",
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<>() {}
        );
        return response.getBody();
    }

    public boolean exists(Long id) {
        try {
            PromoterDTO p = getById(id);
            return p != null;
        } catch (Exception e) {
            return false;
        }
    }

    public void incrementListings(Long id) {
        try {
            restTemplate.postForObject(
                    baseUrl + "/api/promoters/" + id + "/increment-listings",
                    null,
                    Void.class
            );
        } catch (Exception ignored) {}
    }
}
