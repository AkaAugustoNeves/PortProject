CREATE TABLE projeto_pessoa (
    id BIGSERIAL PRIMARY KEY,
    pessoa_id BIGINT REFERENCES pessoa(id),
    projeto_id BIGINT REFERENCES projeto(id)
);