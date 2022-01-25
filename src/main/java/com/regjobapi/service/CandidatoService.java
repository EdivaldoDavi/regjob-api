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
import com.regjobapi.repository.CandidatoRepository;

@Service
public class CandidatoService {
	@Autowired
	private CandidatoRepository repository;
	
	
	@Autowired
	private ApplicationEventPublisher publisher;
	
	
	@GetMapping
	public List<Candidato> listar(){ 
		return repository.findAll();
	}
	
}
