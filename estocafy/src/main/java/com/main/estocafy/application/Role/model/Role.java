package com.main.estocafy.application.Role.model;

import com.main.estocafy.application.Role.enums.RoleType;
import com.main.estocafy.shared.model.ModelBase;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import java.util.UUID;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "roles",
        uniqueConstraints = {
                @UniqueConstraint(name = "UC_ROLE__NAME", columnNames = "name")
        })
public class Role extends ModelBase {

    @Id
    @Column(columnDefinition = "uuid", updatable = false, nullable = false)
    @GeneratedValue(generator = "uuid2", strategy = GenerationType.AUTO)
    @GenericGenerator(name = "uuid2")
    @NotNull
    protected UUID id;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, unique = true)
    private RoleType name;
}

