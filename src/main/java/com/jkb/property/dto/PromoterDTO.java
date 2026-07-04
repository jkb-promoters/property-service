package com.jkb.property.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Mirrors the Promoter fields returned by promoter-service.
 * @JsonIgnoreProperties(ignoreUnknown = true) — tolerates extra fields.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class PromoterDTO {
    private Long id;
    private String name;
    private String phone;
    private String whatsapp;
    private String email;
    private String locality;
    private String licenseNumber;
    private String officeAddress;
    private String city;
    private String pinCode;
    private String bio;
    private String experience;
    private String specialization;
    private Integer totalListings;

    public PromoterDTO() {}

    public Long getId() { return id; }
    public String getName() { return name; }
    public String getPhone() { return phone; }
    public String getWhatsapp() { return whatsapp; }
    public String getEmail() { return email; }
    public String getLocality() { return locality; }
    public String getLicenseNumber() { return licenseNumber; }
    public String getOfficeAddress() { return officeAddress; }
    public String getCity() { return city; }
    public String getPinCode() { return pinCode; }
    public String getBio() { return bio; }
    public String getExperience() { return experience; }
    public String getSpecialization() { return specialization; }
    public Integer getTotalListings() { return totalListings; }

    public void setId(Long id) { this.id = id; }
    public void setName(String name) { this.name = name; }
    public void setPhone(String phone) { this.phone = phone; }
    public void setWhatsapp(String whatsapp) { this.whatsapp = whatsapp; }
    public void setEmail(String email) { this.email = email; }
    public void setLocality(String locality) { this.locality = locality; }
    public void setLicenseNumber(String licenseNumber) { this.licenseNumber = licenseNumber; }
    public void setOfficeAddress(String officeAddress) { this.officeAddress = officeAddress; }
    public void setCity(String city) { this.city = city; }
    public void setPinCode(String pinCode) { this.pinCode = pinCode; }
    public void setBio(String bio) { this.bio = bio; }
    public void setExperience(String experience) { this.experience = experience; }
    public void setSpecialization(String specialization) { this.specialization = specialization; }
    public void setTotalListings(Integer totalListings) { this.totalListings = totalListings; }
}
