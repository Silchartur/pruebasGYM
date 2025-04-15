
import java.util.ArrayList;

/**
 * Clase Pago
 * 
 * Representa un pago realizado por un cliente, con información sobre el número de pago, la forma de pago, el total, 
 * la fecha y las observaciones. Además, incluye métodos para agregar pagos a una lista y obtener información sobre ellos.
 */
public class Pago {

    private int numPago;          // Número de identificación del pago
    private String formaPago;     // Forma de pago (Ej. Transferencia, Tarjeta, Efectivo)
    private double total;         // Total del pago realizado
    private String fecha;         // Fecha del pago
    private String observacion;   // Observaciones adicionales sobre el pago

    // Lista de pagos, en caso de que se manejen múltiples pagos en esta clase
    private ArrayList<Pago> pagos;

    /**
     * Constructor de la clase Pago.
     * 
     * Inicializa los atributos con los valores proporcionados y crea una lista vacía de pagos.
     * 
     * @param numPago        El número de pago
     * @param formaPago      La forma de pago
     * @param total          El total del pago
     * @param fecha          La fecha del pago
     * @param observacion    Las observaciones sobre el pago
     */
    public Pago(int numPago, String formaPago, double total, String fecha, String observacion) {
        this.numPago = numPago;
        this.formaPago = formaPago;
        this.total = total;
        this.fecha = fecha;
        this.observacion = observacion;
        this.pagos = new ArrayList<>(); // Inicializa la lista de pagos
    }

    // Métodos getter y setter para los atributos de la clase

    /**
     * Método getter para obtener el número de pago.
     * 
     * @return El número de pago.
     */
    public int getNumPago() {
        return numPago;
    }

    /**
     * Método setter para establecer el número de pago.
     * 
     * @param numPago El número de pago a establecer.
     */
    public void setNumPago(int numPago) {
        this.numPago = numPago;
    }

    /**
     * Método getter para obtener la forma de pago.
     * 
     * @return La forma de pago.
     */
    public String getFormaPago() {
        return formaPago;
    }

    /**
     * Método setter para establecer la forma de pago.
     * 
     * @param formaPago La forma de pago a establecer.
     */
    public void setFormaPago(String formaPago) {
        this.formaPago = formaPago;
    }

    /**
     * Método getter para obtener el total del pago.
     * 
     * @return El total del pago.
     */
    public double getTotal() {
        return total;
    }

    /**
     * Método setter para establecer el total del pago.
     * 
     * @param total El total del pago a establecer.
     */
    public void setTotal(double total) {
        this.total = total;
    }

    /**
     * Método getter para obtener la fecha del pago.
     * 
     * @return La fecha del pago.
     */
    public String getFecha() {
        return fecha;
    }

    /**
     * Método setter para establecer la fecha del pago.
     * 
     * @param fecha La fecha del pago a establecer.
     */
    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    /**
     * Método getter para obtener las observaciones sobre el pago.
     * 
     * @return Las observaciones sobre el pago.
     */
    public String getObservacion() {
        return observacion;
    }

    /**
     * Método setter para establecer las observaciones sobre el pago.
     * 
     * @param observacion Las observaciones a establecer.
     */
    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }

    /**
     * Método para agregar un pago a la lista de pagos.
     * 
     * @param pago El objeto de tipo Pago que se desea agregar a la lista.
     */
    public void agregarPago(Pago pago) {
        pagos.add(pago);
    }

    /**
     * Método para obtener la lista de pagos.
     * 
     * @return La lista de pagos asociados a este objeto.
     */
    public ArrayList<Pago> getPagos() {
        return pagos;
    }

    /**
     * Método toString para representar el objeto Pago como un String.
     * 
     * @return Una cadena que representa todos los detalles del pago.
     */
    @Override
    public String toString() {
        return "Pago{" +
                "numPago=" + numPago +
                ", formaPago='" + formaPago + '\'' +
                ", total=" + total +
                ", fecha='" + fecha + '\'' +
                ", observacion='" + observacion + '\'' +
                '}';
    }
}
