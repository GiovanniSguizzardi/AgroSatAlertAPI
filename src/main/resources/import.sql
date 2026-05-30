INSERT INTO produtores (nome, cpf, email, telefone, data_cadastro) VALUES ('Joao Silva', '123.456.789-00', 'joao@fazenda.com', '(65) 99999-1111', '2026-01-05');
INSERT INTO produtores (nome, cpf, email, telefone, data_cadastro) VALUES ('Maria Souza', '987.654.321-00', 'maria@fazenda.com', '(62) 99999-2222', '2026-01-10');
INSERT INTO produtores (nome, cpf, email, telefone, data_cadastro) VALUES ('Carlos Oliveira', '111.222.333-44', 'carlos@fazenda.com', '(51) 99999-3333', '2026-01-15');
INSERT INTO produtores (nome, cpf, email, telefone, data_cadastro) VALUES ('Ana Lima', '555.666.777-88', 'ana@fazenda.com', '(11) 99999-4444', '2026-01-20');

INSERT INTO satelites (nome, agencia, altitude_km, data_lancamento, status_operacional) VALUES ('CBERS-4A', 'INPE', 628.0, '2019-12-20', 'ATIVO');
INSERT INTO satelites (nome, agencia, altitude_km, data_lancamento, status_operacional) VALUES ('Sentinel-1A', 'ESA', 693.0, '2014-04-03', 'ATIVO');
INSERT INTO satelites (nome, agencia, altitude_km, data_lancamento, status_operacional) VALUES ('GOES-16', 'NOAA/NASA', 35786.0, '2016-11-19', 'ATIVO');
INSERT INTO satelites (nome, agencia, altitude_km, data_lancamento, status_operacional) VALUES ('Aqua', 'NASA', 705.0, '2002-05-04', 'ATIVO');

INSERT INTO talhoes (nome, cultura, area_hectares, localizacao, data_cadastro, produtor_id) VALUES ('Talhao Norte 1', 'Soja', 120.5, 'Fazenda A - Regiao Norte, MT', '2026-01-10', 1);
INSERT INTO talhoes (nome, cultura, area_hectares, localizacao, data_cadastro, produtor_id) VALUES ('Talhao Norte 2', 'Milho', 80.0, 'Fazenda A - Regiao Norte, MT', '2026-01-15', 1);
INSERT INTO talhoes (nome, cultura, area_hectares, localizacao, data_cadastro, produtor_id) VALUES ('Talhao Centro 1', 'Algodao', 150.0, 'Fazenda B - Regiao Centro, GO', '2026-02-05', 2);
INSERT INTO talhoes (nome, cultura, area_hectares, localizacao, data_cadastro, produtor_id) VALUES ('Talhao Sul 1', 'Arroz', 180.0, 'Fazenda C - Regiao Sul, RS', '2026-02-20', 3);

INSERT INTO alertas_climaticos (tipo_alerta, severidade, impacto_estimado, data_evento, status, talhao_id, satelite_id) VALUES ('Risco de Seca', 8, 6.5, '2026-05-26', 'EM_ANALISE', 1, 1);
INSERT INTO alertas_climaticos (tipo_alerta, severidade, impacto_estimado, data_evento, status, talhao_id, satelite_id) VALUES ('Temperatura Elevada', 6, 4.2, '2026-05-25', 'MONITORANDO', 2, 2);
INSERT INTO alertas_climaticos (tipo_alerta, severidade, impacto_estimado, data_evento, status, talhao_id, satelite_id) VALUES ('Anomalia Climatica', 9, 7.8, '2026-05-26', 'EM_ANALISE', 3, 3);
INSERT INTO alertas_climaticos (tipo_alerta, severidade, impacto_estimado, data_evento, status, talhao_id, satelite_id) VALUES ('Tempestade Severa', 10, 9.1, '2026-05-26', 'CRITICO', 4, 4);