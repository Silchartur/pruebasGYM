
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;

/**
 * Esta clase gestiona las operaciones relacionadas con los clientes, como
 * añadir, borrar, modificar, buscar y mostrar la lista completa de clientes. La
 * interacción con el usuario se realiza a través de un menú que permite
 * seleccionar la opción deseada para gestionar los clientes. Los datos se
 * capturan mediante el objeto Scanner y se almacenan en una lista.
 *
 * @author Silvia Perea
 * @date 14/04/2025
 */
public class ColeccionCliente {

    Scanner scanner = new Scanner(System.in);
    static ArrayList<Cliente> listaClientes = new ArrayList<>();

    /**
     * Método principal para gestionar las opciones del cliente
     */
    public void gestionarClientes() {
        int opcionCliente;
        do {
            System.out.println("\n===== Gestión de Clientes =====");
            System.out.println("1. Añadir Cliente");
            System.out.println("2. Borrar Cliente");
            System.out.println("3. Modificar Cliente");
            System.out.println("4. Buscar Cliente");
            System.out.println("5. Mostrar Todos los Clientes");
            System.out.println("0. Volver al Menú Principal");
            System.out.print("Elige una opción: ");
            opcionCliente = scanner.nextInt();
            scanner.nextLine();

            switch (opcionCliente) {
                case 1:
                    añadirCliente();
                    break;
                case 2:
                    borrarCliente();
                    break;
                case 3:
                    modificarCliente();
                    break;
                case 4:
                    buscarCliente();
                    break;
                case 5:
                    mostrarClientes();
                    break;
                case 0:
                    System.out.println("Volviendo al Menú Principal...");
                    break;
                default:
                    System.out.println("Opción no válida. Intenta de nuevo.");
            }
        } while (opcionCliente != 0);
    }

    /**
     * Método para gestionar las opciones relacionadas con la membresía de un
     * cliente. Permite modificar el perfil o tipo de suscripción.
     */
    public void gestionarMembresia() {
        int opcion;
        do {
            System.out.println("Gestión de membresía: \n 1. Modificar perfil \n 2. Modificar suscripción");
            opcion = scanner.nextInt();
            scanner.nextLine();
            switch (opcion) {
                case 1:
                    modificarHechaPorElCliente();
                    break;
                case 2:
                    modificarTipoSuscripcion();
                    break;
                case 0:
                    System.out.println("Saliendo de la gestión de membresía.");
                    break;
                default:
                    System.out.println("Entrada incorrecta, prueba otra vez.");
                    break;
            }
        } while (opcion != 0);

    }

    /**
     * Método para modificar los datos de contacto de un cliente, como el número
     * de teléfono y el email.
     */
    public void modificarHechaPorElCliente() {
        System.out.print("Introduce tu id: ");
        int id = scanner.nextInt();
        Cliente cliente = buscarSocioPorID(id);
        if (cliente != null) {
            System.out.print("Introduce el nuevo número de teléfono: ");
            cliente.setTelefono(scanner.nextLine());
            System.out.print("Introduce el nuevo email:");
            cliente.setEmail(scanner.nextLine());
            System.out.println("Cambios guardados");
        } else {
            System.out.println("Introduce tu id de nuevo por favor.");
        }
    }

