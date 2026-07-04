package com.jkb.property.dto;

import com.jkb.property.model.Property;

import java.math.BigDecimal;
import java.time.LocalDate;

/**
 * Response DTO that embeds the full PromoterDTO so the frontend sees
 * property.promoter.name, property.promoter.phone, etc. — same contract
 * as the monolith.
 */
public class PropertyResponseDTO {

    private Long id;
    private String title;
    private String description;
    private String propertyType;
    private String listingType;
    private BigDecimal priceInr;
    private BigDecimal pricePerSqft;
    private Integer areaSqft;
    private Integer plotAreaSqft;
    private Integer bedrooms;
    private Integer bathrooms;
    private Integer balconies;
    private Integer floors;
    private Integer floorNumber;
    private String locality;
    private String address;
    private String pinCode;
    private String status;
    private String facing;
    private String parking;
    private String furnishing;
    private Integer age;
    private String amenities;
    private LocalDate postedDate;
    private Boolean rera;
    private String reraNumber;
    private String nearbyLandmarks;
    private String imageUrl;
    private PromoterDTO promoter;  // nested — critical for frontend

    public PropertyResponseDTO() {}

    public static PropertyResponseDTO from(Property p, PromoterDTO promoter) {
        PropertyResponseDTO dto = new PropertyResponseDTO();
        dto.id = p.getId();
        dto.title = p.getTitle();
        dto.description = p.getDescription();
        dto.propertyType = p.getPropertyType();
        dto.listingType = p.getListingType();
        dto.priceInr = p.getPriceInr();
        dto.pricePerSqft = p.getPricePerSqft();
        dto.areaSqft = p.getAreaSqft();
        dto.plotAreaSqft = p.getPlotAreaSqft();
        dto.bedrooms = p.getBedrooms();
        dto.bathrooms = p.getBathrooms();
        dto.balconies = p.getBalconies();
        dto.floors = p.getFloors();
        dto.floorNumber = p.getFloorNumber();
        dto.locality = p.getLocality();
        dto.address = p.getAddress();
        dto.pinCode = p.getPinCode();
        dto.status = p.getStatus();
        dto.facing = p.getFacing();
        dto.parking = p.getParking();
        dto.furnishing = p.getFurnishing();
        dto.age = p.getAge();
        dto.amenities = p.getAmenities();
        dto.postedDate = p.getPostedDate();
        dto.rera = p.getRera();
        dto.reraNumber = p.getReraNumber();
        dto.nearbyLandmarks = p.getNearbyLandmarks();
        dto.imageUrl = p.getImageUrl();
        dto.promoter = promoter;
        return dto;
    }

    public Long getId() { return id; }
    public String getTitle() { return title; }
    public String getDescription() { return description; }
    public String getPropertyType() { return propertyType; }
    public String getListingType() { return listingType; }
    public BigDecimal getPriceInr() { return priceInr; }
    public BigDecimal getPricePerSqft() { return pricePerSqft; }
    public Integer getAreaSqft() { return areaSqft; }
    public Integer getPlotAreaSqft() { return plotAreaSqft; }
    public Integer getBedrooms() { return bedrooms; }
    public Integer getBathrooms() { return bathrooms; }
    public Integer getBalconies() { return balconies; }
    public Integer getFloors() { return floors; }
    public Integer getFloorNumber() { return floorNumber; }
    public String getLocality() { return locality; }
    public String getAddress() { return address; }
    public String getPinCode() { return pinCode; }
    public String getStatus() { return status; }
    public String getFacing() { return facing; }
    public String getParking() { return parking; }
    public String getFurnishing() { return furnishing; }
    public Integer getAge() { return age; }
    public String getAmenities() { return amenities; }
    public LocalDate getPostedDate() { return postedDate; }
    public Boolean getRera() { return rera; }
    public String getReraNumber() { return reraNumber; }
    public String getNearbyLandmarks() { return nearbyLandmarks; }
    public String getImageUrl() { return imageUrl; }
    public PromoterDTO getPromoter() { return promoter; }
}
