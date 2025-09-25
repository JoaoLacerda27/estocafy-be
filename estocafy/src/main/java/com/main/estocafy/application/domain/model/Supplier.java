package com.main.estocafy.application.domain.model;

import java.util.UUID;

import org.hibernate.annotations.GenericGenerator;

import com.main.estocafy.shared.model.ModelBase;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
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
@Table(name = "suppliers",
        uniqueConstraints = {
                @UniqueConstraint(name = "UC_SUPPLIER__DOCUMENT", columnNames = "document"),
                @UniqueConstraint(name = "UC_SUPPLIER__EMAIL", columnNames = "email")
        })
public class Supplier extends ModelBase {
    @Id
    @Column(columnDefinition = "uuid", updatable = false, nullable = false)
    @GeneratedValue(generator = "uuid2", strategy = GenerationType.AUTO)
    @GenericGenerator(name = "uuid2")
    @NotNull
    protected UUID id;

    @NotBlank
    @Size(max = 200)
    @Column(nullable = false)
    private String name;

    @Column
    private String phone;

    @Column(unique = true)
    private String email;

    @Column(unique = true)
    private String document;

    @Column
    private String address;
}
