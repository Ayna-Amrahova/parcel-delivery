package com.guavapay.task.repository;

import com.guavapay.task.enums.entity.UserTokensEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;

import javax.transaction.Transactional;
import java.util.Optional;

public interface UserTokensRepository extends JpaRepository<UserTokensEntity, Integer> {

    Optional<UserTokensEntity> findByUsername(String username);

    boolean existsByAccessTokenAndUsername(String accessToken, String username);

    boolean existsByRefreshTokenAndUsername(String refreshToken, String username);

    @Transactional
    @Modifying
    void deleteByUsername(String username);
}
