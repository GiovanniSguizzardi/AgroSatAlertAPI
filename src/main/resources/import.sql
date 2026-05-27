INSERT INTO tb_talhao (nome, cultura, area_hectares, localizacao, data_cadastro) VALUES ('Talhao Norte 1', 'Soja', 120.5, 'Fazenda A - Regiao Norte, MT', '2026-01-10');
INSERT INTO tb_talhao (nome, cultura, area_hectares, localizacao, data_cadastro) VALUES ('Talhao Norte 2', 'Milho', 80.0, 'Fazenda A - Regiao Norte, MT', '2026-01-15');
INSERT INTO tb_talhao (nome, cultura, area_hectares, localizacao, data_cadastro) VALUES ('Talhao Centro 1', 'Algodao', 150.0, 'Fazenda B - Regiao Centro, GO', '2026-02-05');
INSERT INTO tb_talhao (nome, cultura, area_hectares, localizacao, data_cadastro) VALUES ('Talhao Sul 1', 'Arroz', 180.0, 'Fazenda C - Regiao Sul, RS', '2026-02-20');

INSERT INTO tb_alerta_climatico (tipo_alerta, severidade, impacto_estimado, data_evento, status, talhao_id) VALUES ('Risco de Seca', 8, 6.5, '2026-05-26', 'EM_ANALISE', 1);
INSERT INTO tb_alerta_climatico (tipo_alerta, severidade, impacto_estimado, data_evento, status, talhao_id) VALUES ('Temperatura Elevada', 6, 4.2, '2026-05-25', 'MONITORANDO', 2);
INSERT INTO tb_alerta_climatico (tipo_alerta, severidade, impacto_estimado, data_evento, status, talhao_id) VALUES ('Anomalia Climatica', 9, 7.8, '2026-05-26', 'EM_ANALISE', 3);
INSERT INTO tb_alerta_climatico (tipo_alerta, severidade, impacto_estimado, data_evento, status, talhao_id) VALUES ('Tempestade Severa', 10, 9.1, '2026-05-26', 'CRITICO', 4);