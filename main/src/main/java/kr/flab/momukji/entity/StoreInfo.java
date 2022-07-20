package kr.flab.momukji.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class StoreInfo {
    
    @Id
    @Column(name = "info_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "business_president", length = 50, unique = true, nullable = false)
    private String businessPresident;

    @Column(name = "business_name", length = 50, nullable = false)
    private String businessName;

    @Column(name = "business_address", length = 100, nullable = false)
    private String business_address;

    @Column(name = "business_registration_code", length = 50, nullable = false)
    private String businessRegistrationCode;

    @Column(name = "opening_hours", length = 100, nullable = false)
    private String openingHours;

    @Column(name = "description", length = 200, nullable = false)
    private String description;

    @Column(name = "contact", length = 50, nullable = false)
    private String contact;

    @Column(name = "delivery_fee", nullable = false)
    private Long deliveryFee;

    @ColumnDefault("false")
    @Column(name = "deleted", nullable = false)
    private Boolean deleted;

    @CreationTimestamp
    @Column(name = "created_timestamp", nullable = false)
    private LocalDateTime createdTimestamp;

    @UpdateTimestamp
    @Column(name = "updated_timestamp", nullable = false)
    private LocalDateTime updatedTimestamp;
}
