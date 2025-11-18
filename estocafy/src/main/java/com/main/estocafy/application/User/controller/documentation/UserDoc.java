package com.main.estocafy.application.User.controller.documentation;

import com.main.estocafy.application.User.controller.request.UserRequest;
import com.main.estocafy.application.User.controller.response.UserResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.UUID;

@Tag(name = "Users", description = "API para controle de usuários")
public interface UserDoc {
    @Operation(summary = "Cria um novo usuário")
    ResponseEntity<UserResponse> create(UserRequest request);

    @Operation(summary = "Atualiza um usuário")
    ResponseEntity<UserResponse> update(UUID id, UserRequest request);

    @Operation(summary = "Deleta um usuário")
    ResponseEntity<Void> delete(UUID id);

    @Operation(summary = "Busca todos os usuários")
    ResponseEntity<List<UserResponse>> getAll();

    @Operation(summary = "Busca um usuário baseado no ID")
    ResponseEntity<UserResponse> getById(UUID id);
}

