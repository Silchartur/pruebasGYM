
// Clase SuscripcionBasica que extiende de la clase Suscripcion
/**
 * Esta clase representa una suscripción básica que hereda de la clase
 * {@link Suscripcion}.
 * La suscripción básica tiene un precio mensual fijo y solo da acceso a una
 * sucursal específica.
 * 
 * @author Silvia Perea
 * @date 14/04/2025
 */
class SuscripcionBasica extends Suscripcion {

    /**
     * Constructor de la clase SuscripcionBasica.
     * 
     * Inicializa la suscripción con el nombre "Básica", precio mensual de 20.0,
     * duración de 1 mes y capacidad para 1 sucursal.
     * También asigna acceso a la "Sucursal Principal" al momento de crear la
     * suscripción.
     * 
     */
    public SuscripcionBasica() {
        super("Básica", 20.0, 1, 1); // Llama al constructor de la clase base Suscripcion, configurando el nombre,
                                     // precio, duración y capacidad de sucursales
        this.agregarSucursal("Sucursal Principal"); // Acceso solo a la sucursal principal
    }

    /**
     * Método toString sobrescrito.
     * 
     * Devuelve una representación en formato String de la suscripción básica,
     * incluyendo
     * los detalles de la suscripción heredados de la clase {@link Suscripcion}.
     * 
     * @return Una cadena que representa la suscripción básica con los detalles
     *         heredados.
     */
    @Override
    public String toString() {
        return "SuscripcionBasica{" +
                super.toString() + // Llama al método toString de la clase base Suscripcion para incluir sus
                                   // detalles
                '}'; // Devuelve la cadena de texto que representa la suscripción básica
    }
}
