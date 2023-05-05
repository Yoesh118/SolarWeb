package com.solars.SolarWeb.Domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.data.annotation.Id;

import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Contact {
    @jakarta.persistence.Id
    @GeneratedValue
    @Column(name = "id", nullable = false)
    Long id;

    @Column(name = "created_at")
    @CreationTimestamp
    LocalDateTime createdAt;

    String subject;
    String email;
    String text;
    String phone;

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
