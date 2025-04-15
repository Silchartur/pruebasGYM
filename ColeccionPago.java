
import java.util.*;

/**
 * Esta clase gestiona las operaciones relacionadas con los pagos de los
 * clientes, como añadir un pago a un cliente, mostrar los pagos registrados de
 * un cliente, entre otros. El menú ofrece opciones para interactuar con el
 * sistema y manejar los pagos asociados a cada cliente.
 * @author Silvia Perea
 * @date 14/04/2025
 */
public class ColeccionPago {

    Scanner scanner = new Scanner(System.in);

    ColeccionCliente coleccionCliente = new ColeccionCliente();

    /**
     * Este método gestiona las operaciones relacionadas con los pagos de los
     * clientes, presentando un menú donde se pueden elegir diferentes opciones
     * como añadir un pago o mostrar los pagos registrados de un cliente.
     */
    public void gestionarPagos() {
        int opcionPago;
        do {
            System.out.println("\n===== Gestión de Pagos =====");
            System.out.println("1. Añadir Pago a Cliente");
            System.out.println("2. Mostrar Pagos de Cliente");
            System.out.println("0. Volver al Menú Principal");
            System.out.print("Elige una opción: ");
            opcionPago = scanner.nextInt();
            scanner.nextLine();  // Limpiar el buffer

            switch (opcionPago) {
                case 1:
                    añadirPago(); // Llamada al método para añadir un pago
                    break;
                case 2:
                    mostrarPagosDeCliente(); // Llamada al método para mostrar los pagos de un cliente
                    break;
                case 0:
                    System.out.println("Volviendo al Menú Principal...");
                    break;
                default:
                    System.out.println("Opción no válida. Intenta de nuevo.");
            }
        } while (opcionPago != 0); // Se repite el menú hasta que se elige la opción 0
    }

    /**
     * Este método permite añadir un pago a un cliente existente. Primero busca
     * al cliente mediante su ID, luego solicita los detalles del pago (número,
     * forma de pago, total, fecha, y observación) y lo asocia al cliente.
     */
    public void añadirPago() {
        System.out.print("Introduce ID del Cliente: ");
        int idCliente = scanner.nextInt();
        Cliente cliente = coleccionCliente.buscarSocioPorID(idCliente); // Buscar el cliente por su ID

        if (cliente != null) {
            System.out.print("Introduce Número de Pago: ");
            int numPago = scanner.nextInt();
            scanner.nextLine();
            System.out.print("Introduce Forma de Pago (Transferencia, Tarjeta, Efectivo): ");
            String formaPago = scanner.nextLine();
            System.out.print("Introduce Total del Pago: ");
            double total = scanner.nextDouble();
            scanner.nextLine();
            System.out.print("Introduce Fecha del Pago (AAAA-MM-DD): ");
            String fecha = scanner.nextLine();
            System.out.print("Introduce Observación: ");
            String observacion = scanner.nextLine();

            // Crear un nuevo objeto Pago con los detalles proporcionados
            Pago pago = new Pago(numPago, formaPago, total, fecha, observacion);
            cliente.agregarPago(pago); // Asociar el pago al cliente

            System.out.println("Pago añadido exitosamente al cliente " + cliente.getNombre());
        } else {
            System.out.println("Cliente no encontrado."); // Si el cliente no existe
        }
    }

    /**
     * Este método muestra todos los pagos registrados para un cliente
     * específico, primero buscando al cliente por su ID, y luego mostrando los
     * pagos si existen.
     */
    public void mostrarPagosDeCliente() {
        System.out.print("Introduce ID del Cliente para ver sus pagos: ");
        int idCliente = scanner.nextInt();
        Cliente cliente = coleccionCliente.buscarSocioPorID(idCliente); // Buscar al cliente por ID

        if (cliente != null) {  // Si el cliente existe
            System.out.println("Pagos de " + cliente.getNombre() + ":");
            ArrayList<Pago> pagos = cliente.getPagos(); // Obtener la lista de pagos del cliente
            if (pagos.isEmpty()) { // Si el cliente no tiene pagos
                System.out.println("No tiene pagos registrados.");
            } else { // Si el cliente tiene pagos
                for (Pago pago : pagos) {
                    System.out.println(pago); // Mostrar los detalles de cada pago
                }
            }
        } else {
            System.out.println("Cliente no encontrado."); // Si el cliente no existe
        }
    }
}
