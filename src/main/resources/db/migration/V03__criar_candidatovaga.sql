--changeset Edivaldo:1
CREATE TABLE tb_candidato_vaga 
(  
  id bigint  NOT NULL DEFAULT nextval(('candidato_vaga_id_seq'::text)::regclass),
  cv_candidato_id bigint NOT NULL,
  cv_vaga_id  bigint NOT NULL,
  data_inclusao timestamp DEFAULT (current_timestamp),
  CONSTRAINT cv_id_pkey PRIMARY KEY  (id) 
)
WITH (
  OIDS=FALSE
);
  
  create sequence candidato_vaga_id_seq;


