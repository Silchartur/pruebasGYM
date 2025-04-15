
import java.util.ArrayList;
import java.time.LocalDate;
import java.time.LocalTime;

public class Empleado {
    // atributos
    static int id = 0;
    String nombre, nif, direccion, sueldo, especialidad;
    int telefono;
    Turno turno;

    /**
     * constructor por defecto
     */
    public Empleado() {
        turno = new Turno();
        Empleado.id++;
    }

    /**
     * constructor sobrecargado para registar un empleado con datos específicos
     * 
     * @param nombre       nombre del empleado
     * @param nif          número de identificación fiscal
     * @param direccion    dirección del empleado
     * @param sueldo       sueldo asignado
     * @param especialidad especialidad del empleado
     * @param telefono     teléfono del empleado
     */
    public Empleado(String nombre, String nif, String direccion, String sueldo, String especialidad, int telefono) {
        this.nombre = nombre;
        this.nif = nif;
        this.direccion = direccion;
        this.sueldo = sueldo;
        this.especialidad = especialidad;
        this.telefono = telefono;
        this.turno = new Turno();
        Empleado.id++;
    }

    /**
     * constructor necesario para asignar una clase a un empleado en el apartado
     * de clases del subsistema
     * 
     * @param nombre
     * @param id
     */
    public Empleado(String nombre, int id) {
        this.nombre = nombre;
        Empleado.id = id;
        this.turno = new Turno();
    }

    // métodos
    /**
     * método que establece el nuevo turno para el empleado llamando al
     * método codificado en la clase Turno
     * 
     * @param inicio hora del nuevo comienzo
     * @param fin    hora del nuevo final
     */
    public void setNuevoHorario(LocalTime inicio, LocalTime fin) {
        turno.setHorario(inicio, fin);
    }

    /**
     * metodo que establece las nuevas vacaciones llamando al metodo
     * setNuevasVacaciones
     * de la clase turno
     * 
     * @param inicio inicio de las nuevas vacaciones
     * @param fin    fin de las nuevas vacaciones
     */
    public void setNuevasVacaciones(LocalDate inicio, LocalDate fin) {
        turno.setNuevasVacaciones(inicio, fin);
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
     * Método que establece nueva especialidad
     * 
     * @param telefono nueva especialidad
     */
    public void setNuevaEspecialidad(String especialidad) {
        this.especialidad = especialidad;
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
     * método que muestra el sueldo del empleado
     * 
     * @return sueldo
     */
    public String getSueldo() {
        return sueldo;
    }

    /**
     * método que muestra la especialidad del trabajador
     * 
     * @return especialidad
     */
    public String getEspecialidad() {
        return especialidad;
    }

    /**
     * método que muestra el teléfono del empleado
     * 
     * @return telefono
     */
    public int getTelefono() {
        return telefono;
    }

    /**
     * método que muestra las vacaciones del empleado
     * 
     * @return return del método en la clase turno
     */
    public String getVacaciones() {
        return turno.getVacaciones();
    }

    /**
     * método que muestra el horario del empleado
     * 
     * @return horas de inicio y final del método en Turno
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

    /**
     * PODRÍA IR EN LA COLECCIÓN
     * método para buscar un empleado en caso necesario (saber si imparte una clase,
     * conocer sus turnos y
     * horarios...)
     * 
     * @param epmlpeados lista de empleados para realizar la búsqueda, se añaden a
     *                   la misma al registrarlos
     * @param nombre     nombre para encontrar coincidencias
     * @param id         id, no susceptible a cambios para evitar errores en
     *                   coincidencias en el nombre (ej: Marcos, 01; Marcos, 15)
     * @return la posición de la lista en que se encuentra el empleado, de no
     *         encontrarlo quiere decir que o bien no imparte
     *         la clase o no está registrado en el sistema
     */
    public static int buscarEmpleado(ArrayList<Empleado> epmlpeados, String nombre, int id) {
        int i = 0, pos = -1;
        while (i < epmlpeados.size() && pos == -1) {
            if (epmlpeados.get(i).getNombre().equals(nombre) && epmlpeados.get(i).getId() == id) {
                pos = i;
            } else {
                i++;
            }
        }
        return pos;
    }
}