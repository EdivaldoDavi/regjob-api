package com.regjobapi.security;


import java.util.Arrays;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


import com.regjobapi.model.Usuario;
import com.regjobapi.repository.UsuarioRepository;

@Service
public class UserService implements UserDetailsService {

   private final UsuarioRepository repository;

   public UserService(UsuarioRepository repository) {
       this.repository = repository;
   }

   @Override
   public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
       Usuario user = repository.findByEmail(username).orElseThrow(() -> new RuntimeException("User not found: " + username));
       GrantedAuthority authority = new SimpleGrantedAuthority(user.getPermissoes().get(0).getDescricao());
       return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getSenha(), Arrays.asList(authority));
   }
}