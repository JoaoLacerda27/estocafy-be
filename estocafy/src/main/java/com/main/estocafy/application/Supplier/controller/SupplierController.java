package com.main.estocafy.application.Supplier.controller;

import com.main.estocafy.application.Supplier.controller.documentation.SupplierDoc;
import com.main.estocafy.application.Supplier.controller.request.SupplierRequest;
import com.main.estocafy.application.Supplier.controller.response.SupplierResponse;
import com.main.estocafy.application.Supplier.dto.SupplierDTO;
import com.main.estocafy.application.Supplier.service.SupplierService;
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
@RequestMapping(path = "/v1/supplier")
public class SupplierController implements SupplierDoc {
    private final SupplierService service;
    private final ModelMapper mapper;

    @PreAuthorize("hasAnyRole('ADMIN', 'USER')")
    @PostMapping
    public ResponseEntity<SupplierResponse> create(@RequestBody SupplierRequest request) {
        SupplierDTO created = service.create(mapper.map(request, SupplierDTO.class));
        return ResponseEntity.status(HttpStatus.CREATED).body(mapper.map(created, SupplierResponse.class));
    }

    @PreAuthorize("hasAnyRole('ADMIN', 'USER')")
    @PutMapping("/{id}")
    public ResponseEntity<SupplierResponse> update(@PathVariable UUID id, @RequestBody SupplierRequest request) {
        SupplierDTO dto = mapper.map(request, SupplierDTO.class);
        SupplierDTO updated = service.update(id, dto);
        return ResponseEntity.ok(mapper.map(updated, SupplierResponse.class));
    }

    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable UUID id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PreAuthorize("hasAnyRole('ADMIN', 'USER')")
    @GetMapping
    public ResponseEntity<List<SupplierResponse>> getAll() {
        List<SupplierResponse> list = service.getAll().stream()
                .map(dto -> mapper.map(dto, SupplierResponse.class))
                .collect(Collectors.toList());
        return ResponseEntity.ok(list);
    }

    @PreAuthorize("hasAnyRole('ADMIN', 'USER')")
    @GetMapping("/{id}")
    public ResponseEntity<SupplierResponse> getById(@PathVariable UUID id) {
        SupplierDTO dto = service.getById(id);
        return ResponseEntity.ok(mapper.map(dto, SupplierResponse.class));
    }
}

