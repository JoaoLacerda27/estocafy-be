package com.main.estocafy.application.StorageLocation.controller;

import com.main.estocafy.application.StorageLocation.controller.documentation.StorageLocationDoc;
import com.main.estocafy.application.StorageLocation.controller.request.StorageLocationRequest;
import com.main.estocafy.application.StorageLocation.controller.response.StorageLocationResponse;
import com.main.estocafy.application.StorageLocation.dto.StorageLocationDTO;
import com.main.estocafy.application.StorageLocation.service.StorageLocationService;
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
@RequestMapping(path = "/v1/storage-location")
public class StorageLocationController implements StorageLocationDoc {

    private final StorageLocationService service;
    private final ModelMapper mapper;

    @PreAuthorize("hasAnyRole('ADMIN', 'USER')")
    @PostMapping
    public ResponseEntity<StorageLocationResponse> create(StorageLocationRequest request) {
        StorageLocationDTO storageLocationCreated = service.create(mapper.map(request, StorageLocationDTO.class));
        return ResponseEntity.status(HttpStatus.CREATED).body(mapper.map(storageLocationCreated, StorageLocationResponse.class));

    }


    @PreAuthorize("hasAnyRole('ADMIN', 'USER')")
    @PutMapping("/{id}")
    public ResponseEntity<StorageLocationResponse> update(@PathVariable UUID id,
                                                          @RequestBody StorageLocationRequest request) {
        StorageLocationDTO dto = service.update(id, mapper.map(request, StorageLocationDTO.class));
        return ResponseEntity.ok(mapper.map(dto, StorageLocationResponse.class));
    }

    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable UUID id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PreAuthorize("hasAnyRole('ADMIN', 'USER')")
    @GetMapping
    public ResponseEntity<List<StorageLocationResponse>> getAll() {
        List<StorageLocationResponse> responses = service.getAll().stream()
                .map(dto -> mapper.map(dto, StorageLocationResponse.class))
                .collect(Collectors.toList());
        return ResponseEntity.ok(responses);
    }

    @PreAuthorize("hasAnyRole('ADMIN', 'USER')")
    @GetMapping("/{id}")
    public ResponseEntity<StorageLocationResponse> getById(@PathVariable UUID id) {
        StorageLocationDTO dto = service.getById(id);
        return ResponseEntity.ok(mapper.map(dto, StorageLocationResponse.class));
    }
}

