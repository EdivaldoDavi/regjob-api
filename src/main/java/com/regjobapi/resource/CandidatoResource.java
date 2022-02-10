package com.regjobapi.resource;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.regjobapi.dto.Anexo;
import com.regjobapi.event.RecursoCriadoEvent;
import com.regjobapi.model.Candidato;
import com.regjobapi.repository.CandidatoRepository;
import com.regjobapi.service.CandidatoService;
import com.regjobapi.storage.S3;



@RestController
@RequestMapping("/candidato")
public class CandidatoResource {
	
	@Autowired
	private CandidatoService service;
	
	@Autowired 
	private CandidatoRepository repository;

	@Autowired
	private ApplicationEventPublisher publisher; 

	@Autowired
	private S3 s3;
	
	@Autowired
	private ServletContext servletContext;
	
	@PostMapping
	@RequestMapping("/cadastrar")
	@PreAuthorize("hasAuthority('ROLE_CADASTRAR_CANDIDATO')  and hasAuthority('SCOPE_write')")
	public ResponseEntity<Candidato> criar(@Valid @RequestBody Candidato candidato, HttpServletResponse response){
	
		publisher.publishEvent(new RecursoCriadoEvent(this, response, candidato.getId()));	
		/*if (StringUtils.hasText(candidato.getAnexo())) {
			s3.salvar(candidato.getAnexo());
		}*/
		Candidato candidatoSalvo = repository.save(candidato);
		return ResponseEntity.status(HttpStatus.CREATED).body(candidatoSalvo);
		
	}
	
	@GetMapping
	@RequestMapping("/listar")
	public List<Candidato> listar() {
		return service.listar();
	} 
	
	@PostMapping("/anexo")
	@PreAuthorize("hasAuthority('ROLE_CADASTRAR_CANDIDATO') and hasAuthority('SCOPE_write')")
	public String uploadAnexo( @RequestParam("file")  MultipartFile anexo, String response ) throws IOException {
		
		if (anexo != null && !anexo.isEmpty()) {
	        
	    	OutputStream out = new FileOutputStream("/Users/Edivaldo/Documents/anexo--" + anexo.getOriginalFilename()); 
			out.write(anexo.getBytes());
			out.close();
	    }
		return response;
	}
	
	@GetMapping("/anexo/files")
	@PreAuthorize("hasAuthority('ROLE_CADASTRAR_CANDIDATO') and hasAuthority('SCOPE_write')")
	public List<String> preenchelista() {
        String[] nomes;
        File diretorio = new File("/Users/Edivaldo/Documents/");
        nomes = diretorio.list(); //lista os arquivos
        List<String> lista = Arrays.asList(nomes); //passo de Array para List
        Collections.sort(lista); //ordeno a lista
        return lista;
    }

}
