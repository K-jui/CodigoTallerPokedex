package cl.ucn.programacionavanzada.colecciones;

import cl.ucn.programacionavanzada.model.Pokemon;

public interface SistemaPokedex {
    /**
     * Nombre: agregarPokemon(Pokemon nuevoPokemon)
     * Descripcion: agrega un nuevo pokemon al sistema
     * Pre-requisito: debe de crearse el pokemon a agregar
     * Post-condicion: se agrega a la lista del sistema el nuevo pokemon
     */
    void agregarPokemon(Pokemon nuevoPokemon);

    /**
     * Nombre: desplegarTodosLosPokemones()
     * Descripcion: despliega todos los pokemones con su datos
     * Pre-condicion: la lista debe tener pokemones
     * Post-condicion: se despliegan los datos de todos los pokemon
     */
    void desplegarTodosLosPokemones();

    /**
     * Nombre: desplegarPorTipo(String tipoBuscar)
     * Descripcion: despliega los pokemon que coincidan con el tipo elemental ingresado
     * Pre-condicion: deben haber pokemones en el sistema
     * Post-condicion: se despliegan los datos de los pokemones que coincidan con el tipo
     */
    void desplegarPorTipo(String tipoBuscar);

    /**
     * Nombre: desplegarPorPrimeraEvolucion()
     * Descripcion: despliega los pokemones que esten en la etapa de primera evolucion
     * Pre-condicion: deben haber pokemones en el sistema
     * Post-condicion:
     */
    void desplegarPorPrimeraEvolucion();

    /**
     * Nombre: buscarId(int idBuscado)
     * Descripcion: busca un id ingresado en el sistema, si lo encuentra, despliega los datos del pokemon que coincide ese id
     * Pre-condicion: deben haber pokemones en el sistema
     * Post-condicion: se despliegan los datos del pokemon que coincide el id ingresado
     */
    NodoPokemon buscarId(int idBuscado);

    /**
     * Nombre: buscarNombre(String nombreBuscado)
     * Descripcion: busca un nombre ingresado en el sistema, si lo encuentra, despliega los datos del pokemon que coincide ese nombre
     * Pre-condicion: deben haber pokemones en el sistema
     * Post-condicion: se despliegan los datos del pokemon que coincide el nombre ingresado
     */
    NodoPokemon buscarNombre(String nombreBuscado);
}
