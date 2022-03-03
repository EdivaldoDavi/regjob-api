package com.regjobapi.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.regjobapi.enuns.TipoVagaEnum;

import lombok.Data;

@Data
@Entity
@Table(name= "tb_vaga")
public class Vaga {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) 
	private Long id;
	
	@NotNull
	@Size(min = 3 , max = 80)	
	private String descricao;
	
	private TipoVagaEnum  tipo;
	


	

}
