package com.pokemon.api_pokemon.services;

import com.pokemon.api_pokemon.entities.Pokemon;
import com.pokemon.api_pokemon.repositories.PokemonRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class PokemonService {

    private final PokemonRepository pokemonRepository;

    public void addPokemon( Pokemon pokemon){
        pokemon = pokemonRepository.save(pokemon);
    }
    public List<Pokemon> getAll() {
        return pokemonRepository.findAll();
    }

    public void deletePokemon(Long id){
        pokemonRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("Pokemom não encontrado")) ;
        pokemonRepository.deleteById(id);
    }
}
