package com.regjobapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.regjobapi.model.Candidato;

public interface CandidatoRepository  extends JpaRepository<Candidato, Long>{

}