    /**
     * Método para modificar el tipo de suscripción de un cliente.
     */
    public void modificarTipoSuscripcion() {
        Scanner scanner = new Scanner(System.in);

        // Solicitar el ID del cliente
        System.out.print("Introduce tu ID: ");
        int idCliente = scanner.nextInt();

        // Buscar cliente por ID
        Cliente clienteEncontrado = null;
        for (Cliente cliente : listaClientes) {
            if (cliente.getId() == idCliente) {
                clienteEncontrado = cliente;
            }
        }

        if (clienteEncontrado != null) {

            System.out.println("Elige tu nuevo tipo de suscripción");
            System.out.println("1. Básica");
            System.out.println("2. Premium");
            System.out.println("3. Corporativa");
            System.out.println("4. Estudiante");

            int eleccion = scanner.nextInt();
            Suscripcion nuevaSuscripcion = null;

            switch (eleccion) {
                case 1:
                    nuevaSuscripcion = new SuscripcionBasica();
                    break;
                case 2:
                    nuevaSuscripcion = new SuscripcionPremium();
                    break;
                case 3:
                    System.out.print("Introduce el número de empleados: ");
                    int empleados = scanner.nextInt();
                    nuevaSuscripcion = new SuscripcionCorporativa(empleados);
                    break;
                case 4:
                    System.out.println("Introduce el tipo de estudio: \n 1. Universidad \n 2. E.S.O. \n 3. FP");
                    int opcionEstudio = scanner.nextInt();
                    double descuento = 0;
                    switch (opcionEstudio) {
                        case 1:
                            descuento = 10;
                            break;
                        case 2:
                            descuento = 20;
                            break;
                        case 3:
                            descuento = 30;
                            break;
                        default:
                            System.out.println("Opción no válida. Asignando descuento por defecto de 0.");
                            descuento = 0;
                            break;
                    }

                    nuevaSuscripcion = new SuscripcionEstudiante(descuento);
                default:
                    System.out.println("Opción no válida.");
                    break;
            }

            // Modificar la suscripción
            clienteEncontrado.setSuscripcion(nuevaSuscripcion);
            System.out.println("Tu suscripción ha sido modificada a " + nuevaSuscripcion.getClass().getSimpleName());
        } else {
            System.out.println("No se ha podido encontrar.");
        }
    }

    /**
     * Método para añadir un nuevo cliente a la lista
     */
    public void añadirCliente() {
        System.out.print("Introduce ID del Cliente: ");
        String id = scanner.nextLine();
        System.out.print("Introduce Nombre: ");
        String nombre = scanner.nextLine();
        System.out.print("Introduce Apellido: ");
        String apellido = scanner.nextLine();
        System.out.print("Introduce Email: ");
        String email = scanner.nextLine();
        System.out.print("Introduce Teléfono: ");
        String telefono = scanner.nextLine();
        System.out.print("Introduce Fecha de Nacimiento (AAAA): ");
        int fechaNacimiento = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Introduce Estado de Salud: ");
        String estadoSalud = scanner.nextLine();

        // Mostrar opciones de suscripción
        System.out.println("Seleccione el tipo de suscripción:");
        System.out.println("1. Básica");
        System.out.println("2. Corporativa");
        System.out.println("3. Estudiante");
        System.out.println("4. Premium");
        int opcionSuscripcion = scanner.nextInt();
        scanner.nextLine();

        Suscripcion suscripcion = null;

        // Seleccionar el tipo de suscripción basado en la opción
        switch (opcionSuscripcion) {
            case 1:
                suscripcion = new SuscripcionBasica();
                break;
            case 2:
                System.out.print("Introduce el número de empleados: ");
                int empleados = scanner.nextInt();
                suscripcion = new SuscripcionCorporativa(empleados);
                break;
            case 3:
                System.out.print("Introduce el descuento: ");
                double descuento = scanner.nextDouble();
                suscripcion = new SuscripcionEstudiante(descuento);
                break;
            case 4:
                suscripcion = new SuscripcionPremium();
                break;
            default:
                System.out.println("Opción no válida. Creando suscripción Básica por defecto.");
                suscripcion = new SuscripcionBasica();
                break;
        }

        System.out.print("Introduce Fecha Inicio Suscripción (AAAAMMDD): ");
        int fechaInicioSuscripcion = scanner.nextInt();
        System.out.print("Introduce Fecha Fin Suscripción (AAAAMMDD): ");
        int fechaFinSuscripcion = scanner.nextInt();
        scanner.nextLine();
        System.out.print("¿Está activa la suscripción? (true/false): ");
        boolean suscripcionActiva = scanner.nextBoolean();
        scanner.nextLine();

        Cliente cliente = new Cliente(opcionSuscripcion, nombre, apellido, email, telefono, fechaNacimiento,
                estadoSalud, suscripcion, fechaInicioSuscripcion, fechaFinSuscripcion, suscripcionActiva);
        listaClientes.add(cliente);
        System.out.println("Cliente añadido exitosamente.");
    }

