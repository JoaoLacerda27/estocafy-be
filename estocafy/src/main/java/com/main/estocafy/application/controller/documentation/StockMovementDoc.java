package com.main.estocafy.application.controller.documentation;

import com.main.estocafy.application.controller.request.StockMovementRequest;
import com.main.estocafy.application.controller.response.StockMovementResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.UUID;

@Tag(name = "StockMovement", description = "API para controle de movimentações de estoque")
public interface StockMovementDoc {
    @Operation(summary = "Cria uma nova movimentação de estoque")
    ResponseEntity<StockMovementResponse> create(StockMovementRequest request);

    @Operation(summary = "Atualiza uma movimentação de estoque")
    ResponseEntity<StockMovementResponse> update(UUID id, StockMovementRequest request);

    @Operation(summary = "Deleta uma movimentação de estoque")
    ResponseEntity<Void> delete(UUID id);

    @Operation(summary = "Busca todas as movimentações de estoque")
    ResponseEntity<List<StockMovementResponse>> getAll();

    @Operation(summary = "Busca uma movimentação de estoque baseado no ID")
    ResponseEntity<StockMovementResponse> getById(UUID id);
}
