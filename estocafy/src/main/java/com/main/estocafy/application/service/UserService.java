package com.main.estocafy.application.service;

import com.main.estocafy.application.domain.model.Plan;
import com.main.estocafy.application.domain.model.User;
import com.main.estocafy.application.dto.UserDTO;
import com.main.estocafy.application.repository.UserRepository;
import com.main.estocafy.shared.exceptions.types.ResourceNotFoundException;
import com.main.estocafy.shared.services.ServiceBase;
import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserService extends ServiceBase {

    private final UserRepository repository;

    private final PasswordEncoder passwordEncoder;

    public UserDTO save(UserDTO dto) {
        User user = new User();
        user.setEmail(dto.getEmail());
        user.setName(dto.getName());
        user.setPhone(dto.getPhone());
        user.setPassword(passwordEncoder.encode(dto.getPassword()));
        user.setRoles(dto.getRoles());

        var userSaved = repository.save(user);

        return mapper.map(userSaved, UserDTO.class);
    }

    public List<UserDTO> getAll() {
        return repository.findAll().stream()
                .map(user -> mapper.map(user, UserDTO.class))
                .collect(Collectors.toList());
    }

    public UserDTO getById(UUID id) {
        User user = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(getMessage("user.not.found")));

        return mapper.map(user, UserDTO.class);
    }

    public UserDTO update(UUID id, @NotNull UserDTO dto) {
        User user = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(getMessage("user.not.found")));
        user.setEmail(StringUtils.hasText(dto.getEmail())  ? dto.getEmail() : user.getEmail());
        user.setName(StringUtils.hasText(dto.getName()) ? dto.getName() : user.getName());
        user.setPhone(StringUtils.hasText(dto.getPhone()) ? dto.getPhone() : user.getPhone());

        if (!CollectionUtils.isEmpty(dto.getRoles())) {
            user.setRoles(dto.getRoles());
        }

        if(dto.getPassword() != null) {
            user.setPassword(passwordEncoder.encode(dto.getPassword()));
        }

        if (dto.getPlan() != null) {
            user.setPlan(mapper.map(dto.getPlan(), Plan.class));
        }

        return mapper.map(repository.save(user), UserDTO.class);
    }

    public void delete(UUID id) {
        if (!repository.existsById(id)) {
            throw new ResourceNotFoundException(getMessage("user.not.found"));
        }

        repository.deleteById(id);
    }
}
