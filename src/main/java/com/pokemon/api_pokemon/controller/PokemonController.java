package com.pokemon.api_pokemon.controller;

import com.pokemon.api_pokemon.entities.Pokemon;
import com.pokemon.api_pokemon.services.PokemonService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/pokemons")
public class PokemonController {

    private final PokemonService pokemonService;

    @GetMapping
    public ResponseEntity<List<Pokemon>> getAll() {
        List<Pokemon> pokemons = pokemonService.getAll();
        return ResponseEntity.ok(pokemons);
    }

    @PostMapping
    public ResponseEntity<Void> addPokemon (@RequestBody Pokemon pokemon){
        pokemonService.addPokemon(pokemon);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> removePokemon (@PathVariable Long id){
        pokemonService.deletePokemon(id);
        return ResponseEntity.noContent().build();
    }
}
