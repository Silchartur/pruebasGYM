
/**
 * Esta clase representa una suscripción corporativa, que hereda de la clase {@link Suscripcion}.
 * La suscripción corporativa permite el acceso a hasta tres sucursales y se
 * basa en el número de empleados para calcular el costo total de la
 * suscripción.
 *
 * @author Silvia Perea
 * @date 14/04/2025
 */
class SuscripcionCorporativa extends Suscripcion {

    private int numeroEmpleados;

    /**
     * Constructor de la clase SuscripcionCorporativa.
     *
     * Inicializa la suscripción con el nombre "Corporativa", precio mensual de
     * 100.0, duración de 1 mes y capacidad para 3 sucursales. Además, asigna
     * acceso a tres sucursales: "Sucursal Principal", "Sucursal Centro" y
     * "Sucursal Empresarial".
     *
     * @param numeroEmpleados Número de empleados de la empresa que contratará
     * la suscripción.
     */
    public SuscripcionCorporativa(int numeroEmpleados) {
        super("Corporativa", 100.0, 1, 3); // Llama al constructor de la clase base Suscripcion, configurando el nombre, precio, duración y capacidad de sucursales
        this.numeroEmpleados = numeroEmpleados;
        agregarSucursal("Sucursal Principal"); // Acceso a la Sucursal Principal
        agregarSucursal("Sucursal Centro");   // Acceso a la Sucursal Centro
        agregarSucursal("Sucursal Empresarial"); // Acceso a la Sucursal Empresarial
    }

    /**
     * Obtiene el número de empleados para la suscripción corporativa.
     *
     * @return El número de empleados registrados en la suscripción corporativa.
     */
    public int getNumeroEmpleados() {
        return numeroEmpleados;
    }

    /**
     * Establece el número de empleados para la suscripción corporativa.
     *
     * @param numeroEmpleados El número de empleados que se desea establecer.
     */
    public void setNumeroEmpleados(int numeroEmpleados) {
        this.numeroEmpleados = numeroEmpleados;
    }

    /**
     * Método para calcular el costo total de la suscripción corporativa.
     *
     * El costo total se calcula multiplicando el costo mensual por el número de
     * empleados.
     *
     * @return El costo total de la suscripción corporativa.
     * @see Suscripcion#calcularCostoTotal() Para ver cómo se calcula el costo
     * total en la clase base {@link Suscripcion}.
     */
    @Override
    public double calcularCostoTotal() {
        return super.calcularCostoTotal() * numeroEmpleados;
    }

    /**
     * Método toString sobrescrito.
     *
     * Devuelve una representación en formato String de la suscripción
     * corporativa, incluyendo los detalles de la suscripción heredados de la
     * clase {@link Suscripcion} y el número de empleados.
     *
     * @return Una cadena que representa la suscripción corporativa con los
     * detalles heredados..
     */
    @Override
    public String toString() {
        return "SuscripcionCorporativa{"
                + "numeroEmpleados=" + numeroEmpleados
                + ", " + super.toString()
                + '}';
    }
}