    /**
     * Método para borrar un cliente de la lista
     */
    public void borrarCliente() {
        System.out.print("Introduce el ID del cliente a borrar: ");
        int id = scanner.nextInt();
        Cliente cliente = buscarSocioPorID(id);
        if (cliente != null) {
            listaClientes.remove(cliente);
            System.out.println("Cliente borrado exitosamente.");
        } else {
            System.out.println("Cliente no encontrado.");
        }
    }

    /**
     * Método para modificar los datos de un cliente
     */
    public void modificarCliente() {
        System.out.print("Introduce el ID del cliente a modificar: ");
        int id = scanner.nextInt();
        Cliente cliente = buscarSocioPorID(id);
        if (cliente != null) {
            System.out.println("Cliente encontrado. Modificando...");
            System.out.print("Introduce nuevo nombre: ");
            cliente.setNombre(scanner.nextLine());
            System.out.print("Introduce nuevo apellido: ");
            cliente.setApellido(scanner.nextLine());
            System.out.println("Cliente modificado exitosamente.");
        } else {
            System.out.println("Cliente no encontrado.");
        }
    }

    /**
     * Método para buscar un cliente por su ID
     */
    public void buscarCliente() {
        System.out.print("Introduce el ID del cliente a buscar: ");
        int id = scanner.nextInt();
        Cliente cliente = buscarSocioPorID(id);
        if (cliente != null) {
            System.out.println("Cliente encontrado: " + cliente);
        } else {
            System.out.println("Cliente no encontrado.");
        }
    }

    /**
     * Método para mostrar todos los clientes registrados
     */
    public void mostrarClientes() {
        if (listaClientes.isEmpty()) {
            System.out.println("No hay clientes registrados.");
        } else {
            System.out.println("\n===== Lista de Clientes =====");
            for (Cliente cliente : listaClientes) {
                System.out.println(cliente);
            }
        }
    }

    /**
     * Método para buscar un cliente por su ID en la lista de clientes
     *
     * @param id ID del cliente a buscar
     * @return Cliente encontrado o null si no existe
     */
    public Cliente buscarSocioPorID(int id) {
        Cliente encontrado = null;

        for (Cliente socio : listaClientes) {
            if (socio.getId() == id) {
                encontrado = socio;
            }
        }

        return encontrado;
    }

    /**
     * Guarda la lista de clientes en un archivo CSV.
     *
     * Este método recorre la lista de clientes y, para cada uno, extrae sus
     * datos (ID, nombre, apellido, email, teléfono, fecha de nacimiento, estado
     * de salud, tipo de suscripción, fechas de inicio y fin de suscripción, y
     * si la suscripción está activa) y los escribe en un archivo CSV
     * especificado por la ruta pasada como argumento. Si la suscripción es del
     * tipo Corporativa o Estudiante, también guarda un dato adicional
     * dependiendo del tipo de suscripción.
     *
     * El archivo CSV generado tendrá el siguiente formato:
     * id,nombre,apellido,email,telefono,fechaNacimiento,estadoSalud,tipoSuscripcion,datoExtra,fechaInicio,fechaFin,activa
     *
     * @param rutaFichero La ruta del archivo CSV donde se guardarán los
     * clientes.
     */
    public void guardarClientesEnCSV(String rutaFichero) {
        try (PrintWriter pw = new PrintWriter(new FileWriter(rutaFichero))) {
            for (Cliente cliente : listaClientes) {
                int id = cliente.getId();
                String nombre = cliente.getNombre();
                String apellido = cliente.getApellido();
                String email = cliente.getEmail();
                String telefono = cliente.getTelefono();
                int fechaNacimiento = cliente.getFechaNacimiento();
                String estadoSalud = cliente.getEstadoSalud();
                int tipoSuscripcion = cliente.getTipoSuscripcion();
                int fechaInicio = cliente.getFechaInicioSuscripcion();
                int fechaFin = cliente.getFechaFinSuscripcion();
                boolean activa = cliente.isSuscripcionActiva();

                String datoExtra = "0";
                Suscripcion sus = cliente.getSuscripcion();
                if (sus instanceof SuscripcionCorporativa) {
                    datoExtra = String.valueOf(((SuscripcionCorporativa) sus).getNumeroEmpleados());
                } else if (sus instanceof SuscripcionEstudiante) {
                    datoExtra = String.valueOf(((SuscripcionEstudiante) sus).getDescuento());
                }

                pw.println(id + "," + nombre + "," + apellido + "," + email + "," + telefono + ","
                        + fechaNacimiento + "," + estadoSalud + "," + tipoSuscripcion + "," + datoExtra + ","
                        + fechaInicio + "," + fechaFin + "," + activa);
            }
            System.out.println("Clientes guardados correctamente en el fichero.");
        } catch (IOException e) {
            System.out.println("Error al guardar en el fichero: " + e.getMessage());
        }
    }

