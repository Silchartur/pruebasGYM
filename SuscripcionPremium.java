
/**
 * Esta clase representa una suscripción premium, que hereda de la clase {@link Suscripcion}.
 * La suscripción premium permite el acceso a tres sucursales y tiene un precio
 * mensual de 50.0 con una duración de 1 mes.
 *
 * @author Silvia Perea
 * @date 14/04/2025
 */
class SuscripcionPremium extends Suscripcion {

    /**
     * Constructor de la clase SuscripcionPremium.
     *
     * Inicializa la suscripción con el nombre "Premium", precio mensual de
     * 50.0, duración de 1 mes y capacidad para 3 sucursales. Además, asigna
     * acceso a tres sucursales: "Sucursal Principal", "Sucursal Centro" y
     * "Sucursal Norte".
     *
     * @see Suscripcion#agregarSucursal(String) Para ver cómo se agregan las
     * sucursales a la suscripción.
     */
    public SuscripcionPremium() {
        super("Premium", 50.0, 1, 3); // Llama al constructor de la clase base Suscripcion
        agregarSucursal("Sucursal Principal"); // Acceso a la Sucursal Principal
        agregarSucursal("Sucursal Centro");   // Acceso a la Sucursal Centro
        agregarSucursal("Sucursal Norte");    // Acceso a la Sucursal Norte
    }

    /**
     * Método toString sobrescrito.
     *
     * Devuelve una representación en formato String de la suscripción premium,
     * incluyendo los detalles heredados de la clase {@link Suscripcion}.
     *
     * @return Una cadena que representa la suscripción premium con los detalles
     * heredados.
     */
    @Override
    public String toString() {
        return "SuscripcionPremium{"
                + super.toString()
                + // Llama al toString de la clase base Suscripcion
                '}';
    }
}
