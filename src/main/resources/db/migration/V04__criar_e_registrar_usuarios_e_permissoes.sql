
CREATE TABLE usuario (
codigo bigint NOT NULL DEFAULT nextval(('usuarios_id_seq'::text)::regclass),
	nome character varying(50) NOT NULL,
	email character varying(50) NOT NULL,
	senha character varying(150) NOT NULL,
	data_alteracao timestamp DEFAULT (current_timestamp),
CONSTRAINT codigo_usuario_pkey PRIMARY KEY  (codigo)
	

)
WITH (
  OIDS=FALSE
);

CREATE TABLE permissao (
	codigo bigint NOT NULL DEFAULT nextval(('permissoes_id_seq'::text)::regclass),
	descricao character varying(50) NOT NULL,
	apelido_descricao character varying(50) NOT NULL,
	CONSTRAINT codigo_permissao_pkey PRIMARY KEY  (codigo)
)
WITH (
  OIDS=FALSE
);

CREATE TABLE usuario_permissao (
    codigo_permissao bigint NOT NULL DEFAULT nextval(('usuario_permissao_id_seq'::text)::regclass),
	codigo_usuario bigint NOT NULL,
	
	CONSTRAINT codigo_usuario_permissao_pkey PRIMARY KEY  (codigo_usuario,codigo_permissao),
	
	 CONSTRAINT fkcodigo_usuario FOREIGN KEY (codigo_usuario)
      REFERENCES usuario (codigo) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION,
 	 CONSTRAINT fkcodigo_permissao FOREIGN KEY (codigo_permissao)
      REFERENCES permissao (codigo) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
	
	
)
WITH (
  OIDS=FALSE
);
  

INSERT INTO usuario (codigo, nome, email, senha) values (1, 'Administrador', 'admin@api.com', '$2a$10$X607ZPhQ4EgGNaYKt3n4SONjIv9zc.VMWdEuhCuba7oLAL5IvcL5.');
INSERT INTO usuario (codigo, nome, email, senha) values (2, 'kaspper', 'kaspper@api.com', '$2a$10$Zc3w6HyuPOPXamaMhh.PQOXvDnEsadztbfi6/RyZWJDzimE8WQjaq');

INSERT INTO permissao (codigo, descricao, apelido_descricao) values (1, 'ROLE_CADASTRAR_CANDIDATO', 'Cadastrar Candidato');
INSERT INTO permissao (codigo, descricao, apelido_descricao) values (2, 'ROLE_PESQUISAR_CANDIDATO', 'Pesquisar Candidato');

INSERT INTO permissao (codigo, descricao, apelido_descricao) values (3, 'ROLE_CADASTRAR_CANDIDATO_VAGA', 'Cadastrar Candidato na vaga pretendente');
INSERT INTO permissao (codigo, descricao, apelido_descricao) values (4, 'ROLE_REMOVER_CANDIDATO', 'Excluir Candidato');
INSERT INTO permissao (codigo, descricao, apelido_descricao) values (5, 'ROLE_PESQUISAR_CANDIDATO', 'Pesquisar Candidato');

INSERT INTO permissao (codigo, descricao, apelido_descricao) values (6, 'ROLE_CADASTRAR_VAGA', 'Cadastrar Vaga');
INSERT INTO permissao (codigo, descricao, apelido_descricao) values (7, 'ROLE_REMOVER_VAGA', 'Excluir Vaga');
INSERT INTO permissao (codigo, descricao, apelido_descricao) values (8, 'ROLE_PESQUISAR_VAGA', 'Pesquisar Vaga');

-- admin
INSERT INTO usuario_permissao (codigo_usuario, codigo_permissao) values (1, 1);
INSERT INTO usuario_permissao (codigo_usuario, codigo_permissao) values (1, 2);
INSERT INTO usuario_permissao (codigo_usuario, codigo_permissao) values (1, 3);
INSERT INTO usuario_permissao (codigo_usuario, codigo_permissao) values (1, 4);
INSERT INTO usuario_permissao (codigo_usuario, codigo_permissao) values (1, 5);
INSERT INTO usuario_permissao (codigo_usuario, codigo_permissao) values (1, 6);
INSERT INTO usuario_permissao (codigo_usuario, codigo_permissao) values (1, 7);
INSERT INTO usuario_permissao (codigo_usuario, codigo_permissao) values (1, 8);

-- maria
INSERT INTO usuario_permissao (codigo_usuario, codigo_permissao) values (2, 2);
INSERT INTO usuario_permissao (codigo_usuario, codigo_permissao) values (2, 5);
INSERT INTO usuario_permissao (codigo_usuario, codigo_permissao) values (2, 8);