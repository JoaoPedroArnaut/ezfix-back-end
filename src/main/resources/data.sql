INSERT INTO PERFIL(nome) VALUES ('ROLE_SOLICITANTE');
INSERT INTO PERFIL(nome) VALUES ('ROLE_ASSISTENCIA');

INSERT INTO USUARIO(email, senha) VALUES('teste@email.com', '$2a$10$yq5Qce.6SReNowlO.x6IAOk5yYV8EHdrTkvdnbucuHxFnBHiF6wSK');

INSERT INTO USUARIO_PERFIS(USUARIO_EMAIL,PERFIS_ID) VALUES ('teste@email.com',1);

INSERT INTO SOLICITANTE(cpf, nome, data_nascimento, telefone_primario, telefone_secundario, usuario_email) VALUES('49502294866', 'joao', '2001-08-01', 11988724342, 1127122404,'teste@email.com');

INSERT INTO ENDERECO(id,cep,numero)VALUES (1,03185050,761);

INSERT INTO SOLICITANTE_ENDERECOS(solicitante_cpf,enderecos_id,enderecos_cep)VALUES ('49502294866',1,03185050);

INSERT INTO PLANO(tipo) VALUES ('basico');
INSERT INTO PLANO(tipo) VALUES ('normal');
INSERT INTO PLANO(tipo) VALUES ('avançado');

INSERT INTO SERVICO(servico) VALUES ('reparo de tela');

INSERT INTO PRODUTO(tipo, marca, modelo) VALUES ('celular','samsung','m31');