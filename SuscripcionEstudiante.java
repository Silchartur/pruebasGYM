
/**
 * Esta clase representa una suscripción para estudiantes, que hereda de la clase {@link Suscripcion}.
 * La suscripción estudiantil permite el acceso a hasta dos sucursales y tiene
 * un descuento aplicado al costo total de la suscripción.
 *
 * @author Silvia Perea
 * @date 14/04/2025
 */
class SuscripcionEstudiante extends Suscripcion {

    private double descuento;

    /**
     * Constructor de la clase SuscripcionEstudiante.
     *
     * Inicializa la suscripción con el nombre "Estudiante", precio mensual de
     * 20.0, duración de 1 mes y capacidad para 2 sucursales. Además, asigna
     * acceso a dos sucursales: "Sucursal Principal" y "Sucursal Norte".
     *
     * @param descuento El descuento aplicado a la suscripción, en porcentaje.
     */
    public SuscripcionEstudiante(double descuento) {
        super("Estudiante", 20.0, 1, 2); // Llama al constructor de la clase base Suscripcion
        this.descuento = descuento;
        agregarSucursal("Sucursal Principal"); // Acceso a la Sucursal Principal
        agregarSucursal("Sucursal Norte");   // Acceso a la Sucursal Norte
    }

    /**
     * Obtiene el descuento de la suscripción estudiantil.
     *
     * @return El descuento aplicado a la suscripción en porcentaje.
     */
    public double getDescuento() {
        return descuento;
    }

    /**
     * Establece el descuento de la suscripción estudiantil.
     *
     * @param descuento El descuento que se desea aplicar en la suscripción, en
     * porcentaje.
     */
    public void setDescuento(double descuento) {
        this.descuento = descuento;
    }

    /**
     * Método para calcular el costo total de la suscripción estudiantil.
     *
     * El costo total se calcula primero obteniendo el costo sin descuento y
     * luego aplicando el descuento correspondiente.
     *
     * @return El costo total de la suscripción con el descuento aplicado.
     * @see Suscripcion#calcularCostoTotal() Para ver cómo se calcula el costo
     * total en la clase base {@link Suscripcion}.
     */
    @Override
    public double calcularCostoTotal() {
        double costoSinDescuento = super.calcularCostoTotal(); // Obtiene el costo sin descuento
        return costoSinDescuento - (costoSinDescuento * descuento / 100); // Aplica el descuento
    }

    /**
     * Método toString sobrescrito.
     *
     * Devuelve una representación en formato String de la suscripción
     * estudiantil, incluyendo los detalles de la suscripción heredados de la
     * clase {@link Suscripcion} y el descuento aplicado.
     *
     * @return Una cadena que representa la suscripción estudiantil con los
     * detalles heredados y el descuento aplicado.
     */
    @Override
    public String toString() {
        return "SuscripcionEstudiante{"
                + "descuento=" + descuento
                + ", " + super.toString()
                + // Llama al toString de la clase base Suscripcion
                '}';
    }
}
