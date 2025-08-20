package com.main.estocafy.application.controller.documentation;

import com.main.estocafy.application.controller.request.StorageLocationRequest;
import com.main.estocafy.application.controller.response.StorageLocationResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.UUID;

@Tag(name = "Storage Location", description = "API para controle da localização e armazenamento")
public interface StorageLocationDoc {
    @Operation(summary = "Cria uma nova localização de armazenamento")
    ResponseEntity<StorageLocationResponse> create(StorageLocationRequest request);

    @Operation(summary = "Atualiza uma localização de armazenamento")
    ResponseEntity<StorageLocationResponse> update(UUID id, StorageLocationRequest request);

    @Operation(summary = "Deleta uma localização de armazenamento")
    ResponseEntity<Void> delete(UUID id);

    @Operation(summary = "Busca todas as localizações de armazenamento")
    ResponseEntity<List<StorageLocationResponse>> getAll();

    @Operation(summary = "Busca uma localização de armazenamento baseado no ID")
    ResponseEntity<StorageLocationResponse> getById(UUID id);
}
