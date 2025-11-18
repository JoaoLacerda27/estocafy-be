package com.main.estocafy.application.ProductStock.repository.customs;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.stereotype.Repository;

import com.main.estocafy.application.Branch.model.Branch;
import com.main.estocafy.application.Product.model.Product;
import com.main.estocafy.application.ProductStock.model.ProductStock;
import com.main.estocafy.application.StorageLocation.model.StorageLocation;
import com.main.estocafy.application.ProductStock.repository.interfaces.ProductStockRepositoryCustom;
import com.querydsl.jpa.impl.JPAQueryFactory;

import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;

import static com.main.estocafy.application.ProductStock.model.QProductStock.productStock;
import static com.main.estocafy.application.Branch.model.QBranch.branch;


@Repository
@RequiredArgsConstructor
public class ProductStockRepositoryCustomImpl implements ProductStockRepositoryCustom {
    private final EntityManager entityManager;

    @Override
    public Optional<ProductStock> findByProductAndBranchAndStorageLocation(Product product, Branch branch, StorageLocation storage) {
        JPAQueryFactory query = new JPAQueryFactory(entityManager);

        ProductStock ps = query.selectFrom(productStock)
                .where(productStock.product.eq(product)
                        .and(productStock.branch.eq(branch))
                        .and(productStock.storageLocation.eq(storage)))
                .fetchFirst();

        return Optional.ofNullable(ps);
    }

    @Override
    public List<ProductStock> findAllByTenant(String tenantId) {
        return new JPAQueryFactory(entityManager)
                .selectFrom(productStock)
                .join(productStock.branch, branch)
                .where(branch.tenant.id.eq(UUID.fromString(tenantId)))
                .fetch();
    }
}

