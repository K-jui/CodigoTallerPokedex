package cl.ucn.programacionavanzada.model;

public class Pokemon {
    private int id;
    private String nombre;
    private String etapa;
    private String evolucionSiguiente;
    private String evolucionPrevia;
    private String evolucionTercera;
    private String tipoUno;
    private String tipoDos;

    /**
     * El constructor del pokemon
     * @param id numero identiicador del pokemon
     * @param nombre del pokemon
     * @param etapa actual en la que esta el pokemon
     * @param evolucionSiguiente evolucion siguiente a la etapa actual
     * @param evolucionPrevia evolucion previa a la etapa actual
     * @param evolucionTercera solo en casos donde el pokemon tiene mas de 2 evoluciones
     * @param tipoUno primer tipo elemental del pokemon
     * @param tipoDos segundo tipo elemental del pokemon
     */
    public Pokemon(int id, String nombre, String etapa, String evolucionSiguiente, String evolucionPrevia, String evolucionTercera, String tipoUno, String tipoDos) {
        this.id = id;
        this.nombre = nombre;
        this.etapa = etapa;
        this.evolucionSiguiente = evolucionSiguiente;
        this.evolucionPrevia = evolucionPrevia;
        this.evolucionTercera = evolucionTercera;
        this.tipoUno = tipoUno;
        this.tipoDos = tipoDos;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEtapa() { return etapa; }

    public void setEtapa(String etapa) {
        this.etapa = etapa;
    }

    public String getEvolucionSiguiente() {
        return evolucionSiguiente;
    }

    public void setEvolucionSiguiente(String evolucionSiguiente) {
        this.evolucionSiguiente = evolucionSiguiente;
    }

    public String getEvolucionPrevia() {
        return evolucionPrevia;
    }

    public void setEvolucionPrevia(String evolucionPrevia) {
        this.evolucionPrevia = evolucionPrevia;
    }

    public String getEvolucionTercera() { return evolucionTercera; }

    public void setEvolucionTercera(String evolucionTercera) { this.evolucionTercera = evolucionTercera; }

    public String getTipoUno() {
        return tipoUno;
    }

    public void setTipoUno(String tipoUno) {
        this.tipoUno = tipoUno;
    }

    public String getTipoDos() {
        return tipoDos;
    }

    public void setTipoDos(String tipoDos) { this.tipoDos = tipoDos; }
}
