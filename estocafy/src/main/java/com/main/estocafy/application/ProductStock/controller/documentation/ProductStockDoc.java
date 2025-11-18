package com.main.estocafy.application.ProductStock.controller.documentation;

import com.main.estocafy.application.ProductStock.controller.request.ProductStockRequest;
import com.main.estocafy.application.ProductStock.controller.response.ProductStockResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.UUID;

@Tag(name = "Product Stock", description = "API para controle de estoque de produtos")
public interface ProductStockDoc {
    @Operation(summary = "Cria um novo estoque de produto")
    ResponseEntity<ProductStockResponse> create(ProductStockRequest request);

    @Operation(summary = "Atualiza um estoque de produto")
    ResponseEntity<ProductStockResponse> update(UUID id, ProductStockRequest request);

    @Operation(summary = "Deleta um estoque de produto")
    ResponseEntity<Void> delete(UUID id);

    @Operation(summary = "Busca todos os estoques de produto")
    ResponseEntity<List<ProductStockResponse>> getAll();

    @Operation(summary = "Busca um estoque de produto baseado no ID")
    ResponseEntity<ProductStockResponse> getById(UUID id);
}

