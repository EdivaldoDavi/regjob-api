INSERT INTO permissao (codigo, descricao, apelido_descricao) values (9, 'ROLE_CADASTRAR_USUARIO', 'Cadastrar Usuário');
INSERT INTO permissao (codigo, descricao, apelido_descricao) values (10, 'ROLE_REMOVER_USUARIO', 'Excluir Usuário');
INSERT INTO permissao (codigo, descricao, apelido_descricao) values (11, 'ROLE_PESQUISAR_USUARIO', 'Pesquisar Usuário');

-- admin
INSERT INTO usuario_permissao (codigo_usuario, codigo_permissao) values (1, 9);
INSERT INTO usuario_permissao (codigo_usuario, codigo_permissao) values (1, 10);
INSERT INTO usuario_permissao (codigo_usuario, codigo_permissao) values (1, 11);