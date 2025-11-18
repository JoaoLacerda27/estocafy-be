package com.main.estocafy.application.ProductStock.controller;

import com.main.estocafy.application.ProductStock.controller.documentation.ProductStockDoc;
import com.main.estocafy.application.ProductStock.controller.request.ProductStockRequest;
import com.main.estocafy.application.ProductStock.controller.response.ProductStockResponse;
import com.main.estocafy.application.ProductStock.dto.ProductStockDTO;
import com.main.estocafy.application.ProductStock.service.ProductStockService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/v1/product-stock")
public class ProductStockController implements ProductStockDoc {
    private final ProductStockService service;
    private final ModelMapper mapper;

    @PreAuthorize("hasAnyRole('ADMIN', 'USER')")
    @PostMapping
    public ResponseEntity<ProductStockResponse> create(ProductStockRequest request) {
        ProductStockDTO created = mapper.map(request, ProductStockDTO.class);
        return ResponseEntity.status(HttpStatus.CREATED).body(mapper.map(created, ProductStockResponse.class));
    }

    @PreAuthorize("hasAnyRole('ADMIN', 'USER')")
    @PostMapping("/{id}")
    public ResponseEntity<ProductStockResponse> update(@PathVariable UUID id, ProductStockRequest request) {
        ProductStockDTO updated = mapper.map(request, ProductStockDTO.class);
        ProductStockDTO productStockDTO = service.update(id, updated);
        return ResponseEntity.status(HttpStatus.OK).body(mapper.map(productStockDTO, ProductStockResponse.class));
    }

    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable UUID id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PreAuthorize("hasAnyRole('ADMIN', 'USER')")
    @GetMapping
    public ResponseEntity<List<ProductStockResponse>> getAll() {
        List<ProductStockResponse> list = service.getAll()
                .stream()
                .map(productStock -> mapper.map(productStock, ProductStockResponse.class))
                .toList();

        return ResponseEntity.status(HttpStatus.OK).body(list);
    }

    @PreAuthorize("hasAnyRole('ADMIN', 'USER')")
    @GetMapping("/{id}")
    public ResponseEntity<ProductStockResponse> getById(@PathVariable UUID id) {
        ProductStockDTO dto = service.getById(id);
        return ResponseEntity.status(HttpStatus.OK).body(mapper.map(dto, ProductStockResponse.class));
    }
}

