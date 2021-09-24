INSERT INTO USUARIO(email, senha) VALUES('teste@email.com', '$2a$10$yq5Qce.6SReNowlO.x6IAOk5yYV8EHdrTkvdnbucuHxFnBHiF6wSK');

INSERT INTO SOLICITANTE(cpf, nome, data_nascimento, sexo, telefone_primario, telefone_secundario, usuario_email) VALUES('49502294866', 'joao', '2001-08-01', 'masculino', 11988724342, 1127122404,'teste@email.com');

INSERT INTO ENDERECO(id,cep,numero)VALUES (1,03185050,761);

INSERT INTO SOLICITANTE_ENDERECOS(solicitante_cpf,enderecos_id,enderecos_cep)VALUES ('49502294866',1,03185050)