package com.main.estocafy.application.domain.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;

import java.time.Instant;
import java.util.UUID;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "products")
public class Product {
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
    private String name;

    @NotBlank
    @Size(max = 120)
    @Column(nullable = false)
    private String skuCode;

    @NotBlank
    @Size(max = 150)
    @Column(nullable = false)
    private String barcode;
}
