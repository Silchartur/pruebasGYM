
import java.util.ArrayList;
import java.time.LocalDate;
import java.time.LocalTime;

public class Encargado {
    // atributos
    String nombre, nif, direccion, sueldo;
    int telefono;
    Turno turno;
    static int id = 0;
    static ArrayList<Empleado> aCargoDe;

    /**
     * constructor por defecto
     */
    public Encargado() {
        turno = new Turno();
        Empleado.id++;
        id++;
    }

    /**
     * constructor sobrecargado que permite también registrar con horario
     * concreto
     * 
     * @param nombre
     * @param nif
     * @param direccion
     * @param sueldo
     * @param telefono
     * @param turno
     */
    public Encargado(String nombre, String nif, String direccion, String sueldo, int telefono) {
        this.nombre = nombre;
        this.nif = nif;
        this.direccion = direccion;
        this.sueldo = sueldo;
        turno = new Turno();
        Empleado.id++;
        id++;
    }

    /**
     * método que establece nueva dirección
     * 
     * @param direccion nueva dirección
     */
    public void setNuevaDireccion(String direccion) {
        this.direccion = direccion;
    }

    /**
     * método que establece nuevo sueldo
     * 
     * @param sueldo nuevo sueldo
     */
    public void setNuevoSueldo(String sueldo) {
        this.sueldo = sueldo;
    }

    /**
     * Método que establece nuevo teléfono
     * 
     * @param telefono nuevo teléfono
     */
    public void setNuevoTelefono(int telefono) {
        this.telefono = telefono;
    }

    /**
     * método que establece nuevas vacaciones llamando al método setNuevasVacaciones
     * de la clase Turno
     * 
     * @param inicio fecha de inicio de las vacaciones
     * @param fin    fecha de final de las vacaiciones
     */
    public void setNuevasVacaciones(LocalDate inicio, LocalDate fin) {
        turno.setNuevasVacaciones(inicio, fin);
    }

    /**
     * método que establece periodo de baja para un trabajador llamando al método
     * setNuevaBaja en la clase Turno
     * @param inicio
     * @param vuelta
     */
    public void setNuevaBaja(LocalDate inicio, LocalDate vuelta) {
        turno.setBaja(inicio, vuelta);
    }

    /**
     * método que establece nuevo horario llamando al método setNuevoHorario
     * de la clase Turno
     * 
     * @param inicio
     * @param fin
     */
    public void setNuevoHorario(LocalTime inicio, LocalTime fin) {
        turno.setHorario(inicio, fin);
    }

    /**
     * método que muestra el nombre del empleado (no susceptible a cambios)
     * 
     * @return nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * método que muestra el id del empleado (no susceptible a cambios)
     * 
     * @return id
     */
    public int getId() {
        return id;
    }

    /**
     * método que muestra el sueldo del encargado
     * 
     * @return sueldo
     */
    public String getSueldo() {
        return sueldo;
    }

    /**
     * método que muestra el teléfono del encargado
     * 
     * @return telefono
     */
    public int getTelefono() {
        return telefono;
    }

    /**
     * método que muestra las vacaciones del encargado
     * 
     * @return del método en la clase turno
     */
    public String getVacaciones() {
        return turno.getVacaciones();
    }

    /**
     * método que muestra el horario del encargado
     * 
     * @return
     */
    public String getHorario() {
        return turno.getHorario();
    }

    /**
     * método que muestra la información de la ausencia de un trabajador
     * 
     * @return devuelve en formato string la respuesta de los métodos codificados en
     *         la clase Turno
     *         (realmente son parámetros que tienen que ver con el turno, por eso se
     *         encuentran codificados
     *         en dicha clase)
     */
    public String getInfoTrabAusente() {
        return turno.getVacaciones() + turno.comprobarBaja();
    }
}