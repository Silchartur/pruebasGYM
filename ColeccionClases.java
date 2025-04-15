
import java.util.*;
/**
* Clase ColeccionClases
*
* Contiene la lista de las clases del gimnasio, asi como las acciones generales que se realizaran en el main
*
* @author Esther Díaz
* @version 1.0, 2025-04-14
*/
public class ColeccionClases {
    
    private ArrayList <Clase> clases;

    /**
     * Constructor por defecto
     */
    public ColeccionClases() {

        clases = new ArrayList <Clase>();
    }

    /**
     * Introduce una clase en la lista de clases
     * 
     * @param c clase
     */
    public void anyadirClase(Clase c) {

        clases.add(c);
    }

    /**
     * Devuelve la clase que hay en una determinada posicion
     * 
     * @param pos posicion de la clase
     * @return clase que esta en esa posicion
     */
    public Clase getClase(int pos) {

        return clases.get(pos);
    }

    /**
    * Muestra todas las clases registradas. Si no hay clases registradas, muestra un mensaje indicando que no hay clases.
    * Las clases se muestran ordenadas por su fecha y horario.
    */
    public void mostrarClases() {

        if(clases.isEmpty()) {
            System.out.println("No hay clases registradas");
        } else {
            clases.sort(Comparator.comparing(Clase::getFechaHorario));

            for(Clase c : clases) {
                System.out.println(c);
                System.out.println("-----------------------------------");
            }
        }
    }

    /**
     * Muestra todas las clases en las que esta inscrito un cliente
     * @param cliente que esta inscrito
     */
    public void mostrarClasesCliente(Cliente cliente) {

        for (Clase c: clases) {

            if(c.getClientesInscritos().contains(cliente)) {
                System.out.println(c);
                System.out.println("-----------------------------------");
            }
        }
    }

    /**
    * Busca una clase por su nombre. 
    * 
    * @param nombre El nombre de la clase a buscar.
    * @return la posición de la clase en la lista si se encuentra, o -1 si no se encuentra.
    */
    public int buscarClase(String nombre) {
        int pos = -1;

        for(int i = 0; i < clases.size(); i++) {
            
            if(clases.get(i).getNombre().equalsIgnoreCase(nombre)) {
                pos = i;
            }
        }

        return pos;
    }

    /**
     * Borrar una clase por su nombre
     * @param nombre de la clase a borrar
     */
    public void borrarClase(String nombre) {
        int pos = buscarClase(nombre);

        if(pos != -1) {
            clases.remove(pos);
        } else {
            System.out.println("Clase no encontrada");
        }
    }

    /**
     * Crea una nueva clase en el sistema, solicitando al usuario los datos necesarios, como el nombre de la clase, la instalación,
     * los datos del entrenador (si existe), la fecha y hora, y el número máximo de asistentes. Luego, añade la nueva clase a la colección.
     * 
     */
    public void crearClase() {
        Scanner tec = new Scanner(System.in);

        System.out.println("Introduce el nombre de la clase: ");
        String nomClase = tec.nextLine();
                    
        System.out.println("Introduce el nombre de la instalación (sala)");
        String nomInst = tec.nextLine();
                    
        Instalacion instalacion = new Instalacion(nomInst);
                                            
        System.out.println("¿Tiene un entrenador asignado? (s/n): ");
        String entrenadorAsignado = tec.nextLine();
                    
        Empleado empleado = null;
                    
        if (entrenadorAsignado.equalsIgnoreCase("s")) {
            System.out.println("Introduce el nombre del entrenador: ");
                String nomEmpleado = tec.nextLine();

                System.out.println("Introduce su id: ");
                int idEmpleado = tec.nextInt();
                tec.nextLine();
                    
                empleado = new Empleado(nomEmpleado, idEmpleado);
        }
                    
        System.out.println("Introduce el día: ");
        int dia = tec.nextInt();
                    
        System.out.println("Introduce el mes: ");
        int mes = tec.nextInt();
                    
        System.out.println("Introduce el año: ");
        int anyo = tec.nextInt();
                    
        System.out.println("Introduce la hora: ");
        int hora = tec.nextInt();
                    
        System.out.println("Introduce los minutos: ");
        int minutos = tec.nextInt();
                    
        GregorianCalendar fechaHorario = new GregorianCalendar(anyo, mes - 1, dia, hora, minutos);
                    
        System.out.println("Introduce el número máximo de asistentes: ");
        int maxAsistentes = tec.nextInt();
        tec.nextLine();
                    
        Clase nuevaClase = new Clase(nomClase, instalacion, fechaHorario, empleado, maxAsistentes);
        anyadirClase(nuevaClase);
        System.out.println("Clase añadida correctamente");
    }

