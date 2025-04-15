
import java.util.ArrayList;

/**
 * Representa un cliente del gimnasio con sus datos personales, de contacto,
 * suscripciones y pagos.
 *
 * @author Silvia Perea Navarro
 * @date 14/04/2025
 */
public class Cliente {

    private int id = 0;  // ID único del cliente
    private String nombre;  // Nombre del cliente
    private String apellido;  // Apellido del cliente
    private String email;  // Correo electrónico del cliente
    private String telefono;  // Número de teléfono del cliente
    private int fechaNacimiento;  // Año de nacimiento del cliente
    private String estadoSalud;  // Estado de salud del cliente
    private Suscripcion suscripcion;  // Tipo de suscripción del cliente
    private int fechaInicioSuscripcion;  // Año de inicio de la suscripción
    private int fechaFinSuscripcion;  // Año de fin de la suscripción
    private boolean suscripcionActiva;  // Indica si la suscripción está activa
    private ArrayList<Pago> pagos = new ArrayList<>();  // Lista de pagos realizados por el cliente

    /**
     * Constructor que inicializa un cliente con solo su ID.
     *
     * @param id Identificador único del cliente.
     */
    public Cliente(int id) {
        this.id = id;
    }

    /**
     * Constructor que inicializa todos los campos del cliente.
     *
     * @param id Identificador único del cliente.
     * @param nombre Nombre del cliente.
     * @param apellido Apellido del cliente.
     * @param email Correo electrónico.
     * @param telefono Número de teléfono.
     * @param fechaNacimiento Año de nacimiento.
     * @param estadoSalud Estado de salud del cliente.
     * @param suscripcion Tipo de suscripción.
     * @param fechaInicioSuscripcion Año de inicio de la suscripción.
     * @param fechaFinSuscripcion Año de fin de la suscripción.
     * @param suscripcionActiva Indica si la suscripción está activa.
     */
    public Cliente(int id, String nombre, String apellido, String email, String telefono, int fechaNacimiento,
            String estadoSalud, Suscripcion suscripcion, int fechaInicioSuscripcion, int fechaFinSuscripcion,
            boolean suscripcionActiva) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.telefono = telefono;
        this.fechaNacimiento = fechaNacimiento;
        this.estadoSalud = estadoSalud;
        this.suscripcion = suscripcion;
        this.fechaInicioSuscripcion = fechaInicioSuscripcion;
        this.fechaFinSuscripcion = fechaFinSuscripcion;
        this.suscripcionActiva = suscripcionActiva;
    }

    // Métodos getter y setter con comentarios Javadoc
    /**
     * Devuelve el nombre del cliente.
     *
     * @return Nombre del cliente.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Establece el nombre del cliente.
     *
     * @param nombre Nombre del cliente.
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Devuelve el apellido del cliente.
     *
     * @return Apellido del cliente.
     */
    public String getApellido() {
        return apellido;
    }

    /**
     * Establece el apellido del cliente.
     *
     * @param apellido Apellido del cliente.
     */
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    /**
     * Devuelve el correo electrónico del cliente.
     *
     * @return Correo electrónico del cliente.
     */
    public String getEmail() {
        return email;
    }

    /**
     * Establece el correo electrónico del cliente.
     *
     * @param email Correo electrónico del cliente.
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Devuelve el número de teléfono del cliente.
     *
     * @return Número de teléfono del cliente.
     */
    public String getTelefono() {
        return telefono;
    }

    /**
     * Establece el número de teléfono del cliente.
     *
     * @param telefono Número de teléfono del cliente.
     */
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    /**
     * Devuelve la fecha de nacimiento del cliente.
     *
     * @return Fecha de nacimiento del cliente.
     */
    public int getFechaNacimiento() {
        return fechaNacimiento;
    }

    /**
     * Establece la fecha de nacimiento del cliente.
     *
     * @param fechaNacimiento Fecha de nacimiento del cliente.
     */
    public void setFechaNacimiento(int fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    /**
     * Devuelve el estado de salud del cliente.
     *
     * @return Estado de salud del cliente.
     */
    public String getEstadoSalud() {
        return estadoSalud;
    }

    /**
     * Establece el estado de salud del cliente.
     *
     * @param estadoSalud Estado de salud del cliente.
     */
    public void setEstadoSalud(String estadoSalud) {
        this.estadoSalud = estadoSalud;
    }

    /**
     * Devuelve el tipo de suscripción del cliente.
     *
     * @return Tipo de suscripción.
     */
    public Suscripcion getSuscripcion() {
        return suscripcion;
    }

    /**
     * Establece el tipo de suscripción del cliente.
     *
     * @param suscripcion Tipo de suscripción.
     */
    public void setSuscripcion(Suscripcion suscripcion) {
        this.suscripcion = suscripcion;
    }

    /**
     * Devuelve el año de inicio de la suscripción del cliente.
     *
     * @return Año de inicio de la suscripción.
     */
    public int getFechaInicioSuscripcion() {
        return fechaInicioSuscripcion;
    }

    /**
     * Establece el año de inicio de la suscripción del cliente.
     *
     * @param fechaInicioSuscripcion Año de inicio de la suscripción.
     */
    public void setFechaInicioSuscripcion(int fechaInicioSuscripcion) {
        this.fechaInicioSuscripcion = fechaInicioSuscripcion;
    }

    /**
     * Devuelve el año de fin de la suscripción del cliente.
     *
     * @return Año de fin de la suscripción.
     */
    public int getFechaFinSuscripcion() {
        return fechaFinSuscripcion;
    }

    /**
     * Establece el año de fin de la suscripción del cliente.
     *
     * @param fechaFinSuscripcion Año de fin de la suscripción.
     */
    public void setFechaFinSuscripcion(int fechaFinSuscripcion) {
        this.fechaFinSuscripcion = fechaFinSuscripcion;
    }

    /**
     * Devuelve si la suscripción del cliente está activa.
     *
     * @return true si la suscripción está activa, false si no.
     */
    public boolean isSuscripcionActiva() {
        return suscripcionActiva;
    }

    /**
     * Establece si la suscripción del cliente está activa.
     *
     * @param suscripcionActiva Estado de la suscripción.
     */
    public void setSuscripcionActiva(boolean suscripcionActiva) {
        this.suscripcionActiva = suscripcionActiva;
    }

    /**
     * Devuelve la lista de pagos realizados por el cliente.
     *
     * @return Lista de pagos.
     */
    public ArrayList<Pago> getPagos() {
        return pagos;
    }

    /**
     * Añade un nuevo pago a la lista de pagos del cliente.
     *
     * @param pago Pago a añadir.
     */
    public void agregarPago(Pago pago) {
        pagos.add(pago);
    }

    /**
     * Devuelve una representación en texto del cliente.
     *
     * @return Cadena con el nombre, apellido e ID del cliente.
     */
    @Override
    public String toString() {
        return "Cliente: " + nombre + " " + apellido + " (ID: " + id + ")";
    }

    /**
     * Devuelve el ID del cliente.
     *
     * @return ID del cliente.
     */
    public int getId() {
        return id;
    }

    /**
     * Establece el ID del cliente.
     *
     * @param id ID del cliente.
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Establece la lista de pagos realizados por el cliente.
     *
     * @param pagos Lista de pagos.
     */
    public void setPagos(ArrayList<Pago> pagos) {
        this.pagos = pagos;
    }

    /**
     * Compara este cliente con otro objeto por su ID.
     *
     * @param obj Objeto a comparar.
     * @return true si el ID es igual, false en caso contrario.
     */
    @Override
    public boolean equals(Object obj) {
        boolean resultado = true;

        if (obj != null && obj instanceof Cliente) {
            Cliente cliente2 = (Cliente) obj;
            if (this.id == cliente2.getId()) {
                resultado = true;
            }
        } else {
            resultado = false;
        }

        return resultado;
    }

    /**
     * Devuelve un número que representa el tipo de suscripción del cliente.
     *
     * @return 1 = Básica, 2 = Corporativa, 3 = Estudiante, 4 = Premium
     */
    public int getTipoSuscripcion() {
        int tipo = 1; // Por defecto, Básica

        if (suscripcion instanceof SuscripcionCorporativa) {
            tipo = 2;
        } else if (suscripcion instanceof SuscripcionEstudiante) {
            tipo = 3;
        } else if (suscripcion instanceof SuscripcionPremium) {
            tipo = 4;
        }

        return tipo;
    }

}
