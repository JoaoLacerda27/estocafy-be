package com.main.estocafy.application.repository.interfaces;

import java.util.List;
import java.util.Optional;

import com.main.estocafy.application.domain.model.Branch;
import com.main.estocafy.application.domain.model.Product;
import com.main.estocafy.application.domain.model.ProductStock;
import com.main.estocafy.application.domain.model.StorageLocation;

public interface ProductStockRepositoryCustom {
    Optional<ProductStock> findByProductAndBranchAndStorageLocation(Product product, Branch branch, StorageLocation storage);
    List<ProductStock> findAllByTenant(String tenantId);

}
