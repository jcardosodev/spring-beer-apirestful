-- Create sequences for primary key defaults
CREATE SEQUENCE IF NOT EXISTS clientes_id_seq;
CREATE SEQUENCE IF NOT EXISTS enderecos_id_seq;
CREATE SEQUENCE IF NOT EXISTS itempedidos_id_seq;
CREATE SEQUENCE IF NOT EXISTS pedidos_id_seq;
CREATE SEQUENCE IF NOT EXISTS produtos_id_seq;

-- Table: public.enderecos

-- DROP TABLE IF EXISTS public.enderecos;

CREATE TABLE IF NOT EXISTS public.enderecos
(
    id BIGINT NOT NULL DEFAULT nextval('enderecos_id_seq'::regclass),
    bairro VARCHAR(255),
    cep VARCHAR(255),
    cidade VARCHAR(255),
    complemento VARCHAR(255),
    numero INTEGER NOT NULL,
    rua VARCHAR(255),
    uf VARCHAR(255),
    CONSTRAINT enderecos_pkey PRIMARY KEY (id)
);

ALTER TABLE IF EXISTS public.enderecos
    OWNER TO postgres;

-- Table: public.clientes

-- DROP TABLE IF EXISTS public.clientes;

CREATE TABLE IF NOT EXISTS public.clientes
(
    id BIGINT NOT NULL DEFAULT nextval('clientes_id_seq'::regclass),
    cpf VARCHAR(255),
    data_nascimento DATE,
    email VARCHAR(255),
    nome_completo VARCHAR(255),
    telefone VARCHAR(255),
    endereco_id BIGINT,
    CONSTRAINT clientes_pkey PRIMARY KEY (id),
    CONSTRAINT uk_endereco_id UNIQUE (endereco_id),
    CONSTRAINT fk_endereco FOREIGN KEY (endereco_id)
        REFERENCES public.enderecos (id)
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
);

ALTER TABLE IF EXISTS public.clientes
    OWNER TO postgres;

-- Table: public.produtos

-- DROP TABLE IF EXISTS public.produtos;

CREATE TABLE IF NOT EXISTS public.produtos
(
    id BIGINT NOT NULL DEFAULT nextval('produtos_id_seq'::regclass),
    categoria_produto VARCHAR(255),
    data_cadastro DATE,
    descricao VARCHAR(255),
    imagem VARCHAR(255),
    nome_produto VARCHAR(255),
    quantidade_estoque INTEGER NOT NULL,
    valor_unitario DOUBLE PRECISION,
    CONSTRAINT produtos_pkey PRIMARY KEY (id),
    CONSTRAINT produtos_categoria_produto_check CHECK (categoria_produto = ANY (ARRAY['EQUIPAMENTOS', 'MALTES', 'LUPULOS', 'FERMENTO', 'KITSRECEITAS']))
);

ALTER TABLE IF EXISTS public.produtos
    OWNER TO postgres;

-- Table: public.pedidos

-- DROP TABLE IF EXISTS public.pedidos;

CREATE TABLE IF NOT EXISTS public.pedidos
(
    id BIGINT NOT NULL DEFAULT nextval('pedidos_id_seq'::regclass),
    data_entrega DATE,
    data_envio DATE,
    data_pedido DATE,
    status VARCHAR(255),
    valor_total DOUBLE PRECISION,
    cliente_id BIGINT,
    CONSTRAINT pedidos_pkey PRIMARY KEY (id),
    CONSTRAINT fk_cliente FOREIGN KEY (cliente_id)
        REFERENCES public.clientes (id)
        ON UPDATE NO ACTION
        ON DELETE NO ACTION,
    CONSTRAINT pedidos_status_check CHECK (status = ANY (ARRAY['PEDIDORECEBIDO', 'PEDIDOEMSEPARACAO', 'PEDIDOCOLETADO', 'EMTRANSPORTE', 'PEDIDOENTREGUE', 'PEDIDOCANCELADO']))
);

ALTER TABLE IF EXISTS public.pedidos
    OWNER TO postgres;

-- Table: public.itempedidos

-- DROP TABLE IF EXISTS public.itempedidos;

CREATE TABLE IF NOT EXISTS public.itempedidos
(
    id BIGINT NOT NULL DEFAULT nextval('itempedidos_id_seq'::regclass),
    percentual_desconto DOUBLE PRECISION,
    quantidade INTEGER NOT NULL,
    valor_bruto DOUBLE PRECISION,
    valor_liquido DOUBLE PRECISION,
    valor_unitario DOUBLE PRECISION,
    pedido_id BIGINT,
    produto_id BIGINT,
    CONSTRAINT itempedidos_pkey PRIMARY KEY (id),
    CONSTRAINT fk_pedido FOREIGN KEY (pedido_id)
        REFERENCES public.pedidos (id)
        ON UPDATE NO ACTION
        ON DELETE NO ACTION,
    CONSTRAINT fk_produto FOREIGN KEY (produto_id)
        REFERENCES public.produtos (id)
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
);

ALTER TABLE IF EXISTS public.itempedidos
    OWNER TO postgres;
