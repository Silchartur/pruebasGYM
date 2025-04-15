
/**
 * Franquicia Gym // Gestion de equipos e instalaciones
 * @author Daniela Matei
 * @version 2
 */
/**
 * Clase Establecimiento
 */
public class Establecimiento {
    private String id, direccion;
    /**
     * Constructor por defecto
     */
    public Establecimiento(){}
    /**
     * Constructor con 2 parametros
     * @param id identificador del establecimiento
     * @param direccion la dirección del establecimiento
     */
    public Establecimiento(String id, String direccion){
        this.id = id;
        this.direccion = direccion;
    }

    /**
     * Setter del id
     * @param id inserta el id del establecimiento
     */
    public void setId(String id) {
        this.id = id;
    }
    /**
     * Getter del id
     * @return retorna el id del establecimiento
     */
    public String getId() {
        return id;
    }
    /**
     * Setter de la direccion
     * @param direccion inserta la direccion del establecimiento
     */
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
    /**
     * Getter de la direccion
     * @return retorna la direccion del establecimiento
     */
    public String getDireccion() {
        return direccion;
    }
}
