package com.regjobapi.repository.listener;

import javax.persistence.PostLoad;

import org.springframework.util.StringUtils;

import com.regjobapi.RegjobApiApplication;
import com.regjobapi.model.Candidato;
import com.regjobapi.service.SalvarUpload;
import com.regjobapi.model.Candidato;

public class AnexoListener {
	
	@PostLoad
	public void postLoad(Candidato candidato) {
		if (StringUtils.hasText(candidato.getAnexo())) {
			SalvarUpload salvar = RegjobApiApplication.getBean(SalvarUpload.class);
			candidato.setUrlAnexo(salvar.configurarUrl(candidato.getAnexo()));
		}
	}
}
