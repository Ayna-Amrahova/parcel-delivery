package com.guavapay.task.service;

import com.guavapay.task.dto.UserTokensDTO;
import com.guavapay.task.repository.UserTokensRepository;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;

@Service
public class UserTokensService {

    private final UserTokensRepository userTokensRepository;

    public UserTokensService(UserTokensRepository userTokensRepository) {
        this.userTokensRepository = userTokensRepository;
    }

    public void insertOrUpdate(UserTokensDTO userTokensDto) {
        userTokensRepository.save(UserTokensDTO.toEntity(userTokensDto));
    }

    public UserTokensDTO findByUsername(String username) {
        return UserTokensDTO.fromEntity(
                userTokensRepository.findByUsername(username).orElseThrow(EntityNotFoundException::new)
        );
    }

    public boolean checkByAccessToken(String accessToken, String username) {
        return userTokensRepository.existsByAccessTokenAndUsername(accessToken, username);
    }

    public boolean checkByRefreshToken(String refreshToken, String username) {
        return userTokensRepository.existsByRefreshTokenAndUsername(refreshToken, username);
    }

    @Transactional
    public void deleteByUsername(String username) {
        userTokensRepository.deleteByUsername(username);
    }

}
