package com.regjobapi.resource;

import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.regjobapi.model.Candidato;
import com.regjobapi.model.CandidatoVaga;
import com.regjobapi.repository.CandidatoVagaRepository;
import com.regjobapi.service.CandidatoVagaService;

@RestController
@RequestMapping("/candidatovaga")
public class CandidatoVagaResource {
	
	@Autowired
	private CandidatoVagaService service;
	
	@Autowired 
	private CandidatoVagaRepository repository;
	
	@PostMapping
	@RequestMapping("/cadastrar")
	@PreAuthorize("hasAuthority('ROLE_CADASTRAR_CANDIDATO') and #oauth2.hasScope('write')")
	public ResponseEntity<CandidatoVaga> criar(@Valid @RequestBody CandidatoVaga candidatoVaga, HttpServletResponse response){
		CandidatoVaga candidatoVagaSalvo = repository.save(candidatoVaga);
		return ResponseEntity.status(HttpStatus.CREATED).body(candidatoVagaSalvo);
		
	}
	
	@GetMapping
	@RequestMapping("/listar")
	public List<CandidatoVaga> listar() {
		return service.listar();
	}
	
	 @RequestMapping("/login")
	    public String home(){
	        return "Hello World!";
	    }
	@GetMapping
	
	@RequestMapping("/pesquisar/vagaId/{vagaId}")
	public List<CandidatoVaga> BuscarPorCandidatoPorVagaId(@PathVariable Long vagaId) {
		return service.BuscarPorVagaId(vagaId);
	}
	@GetMapping
	@RequestMapping("/pesquisar/candidatoId/{candidatoId}")
	public List<CandidatoVaga> BuscarCandidatosPorCandidatoId(@PathVariable Long  candidatoId) {
		return service.BuscarCandidatosPorCandidatoId(candidatoId);
	}
	
	
}
