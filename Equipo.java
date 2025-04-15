
/**
 * Franquicia Gym // Gestion de equipos e instalaciones
 * @author Daniela Matei
 * @version 2
 */
import java.util.ArrayList;
/**
 * Clase Equipo
 */
public class Equipo{
    private String tipo, estado;
    private double cod;
    ArrayList <Equipo> equipos; //Para tener una lista de equipos

    /**
     * Contructor por defecto 
     */
    public Equipo(){}

    /**
     * Constructor con 3 parametros
     * @param cod codigo del equipo
     * @param tipo tipo de equipo, es su nombre
     * @param estado estado del equipo /disponible, en uso, mantenimiento/
     */
    public Equipo(double cod, String tipo, String estado){
        this.cod = cod;
        this.tipo = tipo;
        this.estado = estado;
        equipos = new ArrayList<>();
    }
    
    /**
     * Setter para el codigo
     * @param cod inseta el codigo del equipo
     */
    public void setCod(double cod) {
        this.cod = cod;
    }
    /**
     * Getter del codigo
     * @return retorna el codigo del equipo
     */
    public double getCod() {
        return cod;
    }
    /**
     * Setter para el tipo
     * @param tipo inserta el nombre del equipo
     */
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    /**
     * Getter para el tipo
     * @return retorna el nombre del equipo
     */
    public String getTipo() {
        return tipo;
    }
    /**
     * Setter de estado
     * @param estado inserta estado del equipo /disponible, en uso, mantenimiento/
     */
    public void setEstado(String estado) {
        this.estado = estado;
    }
    /**
     * Getter de estado
     * @return retorna el estado del equipo /disponible, en uso, mantenimiento/
     */
    public String getEstado() {
        return estado;
    }
}