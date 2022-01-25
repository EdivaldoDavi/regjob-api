package com.regjobapi.enuns;

import com.regjobapi.service.GerarException;

public enum TipoVagaEnum {
	CLT("CLT"),
	PJ("PJ");
	
	private String valor;
	
	private TipoVagaEnum(String valor) {
		this.valor = valor;
	}
	
	public String getValor() {
		return valor;
	}
	
	public static TipoVagaEnum getEnumByValor(String valor) {
		for (TipoVagaEnum tipo : TipoVagaEnum.values()) {
			if (tipo.valor.equals(valor)) {
				return tipo;
			}
		}
		throw new  GerarException("Tipo não encontrado!");
	}
	

}
