--changeset Edivaldo:1
CREATE TABLE tb_vaga
(
  id bigint  NOT NULL DEFAULT nextval((' vaga_id_seq'::text)::regclass),
  descricao character varying(255),
  tipo  character varying(20),
  data_inclusao timestamp DEFAULT (current_timestamp),
  CONSTRAINT id_vaga_pkey PRIMARY KEY  (id) 
)
WITH (
  OIDS=FALSE
);
  
  create sequence vaga_id_seq;

INSERT INTO tb_vaga (descricao, tipo) values ('DEV JAVA JUNIOR', '0');
INSERT INTO tb_vaga (descricao, tipo) values ('DEV JAVA PLENO', '1');
INSERT INTO tb_vaga (descricao, tipo) values ('DEV JAVA SENIOR', '0');
INSERT INTO tb_vaga (descricao, tipo) values ('DEV FRONTEND ANGULAR', '1');
INSERT INTO tb_vaga (descricao, tipo) values ('DEV FRONTEND REACT', '0');
INSERT INTO tb_vaga (descricao, tipo) values ('DEV FRONEND VUEJS', '1');
INSERT INTO tb_vaga (descricao, tipo) values ('DEV FULL STACK JAVA/ANGULAR', '0');  

