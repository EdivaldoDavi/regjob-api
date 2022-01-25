package com.regjobapi.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.regjobapi.model.Vaga;

public interface VagaRepository extends JpaRepository<Vaga, Long> {
	
	

}
