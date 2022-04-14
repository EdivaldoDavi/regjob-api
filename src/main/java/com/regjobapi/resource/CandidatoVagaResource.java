package com.regjobapi.resource;

import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.configurationprocessor.json.JSONArray;
import org.springframework.boot.configurationprocessor.json.JSONException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.server.authorization.JwtEncodingContext;
import org.springframework.security.oauth2.server.authorization.OAuth2TokenCustomizer;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.nimbusds.jose.jwk.source.JWKSource;
import com.nimbusds.jose.proc.SecurityContext;
import com.regjobapi.config.AuthServerConfig;
import com.regjobapi.config.ResourceServerConfig;
import com.regjobapi.model.Candidato;
import com.regjobapi.model.CandidatoVaga;
import com.regjobapi.model.Vaga;
import com.regjobapi.repository.CandidatoVagaRepository;
import com.regjobapi.security.AppUserDetailsService;
import com.regjobapi.security.RegJobSecurity;
import com.regjobapi.security.UsuarioSistema;
import com.regjobapi.service.CandidatoVagaService;

@RestController
@RequestMapping("/candidatovaga")
public class CandidatoVagaResource {
	@Autowired
	private AuthServerConfig serverConfig;
	
	@Autowired
	private CandidatoVagaService service;
	
	@Autowired 
	private CandidatoVagaRepository repository;
	
	@PostMapping
	@RequestMapping("/cadastrar")
	@PreAuthorize("hasAuthority('ROLE_CADASTRAR_CANDIDATO')  and hasAuthority('SCOPE_write')")	
	public ResponseEntity<CandidatoVaga> criar(@Valid @RequestBody CandidatoVaga candidatoVaga, HttpServletResponse response){
		CandidatoVaga candidatoVagaSalvo = repository.save(candidatoVaga);
		return ResponseEntity.status(HttpStatus.CREATED).body(candidatoVagaSalvo);
		
	}
	@PostMapping
    @ResponseStatus(HttpStatus.OK)
	@RequestMapping("/cadastrar/list")
	@PreAuthorize("hasAuthority('ROLE_CADASTRAR_CANDIDATO')  and hasAuthority('SCOPE_write')")	
	 public HttpStatus criaObjetoCandidatoVaga(@RequestBody JSONArray array) throws JSONException {
	
		RegJobSecurity regJobSecurity =  new RegJobSecurity();
		Candidato candidato = new Candidato();
		candidato.setId(regJobSecurity.getUserId());
	
		
		 Vaga  vaga = new Vaga();
		
		for (int i=0; i < array.length(); i++) {
		 CandidatoVaga candidatoVaga = new CandidatoVaga();
			vaga.setId(array.getLong(i));
			candidatoVaga.setVaga(vaga);
			candidatoVaga.setCandidato(candidato);
			candidatoVaga.setVagaSalario(222000.00);
			CandidatoVaga candidatoVagaSalvo = repository.save(candidatoVaga);
		    System.out.println("array = " +vaga.getId());
		}
		  return  HttpStatus.CREATED;
		  }
	
	@GetMapping
	@RequestMapping("/listar")
	public List<CandidatoVaga> listar() {
		return service.listar();
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
