create table projeto (
	id BIGSERIAL PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    descricao TEXT,
    data_inicio DATE,
    data_previsao_termino DATE,
    data_real_termino DATE,
    orcamento_total NUMERIC(12,2),
    gerente_responsavel BIGINT REFERENCES pessoa(id),
    empresa_id BIGINT REFERENCES empresa(id),
    risco VARCHAR(20),
    status VARCHAR(20)
);