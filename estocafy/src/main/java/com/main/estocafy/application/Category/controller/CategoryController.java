package com.main.estocafy.application.Category.controller;

import com.main.estocafy.application.Category.controller.documentation.CategoryDoc;
import com.main.estocafy.application.Category.controller.request.CategoryRequest;
import com.main.estocafy.application.Category.controller.response.CategoryResponse;
import com.main.estocafy.application.Category.dto.CategoryDTO;
import com.main.estocafy.application.Category.service.CategoryService;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/v1/category")
public class CategoryController implements CategoryDoc {
    private final CategoryService service;
    private final ModelMapper mapper;

    @PreAuthorize("hasAnyRole('ADMIN', 'USER')")
    @PostMapping
    public ResponseEntity<CategoryResponse> create(@RequestBody CategoryRequest request) {
        CategoryDTO created = service.create(mapper.map(request, CategoryDTO.class));
        return ResponseEntity.status(HttpStatus.CREATED).body(mapper.map(created, CategoryResponse.class));
    }

    @PreAuthorize("hasAnyRole('ADMIN', 'USER')")
    @PutMapping("/{id}")
    public ResponseEntity<CategoryResponse> update(@PathVariable UUID id, @RequestBody CategoryRequest request) {
        CategoryDTO dto = mapper.map(request, CategoryDTO.class);
        CategoryDTO updated = service.update(id, dto);
        return ResponseEntity.ok(mapper.map(updated, CategoryResponse.class));
    }

    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable UUID id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PreAuthorize("hasAnyRole('ADMIN', 'USER')")
    @GetMapping
    public ResponseEntity<List<CategoryResponse>> getAll() {
        List<CategoryResponse> list = service.getAll().stream()
                .map(dto -> mapper.map(dto, CategoryResponse.class))
                .collect(Collectors.toList());
        return ResponseEntity.ok(list);
    }

    @PreAuthorize("hasAnyRole('ADMIN', 'USER')")
    @GetMapping("/{id}")
    public ResponseEntity<CategoryResponse> getById(@PathVariable UUID id) {
        CategoryDTO dto = service.getById(id);
        return ResponseEntity.ok(mapper.map(dto, CategoryResponse.class));
    }
}