    /**
     * Lee la lista de clientes desde un archivo CSV y la carga en la lista de
     * clientes.
     *
     * Este método lee el archivo CSV especificado por la ruta pasada como
     * argumento, y por cada línea en el archivo, extrae los datos
     * correspondientes a cada cliente (ID, nombre, apellido, email, teléfono,
     * fecha de nacimiento, estado de salud, tipo de suscripción, fechas de
     * inicio y fin de suscripción, y si la suscripción está activa). Luego,
     * según el tipo de suscripción, crea el objeto de suscripción adecuado y
     * asigna todos los datos al nuevo objeto `Cliente`. Finalmente, agrega el
     * cliente a la lista de clientes.
     *
     * El archivo CSV debe tener el siguiente formato:
     * id,nombre,apellido,email,telefono,fechaNacimiento,estadoSalud,tipoSuscripcion,datoExtra,fechaInicio,fechaFin,activa
     *
     * Donde: - "tipoSuscripcion" se corresponde con un número (1 para Basica, 2
     * para Corporativa, 3 para Estudiante, 4 para Premium). - Si el tipo es
     * Corporativa, se espera un número adicional para el número de empleados. -
     * Si el tipo es Estudiante, se espera un número adicional para el
     * descuento.
     *
     * @param rutaFichero La ruta del archivo CSV desde el cual se leerán los
     * datos de los clientes.
     */
    public void leerClientesDesdeCSV(String rutaFichero) {
        try (BufferedReader br = new BufferedReader(new FileReader(rutaFichero))) {
            String linea;
            while ((linea = br.readLine()) != null) {

                StringTokenizer st = new StringTokenizer(linea, ",");

                int id = Integer.parseInt(st.nextToken());
                String nombre = st.nextToken();
                String apellido = st.nextToken();
                String email = st.nextToken();
                String telefono = st.nextToken();
                int fechaNacimiento = Integer.parseInt(st.nextToken());
                String estadoSalud = st.nextToken();
                int tipoSuscripcion = Integer.parseInt(st.nextToken());
                int fechaInicio = Integer.parseInt(st.nextToken());
                int fechaFin = Integer.parseInt(st.nextToken());
                boolean activa = Boolean.parseBoolean(st.nextToken());

                Suscripcion suscripcion = null;

                switch (tipoSuscripcion) {
                    case 1:
                        suscripcion = new SuscripcionBasica();
                        break;
                    case 2:
                        int empleados = Integer.parseInt(st.nextToken());
                        suscripcion = new SuscripcionCorporativa(empleados);
                        break;
                    case 3:
                        double descuento = Double.parseDouble(st.nextToken());
                        suscripcion = new SuscripcionEstudiante(descuento);
                        break;
                    case 4:
                        suscripcion = new SuscripcionPremium();
                        break;
                    default:
                        suscripcion = new SuscripcionBasica(); // Por defecto
                        break;
                }

                Cliente cliente = new Cliente(id, nombre, apellido, email, telefono, fechaNacimiento, estadoSalud,
                        suscripcion, fechaInicio, fechaFin, activa);
                listaClientes.add(cliente);
            }
            System.out.println("Clientes cargados correctamente desde el fichero.");
        } catch (IOException e) {
            System.out.println("Error al leer el fichero: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.out.println("Error de formato en el fichero: " + e.getMessage());
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Error: faltan datos en alguna línea del fichero.");
        }
    }

}
