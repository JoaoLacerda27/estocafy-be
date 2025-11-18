package com.main.estocafy.application.ProductStock.service;

import com.main.estocafy.application.Product.model.Product;
import com.main.estocafy.application.ProductStock.model.ProductStock;
import com.main.estocafy.application.StorageLocation.model.StorageLocation;
import com.main.estocafy.application.User.model.User;
import com.main.estocafy.application.ProductStock.dto.ProductStockDTO;
import com.main.estocafy.application.ProductStock.repository.ProductStockRepository;
import com.main.estocafy.shared.exceptions.types.ResourceNotFoundException;
import com.main.estocafy.shared.services.ServiceBase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProductStockService extends ServiceBase {

    private final ProductStockRepository repository;

    public ProductStockDTO save(ProductStockDTO dto) {
        ProductStock productStock = new ProductStock();
        productStock.setBatchNumber(dto.getBatchNumber());
        productStock.setShipmentCode(dto.getShipmentCode());
        productStock.setManufactureDate(dto.getManufactureDate());
        productStock.setExpirationDate(dto.getExpirationDate());
        productStock.setQuantity(dto.getQuantity());
        productStock.setProduct(mapper.map(dto.getProduct(), Product.class));
        //Alterar para pegar get logged user
        productStock.setUserThatAdded(mapper.map(dto.getUserThatAdded(), User.class));
        productStock.setStorageLocation(mapper.map(dto.getStorageLocation(), StorageLocation.class));

        var productStockSaved = repository.save(productStock);
        return mapper.map(productStockSaved, ProductStockDTO.class);
    }

    public ProductStockDTO update(UUID id, ProductStockDTO dto) {

        var productStock = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(getMessage("productStock.not.found")));

        productStock.setBatchNumber(StringUtils.hasText(dto.getBatchNumber()) ? dto.getBatchNumber() : productStock.getBatchNumber());
        productStock.setShipmentCode(StringUtils.hasText(dto.getShipmentCode()) ? dto.getShipmentCode() : productStock.getShipmentCode());
        productStock.setManufactureDate(dto.getManufactureDate() != null ? dto.getManufactureDate() : productStock.getManufactureDate());
        productStock.setExpirationDate(dto.getExpirationDate() != null ? dto.getExpirationDate() : productStock.getExpirationDate());
        productStock.setQuantity(dto.getQuantity() != null ? dto.getQuantity() : productStock.getQuantity());


        if (dto.getProduct() != null) {
            productStock.setProduct(mapper.map(dto.getProduct(), Product.class));
        }

        if (dto.getUserThatAdded() != null) {
            productStock.setUserThatAdded(mapper.map(dto.getUserThatAdded(), User.class));
        }

        if (dto.getStorageLocation() != null) {
            productStock.setStorageLocation(mapper.map(dto.getStorageLocation(), StorageLocation.class));
        }

        return mapper.map(repository.save(productStock), ProductStockDTO.class);
    }

    public void delete(UUID id) {
        if (!repository.existsById(id)) {
            throw new ResourceNotFoundException(getMessage("productStock.not.found"));
        }

        repository.deleteById(id);
    }

    public List<ProductStockDTO> getAll() {
        return repository.findAll().stream()
                .map(productStock -> mapper.map(productStock, ProductStockDTO.class))
                .collect(Collectors.toList());
    }

    public ProductStockDTO getById(UUID id) {
        var productStock = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(getMessage("productStock.not.found")));

        return mapper.map(productStock, ProductStockDTO.class);
    }
}

