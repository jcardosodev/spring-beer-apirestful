-- Inserting into 'clientes' table
INSERT INTO clientes (cpf, data_nascimento, email, nome_completo, telefone)
VALUES
('123.456.789-00', '1980-05-15', 'joao@example.com', 'João da Silva', '(11) 99999-8888'),
('987.654.321-00', '1992-08-25', 'maria@example.com', 'Maria Oliveira', '(21) 98888-7777'),
('111.222.333-44', '1975-12-05', 'carlos@example.com', 'Carlos Pereira', '(31) 97777-6666'),
('222.333.444-55', '1985-04-10', 'ana@example.com', 'Ana Costa', '(11) 94444-5555'),
('333.444.555-66', '1990-03-20', 'luis@example.com', 'Luis Souza', '(21) 93333-4444'),
('444.555.666-77', '1970-02-15', 'juliana@example.com', 'Juliana Mendes', '(31) 92222-3333'),
('555.666.777-88', '1995-01-30', 'roberto@example.com', 'Roberto Braga', '(11) 91111-2222'),
('666.777.888-99', '1982-07-22', 'paula@example.com', 'Paula Lima', '(21) 90000-1111'),
('777.888.999-00', '1988-11-11', 'fernando@example.com', 'Fernando Rocha', '(31) 98888-9999'),
('888.999.000-11', '1976-10-10', 'marcia@example.com', 'Marcia Alves', '(11) 97777-8888'),
('999.000.111-22', '1989-09-09', 'andre@example.com', 'Andre Martins', '(21) 96666-7777'),
('000.111.222-33', '1991-08-08', 'patricia@example.com', 'Patricia Dias', '(31) 95555-6666'),
('111.222.333-44', '1983-07-07', 'marcelo@example.com', 'Marcelo Costa', '(11) 94444-5555'),
('222.333.444-55', '1974-06-06', 'luciana@example.com', 'Luciana Ribeiro', '(21) 93333-4444'),
('333.444.555-66', '1996-05-05', 'ricardo@example.com', 'Ricardo Silva', '(31) 92222-3333'),
('444.555.666-77', '1981-04-04', 'flavia@example.com', 'Flavia Santos', '(11) 91111-2222'),
('555.666.777-88', '1987-03-03', 'bruno@example.com', 'Bruno Fernandes', '(21) 90000-1111'),
('666.777.888-99', '1993-02-02', 'mariana@example.com', 'Mariana Ferreira', '(31) 98888-9999'),
('777.888.999-00', '1990-01-01', 'joana@example.com', 'Joana Carvalho', '(11) 97777-8888'),
('888.999.000-11', '1986-12-12', 'gustavo@example.com', 'Gustavo Monteiro', '(21) 96666-7777');

-- Inserting into 'enderecos' table
INSERT INTO enderecos (cep, complemento, numero)
VALUES
('28615080', 'final da rua', '48'),
('28615080', 'servidao', '193'),
('28895371', 'muro verde', '22'),
('28615080', 'Apt 2', '1');

-- Inserting into 'produtos' table
INSERT INTO produtos (data_cadastro, descricao, categoria_produto, imagem, nome_produto, quantidade_estoque, valor_unitario)
VALUES
('2023-01-01', 'Sanitizador Pac 200 Pó 300g', 'EQUIPAMENTOS', 'sanitizador.jpg', 'Sanitizador Pac 200', 4800, 30.00),
('2023-01-02', 'Refratômetro Brix 0-32%', 'EQUIPAMENTOS', 'refratometro.jpg', 'Refratômetro BRIX', 16900, 150.00),
('2023-01-03', 'Torneira Plástica 28E', 'EQUIPAMENTOS', 'torneira.jpg', 'Torneira Plástica', 2480, 10.00),
('2023-01-04', 'Garrafa PET Growler 1L Ambar', 'EQUIPAMENTOS', 'growler.jpg', 'Garrafa PET Growler', 300, 5.00),
('2023-01-05', 'Filtro Bacteriológico para Aeração Mosto', 'EQUIPAMENTOS', 'filtro.jpg', 'Filtro Bacteriológico', 850, 20.00),
('2023-01-06', 'Malte Agrária Pilsen - 1KG', 'MALTES', 'malte_agraria.jpg', 'Malte Agrária Pilsen', 940, 8.00),
('2023-01-07', 'Malte Château Crystal', 'MALTES', 'malte_chateau_crystal.jpg', 'Malte Château Crystal', 1700, 10.00),
('2023-01-08', 'Malte Maris Otter Pauls Malt', 'MALTES', 'malte_maris_otter.jpg', 'Malte Maris Otter', 1780, 12.00),
('2023-01-09', 'Extrato de Malte Dry Brew - 100% Malte Pilsen', 'MALTES', 'extrato_malte.jpg', 'Extrato de Malte Dry Brew', 5990, 25.00),
('2023-01-10', 'Malte Château Munich', 'MALTES', 'malte_chateau_munich.jpg', 'Malte Château Munich', 1280, 9.00),
('2023-01-11', 'Lúpulo Barth Haas Citra - 50GRS', 'LUPULOS', 'lupulo_citra.jpg', 'Lúpulo Citra', 2150, 15.00),
('2023-01-12', 'Lúpulo Barth Haas Cascade - 50GRS', 'LUPULOS', 'lupulo_cascade.jpg', 'Lúpulo Cascade', 1350, 12.00),
('2023-01-13', 'Lúpulo Barth Haas Amarillo - 50GRS', 'LUPULOS', 'lupulo_amarillo.jpg', 'Lúpulo Amarillo', 2190, 14.00),
('2023-01-14', 'Lúpulo Barth Haas Mosaic - 50GRS', 'LUPULOS', 'lupulo_mosaic.jpg', 'Lúpulo Mosaic', 1760, 16.00);


INSERT INTO itempedidos (percentual_desconto, valor_unitario, quantidade)
VALUES
(10.00, 300.00, 2),
(5.00, 150.00, 1),
(0.00, 10.00, 10),
(15.00, 50.00, 20),
(10.00, 20.00, 3),
(5.00, 80.00, 5),
(0.00, 1000.00, 4),
(15.00, 122.00, 6),
(10.00, 25.00, 2),
(5.00, 95.00, 3),
(0.00, 15.00, 4),
(15.00, 120.00, 2),
(10.00, 14.00, 5),
(5.00, 169.00, 3),
(0.00, 203.00, 4),
(15.00, 225.00, 2),
(10.00, 18.00, 5),
(5.00, 19.00, 3),
(0.00, 21.00, 4),
(15.00, 20.00, 2);
