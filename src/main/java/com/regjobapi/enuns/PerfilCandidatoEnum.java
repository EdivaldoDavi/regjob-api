package com.regjobapi.enuns;

import com.regjobapi.service.GerarException;

public enum PerfilCandidatoEnum {
	JUNIOR("Junior"),
	PLENO("Pleno"),
	SENIOR("Senior");
private String valor;
	
	private PerfilCandidatoEnum(String valor) {
		this.valor = valor;
	}
	
	public String getValor() {
		return valor;
	}
	
	public static PerfilCandidatoEnum getEnumByValor(String valor) {
		for (PerfilCandidatoEnum tipo : PerfilCandidatoEnum.values()) {
			if (tipo.valor.equals(valor)) {
				return tipo;
			}
		}
		throw new  GerarException("Perfil candidato não encontrado!");
	}

}
