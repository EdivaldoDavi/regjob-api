--changeset Edivaldo:1
CREATE TABLE tb_candidato 
(  
  id bigint  NOT NULL DEFAULT nextval(('candidato_id_seq'::text)::regclass),
  nome character varying(80) NOT NULL,
  perfil character varying(20) NOT NULL,
  anexo character varying(80),
  salario  numeric(10,2) NOT NULL,
  data_inclusao timestamp DEFAULT (current_timestamp),
  CONSTRAINT id_candidato_pkey PRIMARY KEY  (id) 
)
WITH (
  OIDS=FALSE
);
 
  create sequence candidato_id_seq;


 INSERT INTO tb_candidato (nome, perfil, anexo, salario) values ('kaspper', '0', 'teste de anexo', 12000.00);