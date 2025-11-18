package com.main.estocafy.application.Supplier.controller.documentation;

import com.main.estocafy.application.Supplier.controller.request.SupplierRequest;
import com.main.estocafy.application.Supplier.controller.response.SupplierResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.UUID;

@Tag(name = "Supplier", description = "API para controle de fornecedores")
public interface SupplierDoc {
    @Operation(summary = "Cria um novo fornecedor")
    ResponseEntity<SupplierResponse> create(SupplierRequest request);

    @Operation(summary = "Atualiza um fornecedor")
    ResponseEntity<SupplierResponse> update(UUID id, SupplierRequest request);

    @Operation(summary = "Deleta um fornecedor")
    ResponseEntity<Void> delete(UUID id);

    @Operation(summary = "Busca todos os fornecedores")
    ResponseEntity<List<SupplierResponse>> getAll();

    @Operation(summary = "Busca um fornecedor baseado no ID")
    ResponseEntity<SupplierResponse> getById(UUID id);
}

