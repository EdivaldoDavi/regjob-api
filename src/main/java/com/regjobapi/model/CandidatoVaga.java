package com.regjobapi.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import lombok.Data;

@Data
@Entity
@Table(name= "tb_candidato_vaga")
public class CandidatoVaga {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) 
	private Long id;
	
	@NotNull
	@ManyToOne
	@JoinColumn(name = "cv_candidato_id")
	private Candidato candidato;
	
	@NotNull
	@ManyToOne
	@JoinColumn(name = "cv_vaga_id")
	private Vaga vaga;
	
	private double vagaSalario;
	
	
	
	
	

}
