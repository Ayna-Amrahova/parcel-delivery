package com.guavapay.task.service;

import com.guavapay.task.dto.LoginRequest;
import com.guavapay.task.dto.LoginResponse;
import com.guavapay.task.util.JwtTokenUtil;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;

import static com.guavapay.task.util.AuthenticatedUserUtils.USERNAME;
import static com.guavapay.task.util.JwtTokenType.ACCESS;
import static com.guavapay.task.util.JwtTokenType.REFRESH;

@Service
public class AuthService {

    private final UserTokensBusinessService userTokensBusinessService;
    private final AuthenticationManager authenticationManager;
    private final JwtTokenUtil jwtTokenUtil;
    private final UserTokensService userTokensService;

    public AuthService(UserTokensBusinessService userTokensBusinessService, AuthenticationManager authenticationManager,
                       JwtTokenUtil jwtTokenUtil, UserTokensService userTokensService) {
        this.userTokensBusinessService = userTokensBusinessService;
        this.authenticationManager = authenticationManager;
        this.jwtTokenUtil = jwtTokenUtil;
        this.userTokensService = userTokensService;
    }


    public LoginResponse login(LoginRequest request) {
        authenticate(request);

        String accessToken = jwtTokenUtil.createToken(request.getUsername(), ACCESS);
        String refreshToken = jwtTokenUtil.createToken(request.getUsername(), REFRESH);

        userTokensBusinessService.updateIfExistsOrCreate(request.getUsername(), accessToken, refreshToken);

        return new LoginResponse()
                .setAccessToken(accessToken)
                .setRefreshToken(refreshToken);
    }

    public void logout(String username) {
        userTokensService.deleteByUsername(username == null ? USERNAME() : username);
    }


    private void authenticate(LoginRequest request) {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.getUsername(),
                request.getPassword()));
    }

}
