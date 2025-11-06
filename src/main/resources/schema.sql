CREATE TABLE tipo (
    id BIGSERIAL PRIMARY KEY,
    nome VARCHAR(50) NOT NULL UNIQUE
);

CREATE TABLE pokemon (
    id BIGSERIAL PRIMARY KEY,
    pokemon VARCHAR(100) NOT NULL,
    altura FLOAT,
    peso FLOAT
);

CREATE TABLE pokemon_tipo (
    pokemon_id BIGINT NOT NULL,
    tipo_id BIGINT NOT NULL,
    PRIMARY KEY (pokemon_id, tipo_id),
    FOREIGN KEY (pokemon_id) REFERENCES pokemon(id),
    FOREIGN KEY (tipo_id) REFERENCES tipo(id)
);
