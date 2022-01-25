package com.regjobapi.service;

import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.regjobapi.event.RecursoCriadoEvent;
import com.regjobapi.model.Candidato;
import com.regjobapi.model.CandidatoVaga;
import com.regjobapi.repository.CandidatoVagaRepository;

@Service
public class CandidatoVagaService {
	@Autowired
	private CandidatoVagaRepository repository;
	
	
	@Autowired
	private ApplicationEventPublisher publisher;
	
	
	@GetMapping
	public List<CandidatoVaga> listar(){ 
		return repository.findAll();
	}


	public List<CandidatoVaga> BuscarPorVagaId(Long vagaId) {
		return repository.findByVagaId(vagaId);
	}


	public List<CandidatoVaga> BuscarCandidatosPorCandidatoId(Long candidatoId) {
		return repository.findByCandidatoId(candidatoId);
	}


	



	

}
