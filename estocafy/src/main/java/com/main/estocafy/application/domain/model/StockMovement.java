package com.main.estocafy.application.domain.model;

import java.time.Instant;
import java.time.LocalDateTime;
import java.util.UUID;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.Filter;
import org.hibernate.annotations.FilterDef;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.ParamDef;

import com.main.estocafy.application.domain.enums.MovementType;
import com.main.estocafy.shared.model.ModelBase;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FilterDef(name = "tenantFilter", parameters = @ParamDef(name = "tenantId", type = String.class))
@Filter(name = "tenantFilter", condition = "product_stock_id IN (SELECT ps.id FROM products_stock ps JOIN branch b ON ps.branch_id = b.id WHERE b.tenant_id = :tenantId)")
@Table(name = "stock_movements")
public class StockMovement extends ModelBase {

    @Id
    @Column(columnDefinition = "uuid", updatable = false, nullable = false)
    @GeneratedValue(generator = "uuid2", strategy = GenerationType.AUTO)
    @GenericGenerator(name = "uuid2")
    @NotNull
    protected UUID id;
    @Column(nullable = false)
    private LocalDateTime movementDate  = LocalDateTime.now();

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private MovementType type; 

    @NotNull
    @Column(nullable = false)
    private Long quantity;

    @Column
    private Long previousQuantity;

    @Column
    private Long resultingQuantity;

    @Column(length = 500)
    private String reason;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_stock_id", foreignKey = @ForeignKey(name = "FK_MOVEMENT__PRODUCT_STOCK_ID"))
    private ProductStock productStock;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", foreignKey = @ForeignKey(name = "FK_MOVEMENT__USER_ID"))
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "source_branch_id")
    private Branch sourceBranch;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "target_branch_id")
    private Branch targetBranch;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "source_storage_id")
    private StorageLocation sourceStorage;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "target_storage_id")
    private StorageLocation targetStorage;
    
}
