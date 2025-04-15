
/**
 * Clase Suscripcion
 * 
 * Representa una suscripción que un cliente puede tener. Contiene información sobre el nombre de la suscripción, el precio mensual,
 * la duración en meses, las sucursales a las que el cliente tiene acceso, y la capacidad máxima de sucursales que se pueden registrar.
 * @author Silvia Perea
 * @date 14/04/2025
 */
public class Suscripcion {

    // Atributos comunes a todas las suscripciones
    protected String nombre;                    // Nombre de la suscripción
    protected double precioMensual;             // Precio mensual de la suscripción
    protected int duracionMeses;                // Duración de la suscripción en meses
    private String[] sucursalesAcceso;          // Array que contiene las sucursales a las que el cliente tiene acceso
    private int capacidadSucursales;            // Número máximo de sucursales que pueden ser asociadas
    private int sucursalesRegistradas;          // Número de sucursales registradas actualmente en la suscripción

    /**
     * Constructor de la clase Suscripcion.
     * 
     * Inicializa los valores de nombre, precio mensual, duración, capacidad de sucursales y crea un array para las sucursales
     * con el tamaño definido por la capacidad máxima de sucursales.
     * 
     * @param nombre             Nombre de la suscripción
     * @param precioMensual      Precio mensual de la suscripción
     * @param duracionMeses      Duración en meses de la suscripción
     * @param capacidadSucursales Capacidad máxima de sucursales a las que se puede acceder
     */
    public Suscripcion(String nombre, double precioMensual, int duracionMeses, int capacidadSucursales) {
        this.nombre = nombre;
        this.precioMensual = precioMensual;
        this.duracionMeses = duracionMeses;
        this.capacidadSucursales = capacidadSucursales;
        this.sucursalesAcceso = new String[capacidadSucursales];  // Inicializa el array de sucursales con el tamaño de la capacidad
    }

    // Métodos getter y setter para los atributos de la clase

    /**
     * Método getter para obtener el nombre de la suscripción.
     * 
     * @return El nombre de la suscripción.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Método setter para establecer el nombre de la suscripción.
     * 
     * @param nombre El nombre de la suscripción a establecer.
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Método getter para obtener el precio mensual de la suscripción.
     * 
     * @return El precio mensual de la suscripción.
     */
    public double getPrecioMensual() {
        return precioMensual;
    }

    /**
     * Método setter para establecer el precio mensual de la suscripción.
     * 
     * @param precioMensual El precio mensual de la suscripción a establecer.
     */
    public void setPrecioMensual(double precioMensual) {
        this.precioMensual = precioMensual;
    }

    /**
     * Método getter para obtener la duración de la suscripción en meses.
     * 
     * @return La duración de la suscripción en meses.
     */
    public int getDuracionMeses() {
        return duracionMeses;
    }

    /**
     * Método setter para establecer la duración de la suscripción en meses.
     * 
     * @param duracionMeses La duración en meses de la suscripción a establecer.
     */
    public void setDuracionMeses(int duracionMeses) {
        this.duracionMeses = duracionMeses;
    }

    /**
     * Método para calcular el costo total de la suscripción, multiplicando el precio mensual por la duración en meses.
     * 
     * @return El costo total de la suscripción.
     */
    public double calcularCostoTotal() {
        return precioMensual * duracionMeses;
    }

    /**
     * Método para agregar una sucursal a la lista de sucursales a las que el cliente tiene acceso.
     * 
     * Si el número de sucursales registradas no supera la capacidad máxima, la sucursal se agrega al array.
     * En caso contrario, se muestra un mensaje indicando que la capacidad ha sido alcanzada.
     * 
     * @param sucursal La sucursal que se desea agregar.
     */
    protected void agregarSucursal(String sucursal) {
        if (sucursalesRegistradas < capacidadSucursales) {
            sucursalesAcceso[sucursalesRegistradas] = sucursal;  // Añade la sucursal al array
            sucursalesRegistradas++;  // Incrementa el contador de sucursales registradas
        } else {
            System.out.println("No se puede agregar más sucursales. Capacidad máxima alcanzada.");
        }
    }

    /**
     * Método para verificar si el cliente tiene acceso a una sucursal específica.
     * 
     * Compara el nombre de la sucursal con las sucursales registradas en la suscripción.
     * 
     * @param sucursal El nombre de la sucursal que se desea verificar.
     * @return true si tiene acceso a la sucursal, false en caso contrario.
     */
    public boolean tieneAccesoASucursal(String sucursal) {
        // Recorre las sucursales registradas y verifica si la sucursal está en la lista
        for (int i = 0; i < sucursalesRegistradas; i++) {
            if (sucursalesAcceso[i].equals(sucursal)) {
                return true;  // Si la sucursal se encuentra, retorna true
            }
        }
        return false;  // Si no se encuentra, retorna false
    }

    /**
     * Método toString para representar la suscripción como una cadena.
     * 
     * Este método muestra el nombre de la suscripción, el precio mensual, la duración y las sucursales a las que tiene acceso.
     * 
     * @return Una representación en formato String de la suscripción.
     */
    @Override
    public String toString() {
        // Construye una cadena con las sucursales a las que tiene acceso
        StringBuilder sucursales = new StringBuilder("[");
        for (int i = 0; i < sucursalesRegistradas; i++) {
            sucursales.append(sucursalesAcceso[i]);
            if (i < sucursalesRegistradas - 1) {
                sucursales.append(", ");
            }
        }
        sucursales.append("]");
        
        // Retorna una representación completa del objeto Suscripcion
        return "Suscripcion{"
                + "nombre='" + nombre + '\''
                + ", precioMensual=" + precioMensual
                + ", duracionMeses=" + duracionMeses
                + ", sucursalesAcceso=" + sucursales.toString()
                + '}';
    }
}
