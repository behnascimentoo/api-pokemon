package com.pokemon.api_pokemon.service;

import com.pokemon.api_pokemon.dtos.PokemonResponseDto;
import com.pokemon.api_pokemon.entities.Pokemon;
import com.pokemon.api_pokemon.entities.TypeName;
import com.pokemon.api_pokemon.entities.TypePokemon;
import com.pokemon.api_pokemon.mappers.PokemonMapper;
import com.pokemon.api_pokemon.repositories.PokemonRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class PokemonServiceTest {
    @Mock
    private PokemonRepository pokemonRepository;

    @Mock
    private PokemonMapper pokemonMapper; // você precisa mockar o mapper

    @InjectMocks
    private PokemonService pokemonService;

    @Test
    void testGetPokemonByID() {
        TypePokemon planta = new TypePokemon(null, TypeName.PLANTA);
        Pokemon pikachu = new Pokemon(1L, "Pikachu", planta);

        PokemonResponseDto pikachuDto = new PokemonResponseDto(
                1L,
                "Pikachu",
                0.4f,
                6.0f,
                new HashSet<>(Arrays.asList("AGUA"))
        );
        when(pokemonRepository.findById(1L)).thenReturn(Optional.of(pikachu));

        when(pokemonMapper.toDto(pikachu)).thenReturn(pikachuDto);

        PokemonResponseDto result = pokemonService.getPokemonByID(1L);

        assertNotNull(result);
        assertEquals("Pikachu", result.name());
        assertTrue(result.typePokemon().contains("Electric"));
    }
}

