
import java.text.SimpleDateFormat;
import java.util.*;
/**
* Clase Clase
*
* Contiene informacion de cada clase del gimnasio
*
* @author Esther Díaz
* @version 1.0, 2025-04-14
*/
public class Clase {
    
    private String nombre;
    private int maxAsistentes;
    private static int codigo = 0;
    private Instalacion instalacion;
    private Empleado empleado;
    private GregorianCalendar fechaHorario;
    private ArrayList<Cliente> clientesInscritos = new ArrayList<>();

    /**
     * Constructor por defecto
     */
    public Clase() {

    }

    /**
     * Constructor con 6 parametros
     * 
     * @param nom nombre de la clase
     * @param inst instalacion donde se realizará
     * @param fechaHorario fecha y horario 
     * @param empleado empleado que la dirigirá en caso de ser dirigida
     * @param numAsis numero de asistentes de la clase
     * @param maxAsistentes maximo de asistentes de la clase
     */
    public Clase (String nom, Instalacion inst, GregorianCalendar fechaHorario, Empleado empleado, int maxAsistentes) {

        this.nombre = nom;
        this.instalacion = inst;
        this.fechaHorario = fechaHorario;
        this.empleado = empleado;
        this.maxAsistentes = maxAsistentes;
        codigo ++;
    }

    public Clase (String nombre, int maxAsistentes) {

        this.nombre = nombre;
        this.maxAsistentes = maxAsistentes;
    }

    /**
     * Devuelve el nombre de los asistentes de la clase
     */
    public void mostrarClientesInscritos(){

        if (clientesInscritos.isEmpty()) {
            System.out.println("No hay clientes inscritos en esta clase");
        } else {
            for (Cliente c: clientesInscritos) {
                System.out.println("- " + c.getNombre());
            }
        }
    }

    /**
     * Registra un cliente en la clase
     * 
     * @param cliente que se ha inscrito en la clase
     */
    public void registrarCliente(Cliente cliente) {

        if(clientesInscritos.contains(cliente)) {
            System.out.println("El cliente ya está inscrito en esta clase");
        } else {
            clientesInscritos.add(cliente);
        }
    }

    /**
     * Elimina un cliente de la clase
     * @param cliente a eliminar
     */
    public void eliminarCliente(Cliente cliente) {

        if(clientesInscritos.contains(cliente)) {
            clientesInscritos.remove(cliente);
            
        } else {
            System.out.println("El cliente no está inscrito en esta clase");
        }
    }

    /**
     * Establece el nombre de la clase
     * 
     * @param nom nombre de la clase
     */
    public void setNombre (String nom) {

        nombre = nom;
    }

    /**
     * Establece la fecha y horario de la clase
     * @param fecha fecha de la clase
     */
    public void setFechaHorario(GregorianCalendar fecha) {

        this.fechaHorario = fecha;
    }

    /**
     * Devuelve la fecha y horario de la clase
     * 
     * @return fecha y horario
     */
    public GregorianCalendar getFechaHorario() {
        
        return fechaHorario;
    }

    /**
     * Establece la instalacion en la que se realizara la clase
     * 
     * @param inst instalacion
     */
    public void setInstalacion (Instalacion inst) {

        instalacion = inst;
    }

    /**
     * Establece el empleado que va a dirigir la clase, en caso de ser dirigida
     * 
     * @param empl empleado / entrenador
     */
    public void setEmpleado (Empleado empl) {

        empleado = empl;
    }

    /**
     * Establece el numero maximo de asistentes de la clase
     * 
     * @param maxAsis maximo de asistentes
     */
    public void setMaxAsistentes (int maxAsis) {

        maxAsistentes = maxAsis;
    }

    /**
     * Devuelve el empleado que dirigira la clase, en caso de ser una clase dirigida
     * 
     * @return empleado
     */
    public Empleado getEmpleado() {

        return empleado;
    }

    /**
     * Devuelve el nombre de la clase
     * 
     * @return nombre
     */
    public String getNombre () {

        return nombre;
    }

    /**
     * Devuelve la lista de los clientes inscritos en la clase
     * @return lista clientesInscritos
     */
    public ArrayList<Cliente> getClientesInscritos() {

        return clientesInscritos;
    }

    /**
     * Devuelve la instalacion donde va a realizarse la clase
     * 
     * @return instalacion
     */
    public Instalacion getInstalacion() {

        return instalacion;
    }

    /**
     * Devuelve el numero de asistentes de la clase
     * 
     * @return numero de asistentes
     */
    public int getNumAsistentes () {

        return clientesInscritos.size();
    }

    /**
     * Devuelve el numero maximo de asistentes de la clase
     * 
     * @return numero maximo de asistentes
     */
    public int getMaxAsistentes () {

        return maxAsistentes;
    }

    /**
     * Devuelve el codigo de la clase
     * 
     * @return codigo
     */
    public int getCodigo () {

        return codigo;
    }

    /**
     * Devuelve la informacion de la clase asi como el nombre, la fecha y horario, la instalacion donde se realizara,
     * el maximo de asistentes, el numero de asistentes que han realizado la reserva y, en caso de ser una clase dirigida, 
     * el empleado o entrenador que la dirige. 
     * 
     * La fecha se mostrará formateada, para que se muestre en el formato adecuado.
     * 
     * @return una cadena con los detalles de la clase
     */
    public String toString() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");

        return "Clase: " + nombre + "\nFecha y hora: " + sdf.format(fechaHorario.getTime()) + "\nUbicación: " + instalacion.getTipo() + "\nCapacidad total: " + maxAsistentes + "\nAsistentes actuales: " + getNumAsistentes() + "\nEntrenador: " + (empleado != null ? empleado.getNombre() : "ninguno");
    }
    
}   
 