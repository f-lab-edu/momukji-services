package kr.flab.momukji.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.Builder;
import lombok.Getter;

@Entity
@Table
@Getter
@Builder
public class Order {
    @Id
    @Column(name = "order_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(targetEntity = User.class, fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @ManyToOne(targetEntity = Store.class, fetch = FetchType.LAZY)
    @JoinColumn(name = "store_id", nullable = false)
    private Store store;

    @Column(name = "status", nullable = false)
    private Long status;

    @Column(name = "is_delivery", nullable = false)
    private Boolean isDelivery;

    @Column(name = "message", length = 100, nullable = false)
    private String message;

    @Column(name = "estimated_minutes", nullable = false)
    private Long estimatedMinutes;

    @CreationTimestamp
    @Column(name = "created_timestamp", nullable = false)
    private LocalDateTime createdTimestamp;

    @Column(name = "accepted_timestamp", nullable = true)
    private LocalDateTime acceptedTimestamp;

    @Column(name = "cooked_timestamp", nullable = true)
    private LocalDateTime cookedTimestamp;

    @Column(name = "pickuped_timestamp", nullable = true)
    private LocalDateTime pickupedTimestamp;

    @Column(name = "completed_timestamp", nullable = true)
    private LocalDateTime completedTimestamp;

    @UpdateTimestamp
    @Column(name = "updated_timestamp", nullable = false)
    private LocalDateTime updatedTimestamp;
}
