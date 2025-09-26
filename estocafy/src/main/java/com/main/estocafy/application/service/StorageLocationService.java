package com.main.estocafy.application.service;

import com.main.estocafy.application.domain.model.StorageLocation;
import com.main.estocafy.application.domain.model.User;
import com.main.estocafy.application.dto.StorageLocationDTO;
import com.main.estocafy.application.repository.StorageLocationRepository;
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
public class StorageLocationService extends ServiceBase {

    private final StorageLocationRepository repository;

    public StorageLocationDTO create(StorageLocationDTO dto) {
        StorageLocation storage = new StorageLocation();
        storage.setCode(dto.getCode());
        storage.setDescription(dto.getDescription());
        storage.setIsAvailable(dto.getIsAvailable());

        //IMPLEMENTAR FUNCAO NO AUTH DE GET LOGGED USER
        storage.setUser(mapper.map(dto.getUser(), User.class));

        repository.save(storage);
        return mapper.map(storage, StorageLocationDTO.class);
    }

    public StorageLocationDTO update(UUID id, StorageLocationDTO dto) {
        var storage = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(getMessage("storage.not.found")));

        storage.setCode(StringUtils.hasText(dto.getCode()) ? dto.getCode() : storage.getCode());
        storage.setDescription(StringUtils.hasText(dto.getDescription()) ? dto.getDescription() : storage.getDescription());
        storage.setIsAvailable(dto.getIsAvailable());

        //IMPLEMENTAR FUNCAO NO AUTH DE GET LOGGED USER
        storage.setUser(mapper.map(dto.getUser(), User.class));

        return mapper.map(repository.save(storage), StorageLocationDTO.class);
    }

    public void delete(UUID id) {
        if (!repository.existsById(id)) {
            throw new ResourceNotFoundException(getMessage("storage.not.found"));
        }

        repository.deleteById(id);
    }

    public List<StorageLocationDTO> getAll() {
        return repository.findAll().stream()
                .map(storage -> mapper.map(storage, StorageLocationDTO.class))
                .collect(Collectors.toList());
    }

    public StorageLocationDTO getById(UUID id) {
        var storage = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(getMessage("storage.not.found")));

        return mapper.map(storage, StorageLocationDTO.class);
    }
}
