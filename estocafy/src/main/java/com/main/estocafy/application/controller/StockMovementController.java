package com.main.estocafy.application.controller;

import com.main.estocafy.application.controller.documentation.StockMovementDoc;
import com.main.estocafy.application.controller.request.StockMovementRequest;
import com.main.estocafy.application.controller.response.StockMovementResponse;
import com.main.estocafy.application.dto.StockMovementDTO;
import com.main.estocafy.application.service.StockMovementService;
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
@RequestMapping(path = "/v1/stock-movement")
public class StockMovementController implements StockMovementDoc {
    private final StockMovementService service;
    private final ModelMapper mapper;

    @PreAuthorize("hasAnyRole('ADMIN', 'USER')")
    @PostMapping
    public ResponseEntity<StockMovementResponse> create(@RequestBody StockMovementRequest request) {
        StockMovementDTO created = service.create(mapper.map(request, StockMovementDTO.class));
        return ResponseEntity.status(HttpStatus.CREATED).body(mapper.map(created, StockMovementResponse.class));
    }

    @PreAuthorize("hasAnyRole('ADMIN', 'USER')")
    @PutMapping("/{id}")
    public ResponseEntity<StockMovementResponse> update(@PathVariable UUID id, @RequestBody StockMovementRequest request) {
        StockMovementDTO dto = mapper.map(request, StockMovementDTO.class);
        StockMovementDTO updated = service.update(id, dto);
        return ResponseEntity.ok(mapper.map(updated, StockMovementResponse.class));
    }

    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable UUID id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PreAuthorize("hasAnyRole('ADMIN', 'USER')")
    @GetMapping
    public ResponseEntity<List<StockMovementResponse>> getAll() {
        List<StockMovementResponse> list = service.getAll().stream()
                .map(dto -> mapper.map(dto, StockMovementResponse.class))
                .collect(Collectors.toList());
        return ResponseEntity.ok(list);
    }

    @PreAuthorize("hasAnyRole('ADMIN', 'USER')")
    @GetMapping("/{id}")
    public ResponseEntity<StockMovementResponse> getById(@PathVariable UUID id) {
        StockMovementDTO dto = service.getById(id);
        return ResponseEntity.ok(mapper.map(dto, StockMovementResponse.class));
    }
}