    /**
     * Modifica una clase existente. Permite al empleado modificar ciertos atributos de la clase, como la fecha y hora,
     * el nombre de la clase y la instalación asignada a la clase. La clase se busca por su nombre y se actualiza según la opción seleccionada por el usuario.
     * 
     * @param nombreClase el nombre de la clase que se quiere modificar.
     * Las modificaciones son:
     * <ul>
     *   <li>Modificar la fecha y hora de la clase.</li>
     *   <li>Cambiar el nombre de la clase.</li>
     *   <li>Actualizar la instalación donde se realiza la clase.</li>
     *   <li>Terminar o cancelar la modificación.</li>
     * </ul>
     */
    public void modificarClase(String nombreClase) {
        Scanner tec = new Scanner(System.in);

        int pos = buscarClase(nombreClase);
        
        if (pos != -1) {
            Clase clase = clases.get(pos);

            System.out.println("¿Qué quieres modificar?");
            System.out.println("1. Fecha y horario");
            System.out.println("2. Nombre");
            System.out.println("3. Instalación");
            System.out.println("0. Terminar o cancelar");
            int opcion = tec.nextInt();
            tec.nextLine();

            switch (opcion) {

                case 1:
                    System.out.println("Introduce el día: ");
                    int dia = tec.nextInt();
                    System.out.println("Introduce el mes: ");
                    int mes = tec.nextInt();
                    System.out.println("Introduce el año: ");
                    int anyo = tec.nextInt();
                    System.out.println("Introduce la hora: ");
                    int hora = tec.nextInt();
                    System.out.println("Introduce los minutos: ");
                    int minutos = tec.nextInt();
                    tec.nextLine();

                    GregorianCalendar fechaNueva = new GregorianCalendar(anyo, mes - 1, dia, hora, minutos);
                    clase.setFechaHorario(fechaNueva);

                    System.out.println("Fecha modificada correctamente");
                    break;
            
                case 2:
                    System.out.println("Introduce el nuevo nombre: ");
                    String nombreNuevo = tec.nextLine();
                    clase.setNombre(nombreNuevo);

                    System.out.println("Nombre modificado correctamente");
                    break;

                case 3:

                    System.out.println("Introduce el nombre de la instalación: ");
                    String nuevaInstalacion = tec.nextLine();
                    clase.setInstalacion(new Instalacion(nuevaInstalacion));

                    System.out.println("Instalación modificada correctamente");
                    break;

                case 0: 

                    System.out.println("Modificación terminada o cancelada");
                    break;
            }
        }
    }
    /**
     * Añade asistentes a una clase existente. Si la clase no está llena, se solicitan los datos de los nuevos asistentes y se añaden.
     * Si la clase está llena o no hay espacio suficiente, se muestra un mensaje indicandolo.
     * 
     * @param nombre el nombre de la clase a la que se desean añadir los asistentes.
     */
    public void anyadirAsistentes(String nombre) {
        Scanner tec = new Scanner(System.in);
        int pos = buscarClase(nombre);

        if(pos != -1) {
            Clase clase = clases.get(pos);
            System.out.println("¿Cuántos asistentes quieres añadir?");
            int numClientes = tec.nextInt();
            tec.nextLine();
    
            if (numClientes + clase.getNumAsistentes() > clase.getMaxAsistentes()) {
        
                System.out.println("No puedes añadir más asistentes. La clase está llena");
            } else {
        
                System.out.println("Añadir asistentes: ");
                for (int i = 0; i < numClientes; i++) {
                    System.out.println("ID: ");
                    int idUsuario = tec.nextInt();
                    tec.nextLine();
        
                    Cliente cliente = null;
                    for (Cliente c: ColeccionCliente.listaClientes) {
                        if(c.getId() == idUsuario) {
                            cliente = c;
                        }
                    }
                    
                    clase.registrarCliente(cliente);
                }

                System.out.println(numClientes + " asistentes añadidos correctamente");
            }

        } else {

            System.out.println("Clase no encontrada");
        }
    }

    /**
     * Elimina asistentes de una clase existente. Si hay suficientes asistentes registrados, solicita los datos de los asistentes a eliminar
     * (por su ID) y los elimina de la lista de inscritos en la clase.
     * 
     * @param nombre el nombre de la clase de la que se desean eliminar asistentes.
     */
    public void eliminarAsistentes(String nombre) {
        Scanner tec = new Scanner(System.in);
        int pos = buscarClase(nombre);

        if(pos != -1) {
            Clase clase = clases.get(pos);
            System.out.println("¿Cuántos asistentes quieres eliminar?");
            int numClientes = tec.nextInt();
            tec.nextLine();
    
            if (numClientes > clase.getNumAsistentes()) {
        
                System.out.println("No puedes eliminar más asistentes de los que hay inscritos");
            } else {
        
                System.out.println("Eliminar asistentes: ");
                for (int i = 0; i < numClientes; i++) {
                    System.out.println("ID: ");
                    int idUsuario = tec.nextInt();
                    tec.nextLine();
        
                    Cliente cliente = new Cliente(idUsuario);
                    clase.eliminarCliente(cliente);
                }

                System.out.println(numClientes + " asistentes eliminados correctamente");
            }

        } else {

            System.out.println("Clase no encontrada");
        }
    }

}
