-- Inserindo tipos
INSERT INTO tipo (id, nome) VALUES (1, 'FIRE');
INSERT INTO tipo (id, nome) VALUES (2, 'WATER');
INSERT INTO tipo (id, nome) VALUES (3, 'GRASS');

-- Inserindo pokemons
INSERT INTO pokemon (id, pokemon, altura, peso) VALUES (1, 'Charmander', 0.6, 8.5);
INSERT INTO pokemon (id, pokemon, altura, peso) VALUES (2, 'Squirtle', 0.5, 9.0);
INSERT INTO pokemon (id, pokemon, altura, peso) VALUES (3, 'Bulbasaur', 0.7, 6.9);

-- Ligando pokemons aos tipos (tabela intermediária ManyToMany)
INSERT INTO pokemon_tipo (pokemon_id, tipo_id) VALUES (1, 1); -- Charmander -> FIRE
INSERT INTO pokemon_tipo (pokemon_id, tipo_id) VALUES (2, 2); -- Squirtle -> WATER
INSERT INTO pokemon_tipo (pokemon_id, tipo_id) VALUES (3, 3); -- Bulbasaur -> GRASS
