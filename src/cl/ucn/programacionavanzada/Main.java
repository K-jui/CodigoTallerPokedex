package cl.ucn.programacionavanzada;

import cl.ucn.programacionavanzada.colecciones.NodoPokemon;
import cl.ucn.programacionavanzada.colecciones.SistemaPokedexImpl;
import cl.ucn.programacionavanzada.model.Pokemon;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

/**
 * Taller 4: Pokedex Kanto
 * @author Dantte Márquez y Rodrigo Juica
 */

public class Main {
    /**
     * El main
     * @param args a usar
     * @throws IOException
     */

    public static void main(String[] args) throws IOException {
        SistemaPokedexImpl nuevaPokedex = new SistemaPokedexImpl();


        String nombreArchivoEntrada = "kanto.txt";
        lecturaArchivoPokemon(nombreArchivoEntrada, nuevaPokedex);
        boolean menuActivo = true;
        while (menuActivo){
            System.out.println("""
                Pokedex Kanto.
                ¿Que quiere ver?
                [1] Desplegar pokemones por rango de numeros id
                [2] Desplegar todos los pokemones
                [3] Desplegar pokemones segun un tipo
                [4] Desplegar pokemones con primera evolucion
                [5] Busqueda personalizada
                [6] Cerrar pokedex
                Inserte una opcion:
                """);
            Scanner opcionMenu = new Scanner(System.in);
            String opcionElegida = opcionMenu.nextLine();
            boolean esNumerico;
            try {
                Integer.parseInt(opcionElegida);
                esNumerico = true;
            } catch (NumberFormatException excepcion) {
                esNumerico = false;
            }
            if (esNumerico){
                int opcionNumericaElegida = Integer.parseInt(opcionElegida);
                if (opcionNumericaElegida == 1){
                    System.out.println("Desplegando pokemones por rango de numeros");
                    responderConsultaUno(nuevaPokedex);
                }
                else if (opcionNumericaElegida == 2){
                    System.out.println("Desplegando todos los pokemones");
                    responderConsultaDos(nuevaPokedex);
                }
                else if (opcionNumericaElegida == 3){
                    System.out.println("Desplegando pokemones por tipo");
                    responderConsultaTres(nuevaPokedex);
                }
                else if (opcionNumericaElegida == 4){
                    System.out.println("Desplegando pokemones con primera evolucion");
                    responderConsultaCuatro(nuevaPokedex);
                }
                else if (opcionNumericaElegida == 5){
                    System.out.println("Desplegando busqueda personalizada");
                    responderConsultaCinco(nuevaPokedex);
                }
                else if (opcionNumericaElegida == 6){
                    System.out.println("<<<Cerrando pokedex>>>");
                    menuActivo = false;
                }
                else {
                    System.out.println("Opcion no valida");
                }
            }
            else {
                System.out.println("No se permiten letras");
            }
        }
    }

    /**
     * Respuesta para opcion uno del menu (desplegar pokemons desde un tipo de rango id crecientemente)
     * @param sistemaPokedex a utilizar
     */
    public static void responderConsultaUno(SistemaPokedexImpl sistemaPokedex){
        ordenarCrecientementePorId(sistemaPokedex);
        desplegarTodosLosPokemones(sistemaPokedex);

    }

    /**
     * Respuesta para opcion dos del menu (desplegar todos los pokemons de la pokedex alfabeticamente)
     * @param sistemaPokedex a utilizar
     */
    public static void responderConsultaDos(SistemaPokedexImpl sistemaPokedex){
        ordenarAlfabeticamentePorNombre(sistemaPokedex);
        desplegarTodosLosPokemones(sistemaPokedex);

    }

    /**
     * Respuesta para la opcion tres del menu (desplegar pokemons del tipo ingresado)
     * @param sistemaPokedex a utilizar
     */
    public static void responderConsultaTres(SistemaPokedexImpl sistemaPokedex){
        Scanner opcionTipo = new Scanner(System.in);
        System.out.println("Ingrese el tipo a desplegar: ");
        String tipoBuscado = opcionTipo.nextLine();
        //se debe validar que el tipo exista
        desplegarListaPorTipo(sistemaPokedex, tipoBuscado);
    }

    /**
     * Respuesta para la opcion cuatro del menu (desplegar pokemons de primera evolucion decrecientemente)
     * @param sistemaPokedex a utilizar
     */
    public static void responderConsultaCuatro(SistemaPokedexImpl sistemaPokedex){

        ordenarDecrecientementePorId(sistemaPokedex);
        desplegarListaPrimeraEvolucion(sistemaPokedex);

    }

