package com.main.estocafy.application.StockMovement.service;

import com.main.estocafy.application.Branch.model.Branch;
import com.main.estocafy.application.ProductStock.model.ProductStock;
import com.main.estocafy.application.StockMovement.model.StockMovement;
import com.main.estocafy.application.StorageLocation.model.StorageLocation;
import com.main.estocafy.application.User.model.User;
import com.main.estocafy.application.StockMovement.dto.StockMovementDTO;
import com.main.estocafy.application.ProductStock.repository.ProductStockRepository;
import com.main.estocafy.application.StockMovement.repository.StockMovementRepository;
import com.main.estocafy.application.User.repository.UserRepository;
import com.main.estocafy.shared.exceptions.types.BusinessException;
import com.main.estocafy.shared.exceptions.types.ResourceNotFoundException;
import com.main.estocafy.shared.services.ServiceBase;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class StockMovementService extends ServiceBase {
    
    private final StockMovementRepository repository;
    private final ProductStockRepository productStockRepository;
    private final UserRepository userRepository;

    public StockMovementDTO create(StockMovementDTO dto) {
        return createMovement(dto);
    }

    public StockMovementDTO update(UUID id, StockMovementDTO dto) {
        // TODO: Implementar atualização
        return null;
    }

    public void delete(UUID id) {
        if (!repository.existsById(id)) {
            throw new ResourceNotFoundException(getMessage("stockMovement.not.found"));
        }
        repository.deleteById(id);
    }

    public List<StockMovementDTO> getAll() {
        return repository.findAll().stream()
                .map(movement -> mapper.map(movement, StockMovementDTO.class))
                .collect(Collectors.toList());
    }

    public StockMovementDTO getById(UUID id) {
        StockMovement movement = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(getMessage("stockMovement.not.found")));
        return mapper.map(movement, StockMovementDTO.class);
    }

    @Transactional
    public StockMovementDTO createMovement(StockMovementDTO dto) {
    
        // Search for source stock
        ProductStock originStock = productStockRepository.findById(dto.getProductStock().getId())
                .orElseThrow(() -> new ResourceNotFoundException(getMessage("productStock.not.found")));
    
        // Block movements of expired products
        if (originStock.getExpirationDate() != null && originStock.getExpirationDate().isBefore(LocalDate.now())) {
            throw new BusinessException(getMessage("productStock.expired"));
        }
    
        if (originStock.getQuantity() == null) {
            originStock.setQuantity(0L);
        }
    
        Long prevQty = originStock.getQuantity();
        Long resultingQty = prevQty;
    
        if (dto.getQuantity() == null || dto.getQuantity() == 0) {
            throw new BusinessException(getMessage("stockMovement.invalidQuantity"));
        }
    
        User user = dto.getUser() != null ? userRepository.findById(dto.getUser().getId()).orElse(null) : null;
    
        // Processing according to type of movement
        switch (dto.getType()) {
    
            case ENTRY -> {
                resultingQty = prevQty + dto.getQuantity();
                originStock.setQuantity(resultingQty);
            }
    
            case EXIT -> {
                if (prevQty < dto.getQuantity()) {
                    throw new BusinessException(getMessage("productStock.quantity.insufficient"));
                }
                resultingQty = prevQty - dto.getQuantity();
                originStock.setQuantity(resultingQty);
            }
    
            case TRANSFER -> {
                if (prevQty < dto.getQuantity()) {
                    throw new BusinessException(getMessage("productStock.quantity.insufficient"));
                }
                resultingQty = prevQty - dto.getQuantity();
                originStock.setQuantity(resultingQty);
    
                // Credit to target stock (create if it does not exist)
                ProductStock destStock = productStockRepository
                        .findByProductAndBranchAndStorageLocation(
                                originStock.getProduct(),
                                mapper.map(dto.getTargetBranch(), Branch.class),
                                mapper.map(dto.getTargetStorage(), StorageLocation.class))
                        .orElseGet(() -> {
                            ProductStock ps = ProductStock.builder()
                                    .product(originStock.getProduct())
                                    .branch(mapper.map(dto.getTargetBranch(), Branch.class))
                                    .storageLocation(mapper.map(dto.getTargetStorage(), StorageLocation.class))
                                    .batchNumber(originStock.getBatchNumber())
                                    .shipmentCode(originStock.getShipmentCode())
                                    .quantity(0L)
                                    .minQuantity(originStock.getMinQuantity())
                                    .reservedQuantity(0)
                                    .userThatAdded(user)
                                    .build();
                            return productStockRepository.save(ps);
                        });
    
                destStock.setQuantity(destStock.getQuantity() + dto.getQuantity());
                productStockRepository.save(destStock);
            }
    
            case ADJUSTMENT -> {
                resultingQty = prevQty + dto.getQuantity();
                if (resultingQty < 0) {
                    throw new BusinessException(getMessage("stockMovement.insufficientAfterAdjustment"));
                }
                originStock.setQuantity(resultingQty);
            }
    
            default -> throw new BusinessException(getMessage("stockMovement.invalidType"));
        }
    
        // Persist source stock changes
        productStockRepository.save(originStock);
    
        // Create movement record
        StockMovement movement = StockMovement.builder()
                .type(dto.getType())
                .quantity(Math.abs(dto.getQuantity()))
                .previousQuantity(prevQty)
                .resultingQuantity(resultingQty)
                .reason(dto.getReason())
                .productStock(originStock)
                .user(user)
                .sourceBranch(originStock.getBranch())
                .sourceStorage(originStock.getStorageLocation())
                .targetBranch(mapper.map(dto.getTargetBranch(), Branch.class))
                .targetStorage(mapper.map(dto.getTargetStorage(), StorageLocation.class))
                .build();
    
        StockMovement saved = repository.save(movement);
    
        // Minimum stock alerts
        if (originStock.getQuantity() <= originStock.getMinQuantity()) {
            // TODO: enviar evento/fila de notificação de estoque mínimo
            // notificationService.sendLowStockAlert(originStock);
        }

        return mapper.map(saved, StockMovementDTO.class);
    }
}

