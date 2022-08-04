package com.example.last.security;


import com.example.last.security.jwt.JwtTokenUtils;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.token.TokenService;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;



public class FormLoginSuccessHandler extends SavedRequestAwareAuthenticationSuccessHandler {
    public static final String AUTH_HEADER = "Authorization";
    public static final String TOKEN_TYPE = "BEARER";
    public static final String RefreshTOKEN_TYPE = "RefreshToken";



    @Override
    public void onAuthenticationSuccess(final HttpServletRequest request, final HttpServletResponse response,
                                        final Authentication authentication) throws IOException {
        final UserDetailsImpl userDetails = ((UserDetailsImpl) authentication.getPrincipal());
        response.setContentType("application/json");
        PrintWriter out = response.getWriter();
        out.println(true);
        // Token 생성
        final String token = JwtTokenUtils.generateJwtToken(userDetails);

        final String refresh = JwtTokenUtils.generaterefreshToken(userDetails);

        response.addHeader(AUTH_HEADER, TOKEN_TYPE + " " + token);

        response.addHeader(RefreshTOKEN_TYPE,TOKEN_TYPE+" "+refresh);


    }

}
