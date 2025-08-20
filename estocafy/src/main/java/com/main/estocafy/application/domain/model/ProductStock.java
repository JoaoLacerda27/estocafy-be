package com.main.estocafy.application.domain.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;

import java.time.Instant;
import java.time.LocalDate;
import java.util.UUID;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "products_stock")
public class ProductStock {
    @Id
    @Column(columnDefinition = "uuid", updatable = false, nullable = false)
    @GeneratedValue(generator = "uuid2", strategy = GenerationType.AUTO)
    @GenericGenerator(name = "uuid2")
    @NotNull
    protected UUID id;

    @CreationTimestamp
    @Column
    private Instant createdAt;

    @NotBlank
    @Size(max = 200)
    @Column(nullable = false)
    private String batchNumber;

    @NotBlank
    @Size(max = 200)
    @Column(nullable = false)
    private String shipmentCode;

    @Column
    private LocalDate manufactureDate;

    @Column
    private LocalDate expirationDate;

    @Column
    private Long quantity;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id", foreignKey = @ForeignKey(name = "FK_PRODUCT_STOCK__PRODUCT_ID"))
    private Product product;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_added_id", foreignKey = @ForeignKey(name = "FK_PRODUCT_STOCK__USER_ID"))
    private User userThatAdded;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "storage_location_id", foreignKey = @ForeignKey(name = "FK_PRODUCT_STOCK__STORAGE_LOCATION_ID"))
    private StorageLocation storageLocation;
}
