package com.jkb.property.repository;

import com.jkb.property.model.Property;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PropertyRepository extends JpaRepository<Property, Long> {

    List<Property> findAllByOrderByLocalityAsc();
    List<Property> findAllByOrderByPriceInrAsc();
    List<Property> findAllByOrderByPriceInrDesc();
    List<Property> findAllByOrderByAreaSqftDesc();

    List<Property> findByLocalityIgnoreCaseOrderByLocalityAsc(String locality);
    List<Property> findByPropertyTypeIgnoreCaseOrderByLocalityAsc(String type);
    List<Property> findByPromoterIdOrderByLocalityAsc(Long promoterId);

    @Query("SELECT DISTINCT p.locality FROM Property p ORDER BY p.locality ASC")
    List<String> findDistinctLocalities();

    @Query("SELECT DISTINCT p.propertyType FROM Property p ORDER BY p.propertyType ASC")
    List<String> findDistinctPropertyTypes();
}
