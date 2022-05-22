INSERT INTO PERFIL(nome) VALUES ('ROLE_SOLICITANTE');
INSERT INTO PERFIL(nome) VALUES ('ROLE_ASSISTENCIA');

INSERT INTO PLANO(tipo) VALUES ('basico');
INSERT INTO PLANO(tipo) VALUES ('normal');
INSERT INTO PLANO(tipo) VALUES ('avançado');

INSERT INTO SERVICO(servico) VALUES ('reparo de tela');

INSERT INTO MARCA VALUES (1,'samsung'),(2,'xiaomi'),(3,'apple');
INSERT INTO MODELO VALUES (1,'galaxy m31'),(2,'redmi note 9'),(3,'iphone 13');
INSERT INTO TIPO VALUES (1,'smartphone');

INSERT INTO PRODUTO(id,tipo_id,marca_id,modelo_id) VALUES (1,1,1,1),(2,1,2,2),(3,1,3,3);