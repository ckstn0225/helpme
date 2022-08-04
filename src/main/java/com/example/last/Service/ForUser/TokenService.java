package com.example.last.Service.ForUser;

import com.example.last.Entity.RefreshToken;
import com.example.last.Repository.RefreshTokenRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TokenService {

    private final RefreshTokenRepository repository;

    public void Tokensave(RefreshToken refreshToken){
        repository.save(refreshToken);
    }
}
