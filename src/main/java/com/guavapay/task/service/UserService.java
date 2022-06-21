package com.guavapay.task.service;

import com.guavapay.task.dto.UserDTO;
import com.guavapay.task.repository.UserRepository;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    public void createUser(UserDTO userDTO) {
        userRepository.save(UserDTO.toEntity(userDTO));
    }

    public UserDTO findByUsername(String username) {
        return UserDTO.fromEntity(
                userRepository.findByUsername(username).orElseThrow(EntityNotFoundException::new)
        );
    }

}
