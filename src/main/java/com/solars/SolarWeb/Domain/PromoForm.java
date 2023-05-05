package com.solars.SolarWeb.Domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class PromoForm {
    @jakarta.persistence.Id
    @GeneratedValue
    @Column(name = "id", nullable = false)
    Long id;

    String promotionName;
    String details;
}
