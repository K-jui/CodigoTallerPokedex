package cl.ucn.programacionavanzada.colecciones;

import cl.ucn.programacionavanzada.model.Pokemon;

public class SistemaPokedexImpl implements SistemaPokedex{
    private ListaPokemon pokemones;

    /**
     * El constructor del sistemaPokedexImpl
     */
    public SistemaPokedexImpl() {
        this.pokemones = new ListaPokemon();
    }

    @Override
    public void agregarPokemon(Pokemon nuevoPokemon) {
        pokemones.agregarPokemon(nuevoPokemon);
    }

    @Override
    public void desplegarTodosLosPokemones() {
        pokemones.desplegarPokemon();
    }

    @Override
    public void desplegarPorTipo(String tipoBuscar) {
        pokemones.desplegarPokemonPorTipo(tipoBuscar);
    }

    @Override
    public void desplegarPorPrimeraEvolucion() {
        pokemones.desplegarPokemonPorPrimeraEvolucion();
    }

    @Override
    public NodoPokemon buscarId(int idBuscado) {
        NodoPokemon pokemonBuscar = pokemones.buscarId(idBuscado);
        return pokemonBuscar;
    }

    @Override
    public NodoPokemon buscarNombre(String nombreBuscado) {
        NodoPokemon pokemonBuscar = pokemones.buscarNombre(nombreBuscado);
        return pokemonBuscar;
    }


}
