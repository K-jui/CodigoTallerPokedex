package cl.ucn.programacionavanzada.colecciones;

import cl.ucn.programacionavanzada.model.Pokemon;

public class NodoPokemon {
    private Pokemon pokemon;
    private NodoPokemon nodoSiguiente;
    private NodoPokemon nodoAnterior;

    /**
     * El constructor del nodoPokemon
     * @param pokemon el pokemon que contiene el nodo
     */
    public NodoPokemon(Pokemon pokemon) {
        //validacion del pokemon NO existente o null
        if (pokemon == null){
            System.out.println("Pokemon NULO");
        }
        this.pokemon = pokemon;
        this.nodoAnterior = null;
        this.nodoSiguiente = null;
    }

    public Pokemon getPokemon() {
        return this.pokemon;
    }

    public NodoPokemon getNodoSiguiente() {
        return this.nodoSiguiente;
    }

    public NodoPokemon getNodoAnterior() {
        return this.nodoAnterior;
    }

    public void setPokemon(Pokemon pokemon) {
        this.pokemon = pokemon;
    }

    public void setNodoSiguiente(NodoPokemon nodoSiguiente) {
        this.nodoSiguiente = nodoSiguiente;
    }

    public void setNodoAnterior(NodoPokemon nodoAnterior) {
        this.nodoAnterior = nodoAnterior;
    }
}
