package com.regjobapi.model;

import java.io.Serializable;

import javax.persistence.Embeddable;

@Embeddable
public class UsuarioPermissoaID  implements Serializable{

	private static final long serialVersionUID = 1L;	
	private Long codigo_usuario;
	private Long codigo_permissao;
	
	public Long getCodigo_usuario() {
		return codigo_usuario;
	}
	public void setCodigo_usuario(Long codigo_usuario) {
		this.codigo_usuario = codigo_usuario;
	}
	public Long getCodigo_permissao() {
		return codigo_permissao;
	}
	public void setCodigo_permissao(Long codigo_permissao) {
		this.codigo_permissao = codigo_permissao;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codigo_permissao == null) ? 0 : codigo_permissao.hashCode());
		result = prime * result + ((codigo_usuario == null) ? 0 : codigo_usuario.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UsuarioPermissoaID other = (UsuarioPermissoaID) obj;
		if (codigo_permissao == null) {
			if (other.codigo_permissao != null)
				return false;
		} else if (!codigo_permissao.equals(other.codigo_permissao))
			return false;
		if (codigo_usuario == null) {
			if (other.codigo_usuario != null)
				return false;
		} else if (!codigo_usuario.equals(other.codigo_usuario))
			return false;
		return true;
	}
	

}
