package com.pokemon.api_pokemon.repository;

import com.pokemon.api_pokemon.entities.Pokemon;
import com.pokemon.api_pokemon.entities.TypeName;
import com.pokemon.api_pokemon.entities.TypePokemon;
import com.pokemon.api_pokemon.repositories.PokemonRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
@ActiveProfiles("test")
public class PokemonRepositoryIntegrationTest {
    @Autowired
    private PokemonRepository pokemonRepository;

    @Test
    void testSaveAndFindPokemon() {
        TypePokemon fogo = new TypePokemon();
        fogo.setName(TypeName.valueOf("FOGO"));
        Pokemon charmander = new Pokemon(null, "Charmander", fogo);
        pokemonRepository.save(charmander);
        pokemonRepository.save(charmander);

        Pokemon found = pokemonRepository.findById(charmander.getId()).orElse(null);

        assertNotNull(found);
        assertEquals("Charmander", found.getName());
    }
}
