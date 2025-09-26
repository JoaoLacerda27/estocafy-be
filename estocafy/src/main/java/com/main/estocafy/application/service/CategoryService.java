package com.main.estocafy.application.service;

import com.main.estocafy.application.dto.CategoryDTO;
import com.main.estocafy.shared.services.ServiceBase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class CategoryService extends ServiceBase {

    // TODO: Implementar métodos do serviço
    public CategoryDTO create(CategoryDTO dto) {
        // TODO: Implementar criação de categoria
        return null;
    }

    public CategoryDTO update(UUID id, CategoryDTO dto) {
        // TODO: Implementar atualização de categoria
        return null;
    }

    public void delete(UUID id) {
        // TODO: Implementar exclusão de categoria
    }

    public List<CategoryDTO> getAll() {
        // TODO: Implementar busca de todas as categorias
        return null;
    }

    public CategoryDTO getById(UUID id) {
        // TODO: Implementar busca de categoria por ID
        return null;
    }
}

