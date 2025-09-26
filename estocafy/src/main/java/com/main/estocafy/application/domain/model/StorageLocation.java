package com.main.estocafy.application.domain.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;

import com.main.estocafy.shared.model.ModelBase;

import java.time.Instant;
import java.util.UUID;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "storage_location",
        uniqueConstraints = {
                @UniqueConstraint(name = "UC_STORAGE_LOCATION__CODE", columnNames = "code")
        })
public class StorageLocation extends ModelBase {
    @Id
    @Column(columnDefinition = "uuid", updatable = false, nullable = false)
    @GeneratedValue(generator = "uuid2", strategy = GenerationType.AUTO)
    @GenericGenerator(name = "uuid2")
    @NotNull
    protected UUID id;

    @NotBlank
    @Size(max = 200)
    @Column(nullable = false, unique = true)
    private String code;

    @Size(max = 200)
    @Column
    private String description;

    @Column
    private Boolean isAvailable = true;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", foreignKey = @ForeignKey(name = "FK_STORAGE_LOCATION__USER_ID"))
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "branch_id", nullable = false)
    private Branch branch;
}
