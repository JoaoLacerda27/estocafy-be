package com.main.estocafy.application.Product.controller.documentation;

import com.main.estocafy.application.Product.controller.request.ProductRequest;
import com.main.estocafy.application.Product.controller.response.ProductResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.UUID;

@Tag(name = "Product", description = "API para controle de produtods")
public interface ProductDoc {
    @Operation(summary = "Cria um novo produto")
    ResponseEntity<ProductResponse> create(ProductRequest request);

    @Operation(summary = "Atualiza um produto")
    ResponseEntity<ProductResponse> update(UUID id, ProductRequest request);

    @Operation(summary = "Deleta um produto")
    ResponseEntity<Void> delete(UUID id);

    @Operation(summary = "Busca todos os produtos")
    ResponseEntity<List<ProductResponse>> getAll();

    @Operation(summary = "Busca um produto baseado no ID")
    ResponseEntity<ProductResponse> getById(UUID id);
}

