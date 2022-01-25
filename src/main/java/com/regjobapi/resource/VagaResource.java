package com.regjobapi.resource;

import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.regjobapi.event.RecursoCriadoEvent;
import com.regjobapi.model.Vaga;
import com.regjobapi.repository.VagaRepository;
import com.regjobapi.service.VagaService;

@RestController
@RequestMapping("/vaga")
public class VagaResource {
	@Autowired
	private VagaService service;
	
	@Autowired
	private VagaRepository repository;
	
	@Autowired
	private ApplicationEventPublisher publisher;
	
	@PostMapping
	@RequestMapping("/cadastrar")
	@PreAuthorize("hasAuthority('ROLE_CADASTRAR_CANDIDATO') and #oauth2.hasScope('write')")
	public ResponseEntity<Vaga> criar(@Valid @RequestBody Vaga vaga, HttpServletResponse response){
		 Vaga vagaSalva = repository.save(vaga);
		publisher.publishEvent(new RecursoCriadoEvent(this, response, vagaSalva.getId()));		
		return ResponseEntity.status(HttpStatus.CREATED).body(vagaSalva);
		}
		
	
	
	@GetMapping
	@RequestMapping("/listar")
	public List<Vaga> listar() {
		return service.listar();
	}
	
	
	

}
