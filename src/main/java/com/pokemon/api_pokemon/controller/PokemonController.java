package com.pokemon.api_pokemon.controller;

import com.pokemon.api_pokemon.dtos.CreatePokemonDto;
import com.pokemon.api_pokemon.dtos.PokemonResponseDto;
import com.pokemon.api_pokemon.dtos.UpdatePokemonDto;
import com.pokemon.api_pokemon.repositories.TypePokemonRepository;
import com.pokemon.api_pokemon.service.PokemonServiceImp;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/pokemons")
public class PokemonController {

    private final PokemonServiceImp pokemonService;
    private final TypePokemonRepository typePokemonRepository;

    @Operation(
            summary = "Busca todos os Pokémon",
            description = "Retorna a lista completa de Pokémon cadastrados."
    )
    @ApiResponse(
            responseCode = "200",
            description = "Lista retornada com sucesso"
    )

    @GetMapping
    public ResponseEntity<List<PokemonResponseDto>> getAll() {
        return ResponseEntity.ok(pokemonService.getAll());
    }

    @Operation(
            summary = "Busca um Pokémon pelo ID",
            description = "Retorna um Pokémon específico usando seu ID."
    )
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Pokémon encontrado"),
            @ApiResponse(responseCode = "404", description = "Pokémon não encontrado")
    })

    @GetMapping("/id/{id}")
    public ResponseEntity<PokemonResponseDto> getById(@PathVariable Long id) {
        return ResponseEntity.ok(pokemonService.getPokemonByID(id));
    }

    @PostMapping
    public ResponseEntity<Void> addPokemon(@RequestBody CreatePokemonDto dto) {
        pokemonService.addPokemon(dto);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<PokemonResponseDto> updatePokemon(
            @PathVariable Long id,
            @RequestBody UpdatePokemonDto dto) {

        return ResponseEntity.ok(pokemonService.updatePokemon(id, dto));
    }

    @GetMapping("/type/{type}")
    public ResponseEntity<List<PokemonResponseDto>> getByType(@PathVariable String type) {
        List<PokemonResponseDto> pokemons = pokemonService.getPokemonByTypeName(type);
        return ResponseEntity.ok(pokemons);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> removePokemon (@PathVariable Long id){
        pokemonService.deletePokemon(id);
        return ResponseEntity.noContent().build();
    }
}
