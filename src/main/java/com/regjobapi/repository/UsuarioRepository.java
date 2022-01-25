package com.regjobapi.repository;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.regjobapi.model.Usuario;

public interface UsuarioRepository  extends JpaRepository<Usuario, Long>{
	public Page<Usuario> findByNomeIgnoreCaseContaining(String nome, Pageable pageable);
	public Optional<Usuario> findByEmail(String username);

}
