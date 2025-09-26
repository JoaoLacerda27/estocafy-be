package com.main.estocafy.application.service;

import com.main.estocafy.application.dto.SupplierDTO;
import com.main.estocafy.shared.services.ServiceBase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class SupplierService extends ServiceBase {

    // TODO: Implementar métodos do serviço
    public SupplierDTO create(SupplierDTO dto) {
        // TODO: Implementar criação de fornecedor
        return null;
    }

    public SupplierDTO update(UUID id, SupplierDTO dto) {
        // TODO: Implementar atualização de fornecedor
        return null;
    }

    public void delete(UUID id) {
        // TODO: Implementar exclusão de fornecedor
    }

    public List<SupplierDTO> getAll() {
        // TODO: Implementar busca de todos os fornecedores
        return null;
    }

    public SupplierDTO getById(UUID id) {
        // TODO: Implementar busca de fornecedor por ID
        return null;
    }
}

