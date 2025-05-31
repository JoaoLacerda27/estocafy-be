package com.main.estocafy.application.controller;

import com.main.estocafy.application.controller.documentation.UserDoc;
import com.main.estocafy.application.controller.request.UserRequest;
import com.main.estocafy.application.controller.response.UserResponse;
import com.main.estocafy.application.dto.UserDTO;
import com.main.estocafy.application.service.UserService;
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
@RequestMapping(path = "/v1/users")
public class UserController implements UserDoc {

    private final UserService service;
    private final ModelMapper mapper;

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping
    public ResponseEntity<UserResponse> create(@RequestBody UserRequest request) {
        UserDTO userCreated = service.save(mapper.map(request, UserDTO.class));
        return ResponseEntity.status(HttpStatus.CREATED).body(mapper.map(userCreated, UserResponse.class));
    }

    @PreAuthorize("hasAnyRole('ADMIN', 'USER')")
    @PutMapping("/{id}")
    public ResponseEntity<UserResponse> update(@PathVariable UUID id, @RequestBody UserRequest request) {
        UserDTO userUpdated = service.update(id, mapper.map(request, UserDTO.class));
        return ResponseEntity.status(HttpStatus.OK).body(mapper.map(userUpdated, UserResponse.class));
    }

    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable UUID id) {
        service.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @PreAuthorize("hasAnyRole('ADMIN', 'USER')")
    @GetMapping
    public ResponseEntity<List<UserResponse>> getAll() {
        List<UserDTO> users = service.getAll();
        return ResponseEntity.ok(users.stream()
                .map(user -> mapper.map(user, UserResponse.class))
                .collect(Collectors.toList())
        );
    }

    @PreAuthorize("hasAnyRole('ADMIN', 'USER')")
    @GetMapping("/{id}")
    public ResponseEntity<UserResponse> getById(@PathVariable UUID id) {
        UserDTO user = service.getById(id);
        return ResponseEntity.ok(mapper.map(user, UserResponse.class));
    }
}
