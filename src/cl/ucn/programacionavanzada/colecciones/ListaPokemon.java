package cl.ucn.programacionavanzada.colecciones;

import cl.ucn.programacionavanzada.model.Pokemon;

import java.util.Scanner;

public class ListaPokemon {
    private NodoPokemon cabeza;

    private NodoPokemon cola;

    private int cantidadPokemones;

    /**
     * Constructor de la lista de pokemones
     */
    public ListaPokemon() {
        this.cabeza = null;
        this.cola = null;
        this.cantidadPokemones = 0;
    }

    /**
     * Agregar un pokemon a lista
     * @param nuevoPokemon a agregar
     * @return true si se agrego correctamente, false de lo contrario
     * pre-requisito: el pokemon nuevo NO exista en la lista
     */

    public void agregarPokemon(Pokemon nuevoPokemon){
        int idNuevoPokemon = nuevoPokemon.getId();
        NodoPokemon nuevoNodo = new NodoPokemon(nuevoPokemon);
        this.cantidadPokemones++;
        if (this.cabeza == null){//la lista esta vacia
            this.cabeza = nuevoNodo;
            this.cola = nuevoNodo;
        }
        else {//lista no vacia, se inserta al principio (ozquierda)
            nuevoNodo.setNodoAnterior(null);
            nuevoNodo.setNodoSiguiente(this.cabeza);
            this.cabeza.setNodoAnterior(nuevoNodo);
            this.cabeza = nuevoNodo;
        }
    }

    /**
     * Desplegar los datos de un pokemon
     */
    public void desplegarPokemon(){
        String mensaje = "";
        System.out.println("entro a desplegarPokemon");
        NodoPokemon nodoActual = this.cabeza;
        System.out.println("Cantidad pokemons " + this.cantidadPokemones);
        while (nodoActual != null) {
            mensaje = "id: " + nodoActual.getPokemon().getId();
            mensaje = mensaje + ", nombre: " + nodoActual.getPokemon().getNombre();
            mensaje = mensaje + ", etapa: " + nodoActual.getPokemon().getEtapa();
            mensaje = mensaje + ", evo.sig: " + nodoActual.getPokemon().getEvolucionSiguiente();
            mensaje = mensaje + ", evo.prev: " + nodoActual.getPokemon().getEvolucionPrevia();
            mensaje = mensaje + ", tipo Uno: " + nodoActual.getPokemon().getTipoUno();
            mensaje = mensaje + ", tipo Dos: " + nodoActual.getPokemon().getTipoDos();

            System.out.println(mensaje);
            nodoActual = nodoActual.getNodoSiguiente();
        }
    }

    /**
     * Desplegar datos de un pokemon por el tipo
     * @param tipoBuscado tipo elementar a buscar
     */
    public void desplegarPokemonPorTipo(String tipoBuscado){
        String mensaje = "";
        System.out.println("entro a desplegarPokemon");
        NodoPokemon nodoActual = this.cabeza;
        System.out.println("Cantidad pokemons " + this.cantidadPokemones);
        while (nodoActual != null) {
            String tipoUnoActual = nodoActual.getPokemon().getTipoUno();
            String tipoDosActual = nodoActual.getPokemon().getTipoDos();

            mensaje = "id: " + nodoActual.getPokemon().getId();
            mensaje = mensaje + ", nombre: " + nodoActual.getPokemon().getNombre();
            mensaje = mensaje + ", etapa: " + nodoActual.getPokemon().getEtapa();
            mensaje = mensaje + ", evo.sig: " + nodoActual.getPokemon().getEvolucionSiguiente();
            mensaje = mensaje + ", evo.prev: " + nodoActual.getPokemon().getEvolucionPrevia();
            mensaje = mensaje + ", tipo Uno: " + nodoActual.getPokemon().getTipoUno();
            mensaje = mensaje + ", tipo Dos: " + nodoActual.getPokemon().getTipoDos();

            if (tipoUnoActual.equalsIgnoreCase(tipoBuscado) || tipoDosActual.equalsIgnoreCase(tipoBuscado)){
                System.out.println(mensaje);
            }
            nodoActual = nodoActual.getNodoSiguiente();
        }
    }

    /**
     * Desplegar datos de un pokemon que este en primera evolucion
     */
    public void desplegarPokemonPorPrimeraEvolucion(){
        String mensaje = "";
        System.out.println("entro a desplegarPokemon");
        NodoPokemon nodoActual = this.cabeza;
        System.out.println("Cantidad pokemons " + this.cantidadPokemones);
        while (nodoActual != null) {
            String etapaActual = nodoActual.getPokemon().getEtapa();

            mensaje = "id: " + nodoActual.getPokemon().getId();
            mensaje = mensaje + ", nombre: " + nodoActual.getPokemon().getNombre();
            mensaje = mensaje + ", etapa: " + nodoActual.getPokemon().getEtapa();
            mensaje = mensaje + ", evo.sig: " + nodoActual.getPokemon().getEvolucionSiguiente();
            mensaje = mensaje + ", evo.prev: " + nodoActual.getPokemon().getEvolucionPrevia();
            mensaje = mensaje + ", tipo Uno: " + nodoActual.getPokemon().getTipoUno();
            mensaje = mensaje + ", tipo Dos: " + nodoActual.getPokemon().getTipoDos();

            if (etapaActual.equalsIgnoreCase("Primera Evolucion")){
                System.out.println(mensaje);
            }
            nodoActual = nodoActual.getNodoSiguiente();
        }
    }

    /**
     * Buscar el pokemon con el id a buscar
     * @param idBuscado id a buscar
     * @return el nodo con el pokemon o null si es que no esta la id
     */
    public NodoPokemon buscarId(int idBuscado){
        NodoPokemon nodoIndice = this.cabeza;
        int idIndice;
        NodoPokemon posicionNodo = null;
        boolean nodoEncontrado = false;
        //la lista NO esta vacia
        while (nodoIndice != null && nodoEncontrado == false){
            idIndice = nodoIndice.getPokemon().getId();
            if (idIndice == idBuscado){
                nodoEncontrado = true;
                posicionNodo = nodoIndice;
            }
            nodoIndice = nodoIndice.getNodoSiguiente();
        }
        return posicionNodo;
    }

    /**
     * Buscar el pokemon con el nombre a buscar
     * @param nombreBuscado nombre del pokemon a buscar
     * @return nodo con el pokemon o null si el nombre no existe
     */
    public NodoPokemon buscarNombre(String nombreBuscado){
        NodoPokemon nodoIndice = this.cabeza;
        String nombreIndice;
        NodoPokemon posicionNodo = null;
        boolean nodoEncontrado = false;
        //la lista NO esta vacia
        while (nodoIndice != null && nodoEncontrado == false){
            nombreIndice = nodoIndice.getPokemon().getNombre();
            if (nombreIndice.equalsIgnoreCase(nombreBuscado)){
                nodoEncontrado = true;
                posicionNodo = nodoIndice;
            }
            nodoIndice = nodoIndice.getNodoSiguiente();
        }
        return posicionNodo;
    }
}
