
/**
 * Franquicia Gym // Gestión de equipos e instalaciones
 * @author Daniela Matei
 * @version 2
 */
/**
 * Clase Instalacines
 */
public class Instalacion {
    private double id;
    private String tipo, estado;
    /**
     * Constructor por defecto
     */
    public Instalacion(){}

    /**
     * Constructor con 1 parametro
     * @param tipo
     */
    public Instalacion(String tipo) {
        this.tipo = tipo;
    }
    /**
     * Constructor con 3 parametros
     * @param id identificador de la instalacion
     * @param tipo tipo/nombre de la instalacion
     * @param estado estado de la instalacion /disponible, en uso, mantenimiento/
     */
    public Instalacion(double id,String tipo, String estado){
        this.id = id;
        this.tipo = tipo;
        this.estado = estado;
    }

    /**
     * Setter del id
     * @param id inserta el id de la isntalacion
     */
    public void setId(double id) {
        this.id = id;
    }
    /**
     * Getter del id
     * @return retorna el id de la isntalacion
     */
    public double getId() {
        return id;
    }
    /**
     * Setter del tipo
     * @param tipo inserta el tipo/nombre de la instalacion
     */
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    /**
     * Getter del tipo
     * @return retorna el tipo/nombre de la instalacion
     */
    public String getTipo() {
        return tipo;
    }
    /**
     * Setter del estado
     * @param estado inserta el estado de la instalacion /disponible, en uso, mantenimiento/
     */
    public void setEstado(String estado) {
        this.estado = estado;
    }
    /**
     * Getter del estado
     * @return retorna el estado de la instalacion /disponible, en uso, mantenimiento/
     */
    public String getEstado() {
        return estado;
    }
}
