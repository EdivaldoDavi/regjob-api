ALTER TABLE usuario
ADD COLUMN ativo BOOLEAN DEFAULT true,
ADD COLUMN dataAlteracao timestamp with time zone  DEFAULT now();
