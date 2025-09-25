package com.main.estocafy.application.service;

import com.main.estocafy.application.dto.StockMovementDTO;
import com.main.estocafy.shared.services.ServiceBase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class StockMovementService extends ServiceBase {

    // TODO: Implementar métodos do serviço
    public StockMovementDTO create(StockMovementDTO dto) {
        // TODO: Implementar criação de movimentação de estoque
        return null;
    }

    public StockMovementDTO update(UUID id, StockMovementDTO dto) {
        // TODO: Implementar atualização de movimentação de estoque
        return null;
    }

    public void delete(UUID id) {
        // TODO: Implementar exclusão de movimentação de estoque
    }

    public List<StockMovementDTO> getAll() {
        // TODO: Implementar busca de todas as movimentações de estoque
        return null;
    }

    public StockMovementDTO getById(UUID id) {
        // TODO: Implementar busca de movimentação de estoque por ID
        return null;
    }
}
