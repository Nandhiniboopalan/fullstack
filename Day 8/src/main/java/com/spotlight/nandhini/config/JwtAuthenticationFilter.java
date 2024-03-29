package com.spotlight.nandhini.config;



import java.io.IOException;

import org.springframework.http.HttpHeaders;
import org.springframework.lang.NonNull;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;
import com.spotlight.nandhini.repository.TokenRepository;

import com.spotlight.nandhini.utils.Jwtutils;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class JwtAuthenticationFilter extends OncePerRequestFilter{

    private final Jwtutils jwtutils;
    private final UserDetailsService userDetailsService;
    private final TokenRepository tokenRepository;
    @Override
    protected void doFilterInternal(
        @NonNull HttpServletRequest request, 
        @NonNull HttpServletResponse response, 
        @NonNull FilterChain filterChain)
            throws ServletException, IOException {

                final String authHeader = request.getHeader(HttpHeaders.AUTHORIZATION);
                final String token;
                final String email;

                if ( authHeader == null || !authHeader.startsWith("Bearer")) {
                    
                    filterChain.doFilter(request, response);
                    return;

                }

                token = authHeader.substring(7);
                email = jwtutils.extractEmail(token);

                if(email != null && SecurityContextHolder.getContext().getAuthentication() == null){
                    UserDetails userDetails = this.userDetailsService.loadUserByUsername(email);
                    var isTokenValid = tokenRepository.findByToken(token)
                            .map(t -> !t.isExpired() && !t.isRevoked())
                            .orElse(false);  
                                       
                    if(jwtutils.isTokenValid(token, userDetails) && isTokenValid){
                            UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
                            authenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                            SecurityContextHolder.getContext().setAuthentication(authenticationToken);
                    }
                }
                filterChain.doFilter(request, response);    
    }


    
}