    /**
     * Respuesta para la opcion cinco del menu (busqueda personalizada)
     * @param sistemaPokedex a utilizar
     */
    public static void responderConsultaCinco(SistemaPokedexImpl sistemaPokedex){
        System.out.println("¿Quiere buscar por: \n" +
                "[1] id \n" +
                "[2] nombre?");
        Scanner opcionPersonalizada = new Scanner(System.in);
        int opcionElegida = opcionPersonalizada.nextInt();
        if (opcionElegida == 1){
            // se pide el id a buscar
            System.out.println("Ingrese id a buscar: ");
            Scanner opcionId = new Scanner(System.in);
            int idElegido = opcionId.nextInt();
            NodoPokemon pokemonIdBuscado = sistemaPokedex.buscarId(idElegido);
            if (pokemonIdBuscado != null){
                desplegarPokemon(pokemonIdBuscado);
            }
            else {
                System.out.println("No existe el pokeom con id " + idElegido);
            }

        }
        else if (opcionElegida == 2){
            // se pide el nombre a buscar
            System.out.println("Ingrese nombre a buscar: ");
            Scanner opcionNombre = new Scanner(System.in);
            String nombreElegido = opcionNombre.nextLine();
            NodoPokemon pokemonNombreBuscado = sistemaPokedex.buscarNombre(nombreElegido);
            if (pokemonNombreBuscado != null){
                desplegarPokemon(pokemonNombreBuscado);
            }
            else {
                System.out.println("Nombre pokemon no existe");
            }
        }
        else {
            System.out.println("Error, no valida la opcion");
        }
    }

    /**
     * Desplegar los datos de un pokemon
     * @param pokemonADesplegar el pokemon a desplegar sus datos
     */
    public static void desplegarPokemon(NodoPokemon pokemonADesplegar){
        System.out.println("Pokemon desplegar " + pokemonADesplegar);
        String mensaje = "";
        mensaje = "id: " + pokemonADesplegar.getPokemon().getId();
        mensaje = mensaje + ", nombre: " + pokemonADesplegar.getPokemon().getNombre();
        mensaje = mensaje + ", etapa: "  + pokemonADesplegar.getPokemon().getEtapa();
        mensaje = mensaje + ", pri. ev: " + pokemonADesplegar.getPokemon().getEvolucionPrevia();
        mensaje = mensaje + ", seg. ev: " + pokemonADesplegar.getPokemon().getEvolucionSiguiente();
        mensaje = mensaje + ", tipo uno: " + pokemonADesplegar.getPokemon().getTipoUno();
        mensaje = mensaje + ", tipo dos: " + pokemonADesplegar.getPokemon().getTipoDos();
        System.out.println(mensaje);
    }

    /**
     * Ordenar por id crecientemente los pokemons
     * @param sistemaPokedex a utilizar
     */
    public static void ordenarCrecientementePorId(SistemaPokedexImpl sistemaPokedex) {
        System.out.println("Se ordena crecientemente por id.");

    }

    /**
     * Ordenar por id decrecientemente los pokemons
     * @param sistemaPokedex a utilizar
     */
    public static void ordenarDecrecientementePorId(SistemaPokedexImpl sistemaPokedex){
        System.out.println("Se ordena decrecientemente por id.");

    }

    /**
     * Ordenamiento alfabetico de los pokemons
     * @param sistemaPokedex a utilizar
     */
    public static void ordenarAlfabeticamentePorNombre(SistemaPokedexImpl sistemaPokedex) {
        System.out.println("Se ordena alfabeticamente por nombre.");

    }

    /**
     * Desplegar todos los pokemones alfabeticamente
     * @param sistemaPokedex a utilizar
     */
    public static void desplegarTodosLosPokemones(SistemaPokedexImpl sistemaPokedex){
        sistemaPokedex.desplegarTodosLosPokemones();
    }

    /**
     * Desplegar la lista por los pokemons en primera evolucion
     * @param sistemaPokedex a utilizar
     */
    public static void desplegarListaPrimeraEvolucion(SistemaPokedexImpl sistemaPokedex){
        sistemaPokedex.desplegarPorPrimeraEvolucion();
    }

    /**
     * Desplegar la lista por el tipo de pokemon ingresado
     * @param sistemaPokedex a utilizar
     * @param tipoBuscado tipo de pokemon a buscar
     */
    public static void desplegarListaPorTipo(SistemaPokedexImpl sistemaPokedex, String tipoBuscado){
        sistemaPokedex.desplegarPorTipo(tipoBuscado);
    }

