
import java.util.*;

/**
 * Clase ColeccionSuscripcion
 *
 * Esta clase se encarga de gestionar las suscripciones de los clientes. Permite
 * agregar nuevas suscripciones a los clientes, así como mostrar las
 * suscripciones actuales de todos los clientes.
 *
 * @author Silvia Perea
 * @date 14/04/2025
 */
public class ColeccionSuscripcion {

    Scanner scanner = new Scanner(System.in);

    // Lista de clientes que se obtiene de la clase ColeccionCliente
    ArrayList<Cliente> clientes = ColeccionCliente.listaClientes;

    /**
     * Método gestionarSuscripciones
     *
     * Este método presenta un menú interactivo para gestionar las suscripciones
     * de los clientes. El usuario puede elegir entre añadir una nueva
     * suscripción a un cliente o mostrar las suscripciones existentes.
     */
    public void gestionarSuscripciones() {
        int opcionSuscripcion;
        do {
            // Muestra el menú con las opciones disponibles
            System.out.println("\n===== Gestión de Suscripciones =====");
            System.out.println("1. Añadir Suscripción a Cliente");
            System.out.println("2. Mostrar Suscripciones");
            System.out.println("3. Mostrar por tipo de suscripción");
            System.out.println("0. Volver al Menú Principal");
            System.out.print("Elige una opción: ");
            opcionSuscripcion = scanner.nextInt();
            scanner.nextLine();  // Limpiar el buffer

            // Ejecuta la opción seleccionada por el usuario
            switch (opcionSuscripcion) {
                case 1:
                    añadirSuscripcion();  // Llamada al método para añadir una suscripción
                    break;
                case 2:
                    mostrarSuscripciones();  // Llamada al método para mostrar las suscripciones
                    break;
                case 3:
                    mostrarPorTipo();
                    break;
                case 0:
                    System.out.println("Volviendo al Menú Principal...");
                    break;
                default:
                    System.out.println("Opción no válida. Intenta de nuevo.");
            }
        } while (opcionSuscripcion != 0);  // Repite el menú hasta que el usuario elija la opción 0
    }

    /**
     * Método añadirSuscripcion
     *
     * Este método permite añadir una nueva suscripción a un cliente. Primero se
     * selecciona el cliente de la lista, luego se elige el tipo de suscripción
     * (Premium, Corporativa, Básica o Estudiantil) y finalmente se asocia esa
     * suscripción al cliente seleccionado.
     */
    public void añadirSuscripcion() {
        // Muestra la lista de clientes para que el usuario elija a quién asociar la suscripción
        System.out.println("Selecciona el cliente al que quieres asociar la suscripción:");
        for (int i = 0; i < clientes.size(); i++) {
            // Muestra el nombre de cada cliente
            System.out.println((i + 1) + ". " + clientes.get(i).getNombre());
        }
        System.out.print("Elige una opción: ");
        int opcionCliente = scanner.nextInt();
        scanner.nextLine();  // Limpiar el buffer

        // Verifica que la opción seleccionada sea válida
        if (opcionCliente < 1 || opcionCliente > clientes.size()) {
            System.out.println("Opción no válida.");
        }

        // Obtiene el cliente seleccionado
        Cliente clienteSeleccionado = clientes.get(opcionCliente - 1);

        // Menú para seleccionar el tipo de suscripción
        System.out.println("Selecciona el tipo de suscripción:");
        System.out.println("1. Premium");
        System.out.println("2. Corporativa");
        System.out.println("3. Básica");
        System.out.println("4. Estudiante");
        System.out.print("Elige una opción: ");
        int opcionSuscripcion = scanner.nextInt();
        scanner.nextLine();  // Limpiar el buffer

        // Variable para almacenar la suscripción seleccionada
        Suscripcion nuevaSuscripcion = null;

        // Se crea la suscripción según la opción seleccionada
        switch (opcionSuscripcion) {
            case 1:
                nuevaSuscripcion = new SuscripcionPremium();  // Suscripción Premium
                break;
            case 2:
                // Si es una suscripción Corporativa, pide el número de empleados
                System.out.print("Introduce el número de empleados para la suscripción corporativa: ");
                int numeroEmpleados = scanner.nextInt();
                nuevaSuscripcion = new SuscripcionCorporativa(numeroEmpleados);  // Suscripción Corporativa
                break;
            case 3:
                nuevaSuscripcion = new SuscripcionBasica();  // Suscripción Básica
                break;
            case 4:
                // Si es una suscripción Estudiantil, pide el porcentaje de descuento
                System.out.print("Introduce el porcentaje de descuento para la suscripción estudiantil: ");
                double descuento = scanner.nextDouble();
                nuevaSuscripcion = new SuscripcionEstudiante(descuento);  // Suscripción Estudiante
                break;
            default:
                System.out.println("Opción no válida.");
                break;
        }

        // Asocia la suscripción creada al cliente seleccionado
        if (nuevaSuscripcion != null) {
            clienteSeleccionado.setSuscripcion(nuevaSuscripcion);
            System.out.println("Suscripción " + nuevaSuscripcion.getNombre() + " asociada a "
                    + clienteSeleccionado.getNombre() + " exitosamente.");
        }
    }

    /**
     * Método mostrarSuscripciones
     *
     * Este método muestra las suscripciones asociadas a cada cliente. Recorre
     * la lista de clientes y si un cliente tiene una suscripción activa,
     * muestra el nombre del cliente y el tipo de suscripción. Si no hay
     * suscripciones activas, informa al usuario de que no existen
     * suscripciones.
     */
    public void mostrarSuscripciones() {
        boolean encontrado = false;  // Bandera para verificar si se encontraron suscripciones
        for (Cliente cliente : clientes) {
            // Si el cliente tiene una suscripción
            if (cliente.getSuscripcion() != null) {
                System.out.println(cliente.getNombre() + " tiene una suscripción de tipo: "
                        + cliente.getSuscripcion().getNombre());  // Muestra la suscripción
                encontrado = true;  // Marca que se ha encontrado al menos una suscripción
            }
        }

        // Si no se encuentran suscripciones, muestra un mensaje indicando que no hay suscripciones activas
        if (!encontrado) {
            System.out.println("No hay suscripciones activas en el sistema.");
        }
    }

    /**
     * Muestra los clientes agrupados por tipo de suscripción.
     */
    public void mostrarPorTipo() {
        System.out.println("\n=== Clientes con Suscripción Premium ===");
        for (Cliente cliente : clientes) {
            if (cliente.getSuscripcion() instanceof SuscripcionPremium) {
                System.out.println("- " + cliente.getNombre());
            }
        }

        System.out.println("\n=== Clientes con Suscripción Corporativa ===");
        for (Cliente cliente : clientes) {
            if (cliente.getSuscripcion() instanceof SuscripcionCorporativa) {
                System.out.println("- " + cliente.getNombre());
            }
        }

        System.out.println("\n=== Clientes con Suscripción Básica ===");
        for (Cliente cliente : clientes) {
            if (cliente.getSuscripcion() instanceof SuscripcionBasica) {
                System.out.println("- " + cliente.getNombre());
            }
        }

        System.out.println("\n=== Clientes con Suscripción Estudiante ===");
        for (Cliente cliente : clientes) {
            if (cliente.getSuscripcion() instanceof SuscripcionEstudiante) {
                System.out.println("- " + cliente.getNombre());
            }
        }
    }

}
