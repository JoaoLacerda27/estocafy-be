package com.main.estocafy.application.controller.documentation;

import com.main.estocafy.application.controller.request.CategoryRequest;
import com.main.estocafy.application.controller.response.CategoryResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.UUID;

@Tag(name = "Category", description = "API para controle de categorias")
public interface CategoryDoc {
    @Operation(summary = "Cria uma nova categoria")
    ResponseEntity<CategoryResponse> create(CategoryRequest request);

    @Operation(summary = "Atualiza uma categoria")
    ResponseEntity<CategoryResponse> update(UUID id, CategoryRequest request);

    @Operation(summary = "Deleta uma categoria")
    ResponseEntity<Void> delete(UUID id);

    @Operation(summary = "Busca todas as categorias")
    ResponseEntity<List<CategoryResponse>> getAll();

    @Operation(summary = "Busca uma categoria baseado no ID")
    ResponseEntity<CategoryResponse> getById(UUID id);
}

