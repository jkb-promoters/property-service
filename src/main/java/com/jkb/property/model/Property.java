package com.jkb.property.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "properties")
public class Property {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Column(nullable = false)
    private String title;

    @Column(columnDefinition = "TEXT")
    private String description;

    @NotBlank
    @Column(nullable = false)
    private String propertyType;

    @NotBlank
    @Column(nullable = false)
    private String listingType;

    @NotNull
    @Column(nullable = false, precision = 15, scale = 2)
    private BigDecimal priceInr;

    @Column(precision = 10, scale = 2)
    private BigDecimal pricePerSqft;

    @NotNull
    @Column(nullable = false)
    private Integer areaSqft;

    @Column
    private Integer plotAreaSqft;

    @Column
    private Integer bedrooms;

    @Column
    private Integer bathrooms;

    @Column
    private Integer balconies;

    @Column
    private Integer floors;

    @Column
    private Integer floorNumber;

    @NotBlank
    @Column(nullable = false)
    private String locality;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String address;

    @Column(nullable = false)
    private String pinCode;

    @NotBlank
    @Column(nullable = false)
    private String status;

    @Column(nullable = false)
    private String facing;

    @Column
    private String parking;

    @Column
    private String furnishing;

    @Column
    private Integer age;

    @Column(columnDefinition = "TEXT")
    private String amenities;

    @Column
    private LocalDate postedDate;

    @Column
    private Boolean rera;

    @Column
    private String reraNumber;

    @Column
    private String nearbyLandmarks;

    @Column
    private String imageUrl;

    // Foreign key only — no @ManyToOne join across service boundary
    @Column(nullable = false)
    private Long promoterId;

    public Property() {}

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
    public Long getPromoterId() { return promoterId; }

    public void setId(Long id) { this.id = id; }
    public void setTitle(String title) { this.title = title; }
    public void setDescription(String description) { this.description = description; }
    public void setPropertyType(String propertyType) { this.propertyType = propertyType; }
    public void setListingType(String listingType) { this.listingType = listingType; }
    public void setPriceInr(BigDecimal priceInr) { this.priceInr = priceInr; }
    public void setPricePerSqft(BigDecimal pricePerSqft) { this.pricePerSqft = pricePerSqft; }
    public void setAreaSqft(Integer areaSqft) { this.areaSqft = areaSqft; }
    public void setPlotAreaSqft(Integer plotAreaSqft) { this.plotAreaSqft = plotAreaSqft; }
    public void setBedrooms(Integer bedrooms) { this.bedrooms = bedrooms; }
    public void setBathrooms(Integer bathrooms) { this.bathrooms = bathrooms; }
    public void setBalconies(Integer balconies) { this.balconies = balconies; }
    public void setFloors(Integer floors) { this.floors = floors; }
    public void setFloorNumber(Integer floorNumber) { this.floorNumber = floorNumber; }
    public void setLocality(String locality) { this.locality = locality; }
    public void setAddress(String address) { this.address = address; }
    public void setPinCode(String pinCode) { this.pinCode = pinCode; }
    public void setStatus(String status) { this.status = status; }
    public void setFacing(String facing) { this.facing = facing; }
    public void setParking(String parking) { this.parking = parking; }
    public void setFurnishing(String furnishing) { this.furnishing = furnishing; }
    public void setAge(Integer age) { this.age = age; }
    public void setAmenities(String amenities) { this.amenities = amenities; }
    public void setPostedDate(LocalDate postedDate) { this.postedDate = postedDate; }
    public void setRera(Boolean rera) { this.rera = rera; }
    public void setReraNumber(String reraNumber) { this.reraNumber = reraNumber; }
    public void setNearbyLandmarks(String nearbyLandmarks) { this.nearbyLandmarks = nearbyLandmarks; }
    public void setImageUrl(String imageUrl) { this.imageUrl = imageUrl; }
    public void setPromoterId(Long promoterId) { this.promoterId = promoterId; }
}
