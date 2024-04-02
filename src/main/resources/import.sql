INSERT INTO tb_cliente (cpf, nome, categoria, data_Nascimento, estado, cidade, rua, numero, logradouro) VALUES ('111', 'Raphael', 'Premium', '2020-07-13', 'SP', 'São Paulo', 'Rua 1', '100', 'Centro');
INSERT INTO tb_cliente (cpf, nome, categoria, data_Nascimento, estado, cidade, rua, numero, logradouro) VALUES ('222', 'Jorge', 'Super', '2020-07-14', 'RJ', 'Rio de Janeiro', 'Rua 2', '102A', 'Centro');
INSERT INTO tb_cliente (cpf, nome, categoria, data_Nascimento, estado, cidade, rua, numero, logradouro) VALUES ('333', 'Ana', 'Premium', '2020-07-14', 'SP', 'São Paulo', 'Rua 1', '100', 'Centro');
INSERT INTO tb_cliente (cpf, nome, categoria, data_Nascimento, estado, cidade, rua, numero, logradouro) VALUES ('444', 'Pedro', 'Premium', '2020-07-14', 'MG', 'Belo Horizonte', 'Rua 2', '111', 'Centro');
INSERT INTO tb_cliente (cpf, nome, categoria, data_Nascimento, estado, cidade, rua, numero, logradouro) VALUES ('555', 'Ana Cecilia', 'Super', '2020-07-14', 'RJ', 'Rio de Janeiro', 'Rua 10', '102B', 'Centro');
INSERT INTO tb_cliente (cpf, nome, categoria, data_Nascimento, estado, cidade, rua, numero, logradouro) VALUES ('666', 'Monica', 'Super', '2020-07-14', 'SP', 'São Paulo', 'Rua 3', '89B', 'Bairro A');
INSERT INTO tb_cliente (cpf, nome, categoria, data_Nascimento, estado, cidade, rua, numero, logradouro) VALUES ('777', 'Moises', 'Premium', '2020-07-14', 'MG', 'Belo Horizonte', 'Rua 20', '001', 'Bairro B');
INSERT INTO tb_cliente (cpf, nome, categoria, data_Nascimento, estado, cidade, rua, numero, logradouro) VALUES ('888', 'Renata', 'Premium', '2020-07-14', 'RJ', 'Rio de Janeiro', 'Rua 10', '102B', 'Centro');
INSERT INTO tb_cliente (cpf, nome, categoria, data_Nascimento, estado, cidade, rua, numero, logradouro) VALUES ('999', 'Neto', 'Premium', '2020-07-14', 'SP', 'São Paulo', 'Rua 5', '030A', 'Bairro D');


INSERT INTO tb_conta(conta_tipo, conta_saldo, cliente_id) VALUES('Corrente', 2000, 1);
INSERT INTO tb_conta(conta_tipo, conta_saldo, cliente_id) VALUES('Poupança', 1050, 2);
INSERT INTO tb_conta(conta_tipo, conta_saldo, cliente_id) VALUES('Corrente', 3000, 3);
INSERT INTO tb_conta(conta_tipo, conta_saldo, cliente_id) VALUES('Corrente', 0800, 4);
INSERT INTO tb_conta(conta_tipo, conta_saldo, cliente_id) VALUES('Poupança', 1200, 5);
INSERT INTO tb_conta(conta_tipo, conta_saldo, cliente_id) VALUES('Poupança', 2000, 6);
INSERT INTO tb_conta(conta_tipo, conta_saldo, cliente_id) VALUES('Corrente', 0500, 7);
INSERT INTO tb_conta(conta_tipo, conta_saldo, cliente_id) VALUES('Poupança', 0700, 8);
INSERT INTO tb_conta(conta_tipo, conta_saldo, cliente_id) VALUES('Corrente', 1300, 9);
INSERT INTO tb_conta(conta_tipo, conta_saldo, cliente_id) VALUES('Poupança', 1600, 1);


INSERT INTO tb_conta_corrente(taxa_mensal, conta_id) VALUES(5, 1);

INSERT INTO tb_conta_poupanca(taxa_rendimento, conta_id) VALUES(10, 2);


INSERT INTO tb_cartao(cartao_tipo, cartao_status, cartao_senha, cartao_limite, cartao_limite_usado, cartao_data, conta_id) VALUES('Premium', 'Ativado', '111', 1000.0, 500, TIMESTAMP WITH TIME ZONE '2020-07-14T10:00:00Z', 1);


INSERT INTO tb_seguro (seguro_numero_apolice, seguro_condicoes, seguro_detalhes_cartao, seguro_valor_apolice, seguro_descricao, seguro_data_contrato, cartao_id)  VALUES (111, 'Seguro Condiçoes', 'Seguro Detalhes', 111.11, 'Seguro Descrição', '2020-07-14', 1);

