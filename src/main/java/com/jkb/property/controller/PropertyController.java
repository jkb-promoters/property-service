package com.jkb.property.controller;

import com.jkb.property.dto.PropertyResponseDTO;
import com.jkb.property.model.Property;
import com.jkb.property.service.PropertyService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/properties")
public class PropertyController {

    private final PropertyService service;

    public PropertyController(PropertyService service) { this.service = service; }

    @GetMapping
    public ResponseEntity<List<PropertyResponseDTO>> getAll(
            @RequestParam(required = false) String sortBy,
            @RequestParam(required = false) String locality,
            @RequestParam(required = false) Long promoterId,
            @RequestParam(required = false) String type) {

        if (locality != null && !locality.isBlank())
            return ResponseEntity.ok(service.getByLocality(locality));
        if (promoterId != null)
            return ResponseEntity.ok(service.getByPromoter(promoterId));
        if (type != null && !type.isBlank())
            return ResponseEntity.ok(service.getByType(type));
        return ResponseEntity.ok(service.getAll(sortBy));
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable Long id) {
        return service.getById(id)
                .<ResponseEntity<?>>map(ResponseEntity::ok)
                .orElse(ResponseEntity.status(HttpStatus.NOT_FOUND)
                        .body(Map.of("error", "Property not found: " + id)));
    }

    @GetMapping("/localities")
    public ResponseEntity<List<String>> getLocalities() {
        return ResponseEntity.ok(service.getLocalities());
    }

    @GetMapping("/types")
    public ResponseEntity<List<String>> getTypes() {
        return ResponseEntity.ok(service.getTypes());
    }

    @PostMapping
    public ResponseEntity<?> create(
            @Valid @RequestBody Property property,
            @RequestParam Long promoterId) {
        try {
            return ResponseEntity.status(HttpStatus.CREATED).body(service.create(property, promoterId));
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(Map.of("error", e.getMessage()));
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(
            @PathVariable Long id,
            @Valid @RequestBody Property property,
            @RequestParam Long promoterId) {
        try {
            return ResponseEntity.ok(service.update(id, property, promoterId));
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(Map.of("error", e.getMessage()));
        }
    }
}