    /**
     * Lectura del archivo de pokemons
     * @param nombreArchivo para leer
     * @throws IOException
     */
    public static void lecturaArchivoPokemon(String nombreArchivo, SistemaPokedexImpl sistemaPokedex) throws IOException {
        BufferedReader archivoPokemon = new BufferedReader(new FileReader(nombreArchivo));
        String lineaArchivo = "";

        int indicePokemon = 0;
        while ((lineaArchivo = archivoPokemon.readLine()) != null) {
            String[] partesArchivo = lineaArchivo.split(",");
            int cantidadComas = revisarCaracter(lineaArchivo, ',');
            String idPokemon = "";
            String nombrePokemon = "";
            String etapaActual = "";
            String evolucionSiguiente = "";
            String evolucionPrevia = "";
            String evolucionTercera = "";
            String tipoUno = "";
            String tipoDos = "";

            if (cantidadComas >= 5 && cantidadComas <= 7){//el registro es correcto en cantidad de campos (7 campos)
                //para pokemon basico
                idPokemon = partesArchivo[0].trim();
                nombrePokemon = partesArchivo[1].trim();
                etapaActual = partesArchivo[2].trim();

                if (etapaActual.equalsIgnoreCase("Basico") && cantidadComas == 7){
                    evolucionSiguiente = partesArchivo[3].trim();
                    evolucionPrevia = partesArchivo[4].trim();
                    evolucionTercera = partesArchivo[5].trim();
                    tipoUno = partesArchivo[6].trim();
                    tipoDos = partesArchivo[7].trim();
                }
                else if (etapaActual.equalsIgnoreCase("Basico") && cantidadComas == 6){
                    evolucionSiguiente = partesArchivo[3].trim();
                    evolucionPrevia = partesArchivo[4].trim();
                    evolucionTercera = "---";
                    tipoUno = partesArchivo[5].trim();
                    tipoDos = partesArchivo[6].trim();
                }
                else if (etapaActual.equalsIgnoreCase("Basico") && cantidadComas == 5){
                    evolucionSiguiente = partesArchivo[3].trim();
                    evolucionPrevia = "---";
                    evolucionTercera = "---";
                    tipoUno = partesArchivo[4].trim();
                    tipoDos = partesArchivo[5].trim();
                }
                else if (etapaActual.equalsIgnoreCase("Primera Evolucion") && cantidadComas == 6){
                    evolucionSiguiente = partesArchivo[3].trim();
                    evolucionPrevia = partesArchivo[4].trim();
                    evolucionTercera = "---";
                    tipoUno = partesArchivo[5].trim();
                    tipoDos = partesArchivo[6].trim();
                }
                else if (etapaActual.equalsIgnoreCase("Primera Evolucion") && cantidadComas == 5){
                    evolucionSiguiente = "---";
                    evolucionPrevia = partesArchivo[3].trim();
                    evolucionTercera = "---";
                    tipoUno = partesArchivo[4].trim();
                    tipoDos = partesArchivo[5].trim();
                }
                else if (etapaActual.equalsIgnoreCase("Segunda Evolucion") && cantidadComas == 6){
                    evolucionSiguiente = partesArchivo[3].trim();
                    evolucionPrevia = partesArchivo[4].trim();
                    evolucionTercera = "---";
                    tipoUno = partesArchivo[5].trim();
                    tipoDos = partesArchivo[6].trim();
                }
                else {
                    System.out.println("Error de campos");
                }

                int idPokemonInteger = Integer.parseInt(idPokemon);
                Pokemon pokemonArchivo = new Pokemon(idPokemonInteger, nombrePokemon, etapaActual, evolucionSiguiente, evolucionPrevia, evolucionTercera, tipoUno, tipoDos);

                guardarPokemon(indicePokemon, pokemonArchivo, sistemaPokedex);

                indicePokemon++;
            }
            else {
                //System.out.println("Registro erroneo");
            }
        }
        archivoPokemon.close();
    }

    /**
     * Revision de un caracter
     * @param linea a revisar
     * @param caracter a comprobar
     * @return cantidad total del caracter en la linea
     */
    public static int revisarCaracter(String linea, char caracter){
        int cantidadCaracteres = 0;
        int largoLinea = linea.length();

        for (int indice = 0; indice < largoLinea; indice++){
            char caracterComparar = linea.charAt(indice);
            if (caracterComparar == caracter){
                cantidadCaracteres++;
            }
        }
        return cantidadCaracteres;
    }

    /**
     * guarda el pokemon en el sistema
     * @param indicePokemon a guardar
     * @param pokemonArchivo todos los datos del pokemom
     */
    public static void guardarPokemon(int indicePokemon, Pokemon pokemonArchivo, SistemaPokedexImpl sistemaPokedex){
        //buscar indicePokemon en la listaPokemon
        boolean existePokemon = false;
        if (existePokemon){
            System.out.println("Error, pokemon ya existe " + indicePokemon);
        }
        else {
            sistemaPokedex.agregarPokemon(pokemonArchivo);
        }
    }
}
