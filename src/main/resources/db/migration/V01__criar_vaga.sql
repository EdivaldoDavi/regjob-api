--changeset Edivaldo:1
CREATE TABLE tb_vaga
(
  id bigint  NOT NULL DEFAULT nextval((' vaga_id_seq'::text)::regclass),
  descricao character varying(255),
  tipo  character varying(20),
  salario   numeric(10,2),
  data_inclusao timestamp DEFAULT (current_timestamp),
  CONSTRAINT id_vaga_pkey PRIMARY KEY  (id) 
)
WITH (
  OIDS=FALSE
);
  
  create sequence vaga_id_seq;

 INSERT INTO tb_vaga (descricao, tipo, salario) values ('desenvolvedor java senior', '0', '10000.00');

  