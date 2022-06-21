package com.guavapay.task.service;

import com.guavapay.task.dto.UserTokensDTO;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import java.time.LocalDateTime;

import static com.guavapay.task.util.JwtTokenType.ACCESS;
import static com.guavapay.task.util.JwtTokenType.REFRESH;
import static java.time.temporal.ChronoUnit.MILLIS;

@Service
public class UserTokensBusinessService {

    private final UserTokensService userTokensService;

    public UserTokensBusinessService(UserTokensService userTokensService) {
        this.userTokensService = userTokensService;
    }

    public void updateIfExistsOrCreate(String username, String access, String refresh) {
        UserTokensDTO tokens = null;
        try {
            tokens = userTokensService.findByUsername(username);
        } catch (Exception ignored) { // EntityNotFoundException
            tokens = new UserTokensDTO().setUsername(username);
        }

        userTokensService.insertOrUpdate(tokens
                .setAccessToken(DigestUtils.md5DigestAsHex(access.getBytes()))
                .setAccessTokenExpireDate(LocalDateTime.now().plus(ACCESS.getValidityTime(), MILLIS))
                .setRefreshToken(DigestUtils.md5DigestAsHex(refresh.getBytes()))
                .setRefreshTokenExpireDate(LocalDateTime.now().plus(REFRESH.getValidityTime(), MILLIS))
        );
    }


}
