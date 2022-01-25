package com.regjobapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.regjobapi.model.CandidatoVaga;

public interface CandidatoVagaRepository extends JpaRepository<CandidatoVaga, Long> {
	
	List<CandidatoVaga> findByVagaId(Long vagaId);

	List<CandidatoVaga> findByCandidatoId(Long candidatoId);



}
