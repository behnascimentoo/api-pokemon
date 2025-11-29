package com.pokemon.api_pokemon.controller;

import com.pokemon.api_pokemon.dtos.CreatePokemonDto;
import com.pokemon.api_pokemon.dtos.PokemonResponseDto;
import com.pokemon.api_pokemon.dtos.UpdatePokemonDto;
import com.pokemon.api_pokemon.repositories.TypePokemonRepository;
import com.pokemon.api_pokemon.services.PokemonServiceImp;
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

    @GetMapping
    public ResponseEntity<List<PokemonResponseDto>> getAll() {
        return ResponseEntity.ok(pokemonService.getAll());
    }

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
