package com.main.estocafy.application.Category.model;

import java.util.UUID;

import org.hibernate.annotations.GenericGenerator;

import com.main.estocafy.shared.model.ModelBase;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
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
@Table(name = "categories",
        uniqueConstraints = {
                @UniqueConstraint(name = "UC_CATEGORY__NAME", columnNames = "name")
        })
public class Category extends ModelBase {

    @Id
    @Column(columnDefinition = "uuid", updatable = false, nullable = false)
    @GeneratedValue(generator = "uuid2", strategy = GenerationType.AUTO)
    @GenericGenerator(name = "uuid2")
    @NotNull
    protected UUID id;

    @NotBlank
    @Size(max = 200)
    @Column(nullable = false, unique = true)
    private String name;

    private String description;
}
