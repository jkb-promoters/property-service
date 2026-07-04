package com.jkb.property.service;

import com.jkb.property.client.PromoterClient;
import com.jkb.property.dto.PromoterDTO;
import com.jkb.property.dto.PropertyResponseDTO;
import com.jkb.property.model.Property;
import com.jkb.property.repository.PropertyRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PropertyService {

    private final PropertyRepository repo;
    private final PromoterClient promoterClient;

    public PropertyService(PropertyRepository repo, PromoterClient promoterClient) {
        this.repo = repo;
        this.promoterClient = promoterClient;
    }

    // ── Enrich a single property with its promoter ──────────────────────────
    private PropertyResponseDTO enrich(Property p) {
        PromoterDTO promoter = null;
        try {
            promoter = promoterClient.getById(p.getPromoterId());
        } catch (Exception ignored) {}
        return PropertyResponseDTO.from(p, promoter);
    }

    private List<PropertyResponseDTO> enrichAll(List<Property> list) {
        return list.stream().map(this::enrich).collect(Collectors.toList());
    }

    // ── Queries ─────────────────────────────────────────────────────────────
    public List<PropertyResponseDTO> getAll(String sortBy) {
        List<Property> list = switch (sortBy == null ? "locality" : sortBy.toLowerCase()) {
            case "price_asc"  -> repo.findAllByOrderByPriceInrAsc();
            case "price_desc" -> repo.findAllByOrderByPriceInrDesc();
            case "area"       -> repo.findAllByOrderByAreaSqftDesc();
            default           -> repo.findAllByOrderByLocalityAsc();
        };
        return enrichAll(list);
    }

    public Optional<PropertyResponseDTO> getById(Long id) {
        return repo.findById(id).map(this::enrich);
    }

    public List<PropertyResponseDTO> getByLocality(String locality) {
        return enrichAll(repo.findByLocalityIgnoreCaseOrderByLocalityAsc(locality));
    }

    public List<PropertyResponseDTO> getByPromoter(Long promoterId) {
        return enrichAll(repo.findByPromoterIdOrderByLocalityAsc(promoterId));
    }

    public List<PropertyResponseDTO> getByType(String type) {
        return enrichAll(repo.findByPropertyTypeIgnoreCaseOrderByLocalityAsc(type));
    }

    public List<String> getLocalities() { return repo.findDistinctLocalities(); }
    public List<String> getTypes()      { return repo.findDistinctPropertyTypes(); }

    // ── Mutations ────────────────────────────────────────────────────────────
    public PropertyResponseDTO create(Property property, Long promoterId) {
        if (!promoterClient.exists(promoterId)) {
            throw new IllegalArgumentException("Promoter not found with id: " + promoterId);
        }
        property.setPromoterId(promoterId);
        if (property.getPostedDate() == null) {
            property.setPostedDate(LocalDate.now());
        }
        Property saved = repo.save(property);
        promoterClient.incrementListings(promoterId);
        return enrich(saved);
    }

    public PropertyResponseDTO update(Long id, Property updated, Long promoterId) {
        return repo.findById(id).map(existing -> {
            if (!promoterClient.exists(promoterId)) {
                throw new IllegalArgumentException("Promoter not found: " + promoterId);
            }
            existing.setTitle(updated.getTitle());
            existing.setDescription(updated.getDescription());
            existing.setPropertyType(updated.getPropertyType());
            existing.setListingType(updated.getListingType());
            existing.setPriceInr(updated.getPriceInr());
            existing.setPricePerSqft(updated.getPricePerSqft());
            existing.setAreaSqft(updated.getAreaSqft());
            existing.setPlotAreaSqft(updated.getPlotAreaSqft());
            existing.setBedrooms(updated.getBedrooms());
            existing.setBathrooms(updated.getBathrooms());
            existing.setBalconies(updated.getBalconies());
            existing.setFloors(updated.getFloors());
            existing.setFloorNumber(updated.getFloorNumber());
            existing.setLocality(updated.getLocality());
            existing.setAddress(updated.getAddress());
            existing.setPinCode(updated.getPinCode());
            existing.setStatus(updated.getStatus());
            existing.setFacing(updated.getFacing());
            existing.setParking(updated.getParking());
            existing.setFurnishing(updated.getFurnishing());
            existing.setAge(updated.getAge());
            existing.setAmenities(updated.getAmenities());
            existing.setRera(updated.getRera());
            existing.setReraNumber(updated.getReraNumber());
            existing.setNearbyLandmarks(updated.getNearbyLandmarks());
            existing.setImageUrl(updated.getImageUrl());
            existing.setPromoterId(promoterId);
            return enrich(repo.save(existing));
        }).orElseThrow(() -> new IllegalArgumentException("Property not found: " + id));
    }
}
