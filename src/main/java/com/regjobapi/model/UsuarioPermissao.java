package com.regjobapi.model;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;



@Entity
@Table(name= "usuario_permissao")
public class UsuarioPermissao {
	
	@EmbeddedId
	private UsuarioPermissoaID id = new UsuarioPermissoaID();
	
	@OneToOne
	@JoinColumn(name = "codigo_usuario", insertable = false, updatable = false)
	private Usuario usuario;
	@OneToOne
	@JoinColumn(name = "codigo_permissao", insertable = false, updatable = false)
	private Permissao permissao;
	
	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	public Permissao getPermissao() {
		return permissao;
	}
	public void setPermissao(Permissao permissao) {
		this.permissao = permissao;
	}
	
	
}
