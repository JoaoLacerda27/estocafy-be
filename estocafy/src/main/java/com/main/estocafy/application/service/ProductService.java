package com.main.estocafy.application.service;

import com.main.estocafy.application.domain.model.Product;
import com.main.estocafy.application.dto.ProductDTO;
import com.main.estocafy.application.repository.ProductRepository;
import com.main.estocafy.shared.exceptions.types.ResourceNotFoundException;
import com.main.estocafy.shared.services.ServiceBase;
import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProductService extends ServiceBase {

    private final ProductRepository repository;

    public ProductDTO create(ProductDTO dto) {
        var product = Product.builder()
                .name(dto.getName())
                .skuCode(dto.getSkuCode())
                .barcode(dto.getBarcode())
                .build();

        var productSaved = repository.save(product);

        return mapper.map(productSaved, ProductDTO.class);
    }

    public ProductDTO update(UUID id, @NotNull ProductDTO dto) {
        var product = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(getMessage("product.not.found")));

        product.setName(StringUtils.hasText(dto.getName()) ? dto.getName() : product.getName());
        product.setSkuCode(StringUtils.hasText(dto.getSkuCode()) ? dto.getSkuCode() : product.getSkuCode());
        product.setBarcode(StringUtils.hasText(dto.getBarcode()) ? dto.getBarcode() : product.getBarcode());

        return mapper.map(repository.save(product), ProductDTO.class);
    }

    public void delete(UUID id) {
        if (!repository.existsById(id)) {
            throw new ResourceNotFoundException(getMessage("product.not.found"));
        }

        repository.deleteById(id);
    }

    public List<ProductDTO> getAll() {
        return repository.findAll().stream()
                .map(product -> mapper.map(product, ProductDTO.class))
                .collect(Collectors.toList());
    }

    public ProductDTO getById(UUID id) {
        var product = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(getMessage("product.not.found")));

        return mapper.map(product, ProductDTO.class);
    }
}
