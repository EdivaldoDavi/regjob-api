package com.regjobapi.model;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.regjobapi.enuns.PerfilCandidatoEnum;

import lombok.Data;

@Data
@Entity
@Table(name= "tb_candidato")
public class Candidato {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) 
	private Long id;
	
	@NotNull
	@Size(min = 3 , max = 80)	
	private String nome;
	private PerfilCandidatoEnum perfil;
	private String anexo;
	
	@Transient
	private String urlAnexo; 
	
	private Double salario;

}
