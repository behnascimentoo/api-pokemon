package com.pokemon.api_pokemon.dtos;

import com.pokemon.api_pokemon.entities.TypeName;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.util.Set;

public record CreatePokemonDto(
        @NotBlank(message = "Nome não pode estar vazio")
        String name,

        @NotBlank(message = "Tipo não pode estar vazio")
        Set<TypeName> typePokemon,

        @NotNull(message = "Altura não pode estar vazio")
        @Size(min = 3, max = 4)
        Float hight,

        @NotNull(message = "Peso não pode estar vazio")
        @Size(min = 2, max = 5)
        Float wight


) {}
