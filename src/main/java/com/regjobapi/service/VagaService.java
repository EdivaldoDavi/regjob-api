package com.regjobapi.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import com.regjobapi.model.Vaga;
import com.regjobapi.repository.VagaRepository;
@Service
public class VagaService {
	
	@Autowired
	private VagaRepository repository;
	
	@Autowired
	private ApplicationEventPublisher publisher;
	
	@GetMapping
	public List<Vaga> listar(){ 
		return repository.findAll();
	}
	
		
	public Optional<Vaga> buscarVagaPeloCodigo(Long vagaId) {
		Optional<Vaga> vagaSalva = repository.findById(vagaId);
		if (vagaSalva == null) {
			throw new EmptyResultDataAccessException(1);
		}
		return vagaSalva;
	}


	
}
