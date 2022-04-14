package com.regjobapi.security;

import org.springframework.stereotype.Component;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.jwt.Jwt;


@Component
public class RegJobSecurity {
	
	public Authentication getAuthentication() {
        return SecurityContextHolder.getContext().getAuthentication();
    }

    public boolean isAutenticado() {
        return getAuthentication().isAuthenticated();
    }

    public Integer getUnidadeId() {
        final Jwt jwt = (Jwt) getAuthentication().getPrincipal();
        return jwt.getClaim("unidade_id");
    }

    public long getUserId() {
        return castUser().longValue();
    }

    public Long castUser() {
        final Jwt jwt = (Jwt) getAuthentication().getPrincipal();
        return jwt.getClaim("id");
    }
    
    public String getIp() {
        final Jwt jwt = (Jwt) getAuthentication().getPrincipal();
        return jwt.getClaim("remote_address");
    }

    public boolean hasAuthority(String authorityName) {
        return getAuthentication().getAuthorities().stream()
                .anyMatch(authority -> authority.getAuthority().equals(authorityName));
    }

    public boolean isScopeWrite() {
        return hasAuthority("SCOPE_WRITE");
    }

    public boolean isScopeRead() {
        return hasAuthority("SCOPE_READ");
    }


}
