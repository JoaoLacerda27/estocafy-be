package com.main.estocafy.application.ProductStock.repository.interfaces;

import java.util.List;
import java.util.Optional;

import com.main.estocafy.application.Branch.model.Branch;
import com.main.estocafy.application.Product.model.Product;
import com.main.estocafy.application.ProductStock.model.ProductStock;
import com.main.estocafy.application.StorageLocation.model.StorageLocation;

public interface ProductStockRepositoryCustom {
    Optional<ProductStock> findByProductAndBranchAndStorageLocation(Product product, Branch branch, StorageLocation storage);
    List<ProductStock> findAllByTenant(String tenantId);
}

