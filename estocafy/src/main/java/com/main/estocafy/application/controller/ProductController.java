package com.main.estocafy.application.controller;

import com.main.estocafy.application.controller.documentation.ProductDoc;
import com.main.estocafy.application.controller.request.ProductRequest;
import com.main.estocafy.application.controller.response.ProductResponse;
import com.main.estocafy.application.dto.ProductDTO;
import com.main.estocafy.application.service.ProductService;
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
@RequestMapping(path = "/v1/product")
public class ProductController implements ProductDoc {
    private final ProductService service;
    private final ModelMapper mapper;

    @PreAuthorize("hasAnyRole('ADMIN', 'USER')")
    @PostMapping
    public ResponseEntity<ProductResponse> create(@RequestBody ProductRequest request) {
        ProductDTO created = service.create(mapper.map(request, ProductDTO.class));
        return ResponseEntity.status(HttpStatus.CREATED).body(mapper.map(created, ProductResponse.class));
    }

    @PreAuthorize("hasAnyRole('ADMIN', 'USER')")
    @PutMapping("/{id}")
    public ResponseEntity<ProductResponse> update(@PathVariable UUID id, @RequestBody ProductRequest request) {
        ProductDTO dto = mapper.map(request, ProductDTO.class);
        ProductDTO updated = service.update(id, dto);
        return ResponseEntity.ok(mapper.map(updated, ProductResponse.class));
    }

    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable UUID id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PreAuthorize("hasAnyRole('ADMIN', 'USER')")
    @GetMapping
    public ResponseEntity<List<ProductResponse>> getAll() {
        List<ProductResponse> list = service.getAll().stream()
                .map(dto -> mapper.map(dto, ProductResponse.class))
                .collect(Collectors.toList());
        return ResponseEntity.ok(list);
    }

    @PreAuthorize("hasAnyRole('ADMIN', 'USER')")
    @GetMapping("/{id}")
    public ResponseEntity<ProductResponse> getById(@PathVariable UUID id) {
        ProductDTO dto = service.getById(id);
        return ResponseEntity.ok(mapper.map(dto, ProductResponse.class));
    }
}
