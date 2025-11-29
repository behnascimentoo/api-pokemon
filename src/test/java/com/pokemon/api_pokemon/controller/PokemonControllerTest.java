package com.pokemon.api_pokemon.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.pokemon.api_pokemon.dtos.CreatePokemonDto;
import com.pokemon.api_pokemon.dtos.PokemonResponseDto;
import com.pokemon.api_pokemon.entities.TypeName;
import com.pokemon.api_pokemon.service.PokemonService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.HashSet;
import java.util.Set;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(PokemonController.class)
public class PokemonControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @MockBean
    private PokemonService pokemonService;

    @Test
    void testGetPokemonById() throws Exception {
        PokemonResponseDto pikachuDto = new PokemonResponseDto(
                1L,
                "Pikachu",
                6.0f,
                0.4f,
                Set.of("Electric")
        );

        when(pokemonService.getPokemonByID(1L)).thenReturn(pikachuDto);

        mockMvc.perform(get("/pokemons/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(1))
                .andExpect(jsonPath("$.name").value("Pikachu"))
                .andExpect(jsonPath("$.typePokemon[0]").value("Electric"));
    }

    @Test
    void testCreatePokemon() throws Exception {
        Set<TypeName> types = new HashSet<>();
        types.add(TypeName.FOGO);

        CreatePokemonDto charmanderDto = new CreatePokemonDto(
                "Charmander",
                types,
                8.5f,
                0.6f
        );

        doNothing().when(pokemonService).addPokemon(any(CreatePokemonDto.class));

        mockMvc.perform(post("/pokemons")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(charmanderDto)))
                .andExpect(status().isCreated());
    }
}