package com.example.last.security.filter;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class FormLoginFilter extends UsernamePasswordAuthenticationFilter {
    final private ObjectMapper objectMapper;

    public FormLoginFilter(final AuthenticationManager authenticationManager) {
        super.setAuthenticationManager(authenticationManager);
        objectMapper = new ObjectMapper()
                .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
    }


    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException {


        JsonNode requestBody = null;
        try {
            requestBody = objectMapper.readTree(request.getInputStream());
        } catch (IOException e) {
            throw new RuntimeException("내용이 없습니다!");
        } catch (NullPointerException e){
            throw new RuntimeException("내용이 없습니다!");
        }
        String username = requestBody.get("username").asText();
        String password = requestBody.get("password").asText();
        UsernamePasswordAuthenticationToken authRequest = new UsernamePasswordAuthenticationToken(username, password);

        setDetails(request, authRequest);
        return this.getAuthenticationManager().authenticate(authRequest);
    }
}
