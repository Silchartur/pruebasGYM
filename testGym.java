
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.*;

public class testGym {

    public static void main(String[] args) {
        Scanner tec = new Scanner(System.in);

        ColeccionClases colecClases = new ColeccionClases();
        ColeccionCliente coleccionCliente = new ColeccionCliente();
        ColeccionPago coleccionPago = new ColeccionPago();
        ColeccionSuscripcion coleccionSuscripcion = new ColeccionSuscripcion();
        Clase clase = new Clase();

        GregorianCalendar fechaYoga = new GregorianCalendar(2025, 04, 20, 16, 0);
        GregorianCalendar fechaSpinning = new GregorianCalendar(2025, 05, 21, 8, 30);
        GregorianCalendar fechaBody = new GregorianCalendar(2025, 04, 21, 10, 0);
        GregorianCalendar fechaFitness = new GregorianCalendar(2025, 05, 10, 12, 45);
        Instalacion instalacion = new Instalacion("Sala 1");
        Instalacion instalacion2 = new Instalacion("Sala 2");
        Instalacion instalacion3 = new Instalacion("Zona fitness");
        
        ArrayList<Cliente> clientes = ColeccionCliente.listaClientes;
        clientes.add(new Cliente(0, "Silvia", "Perea", "email@email.com", "123456", 2307, "bien", new SuscripcionBasica(), 20240101, 20241231, true));
        clientes.add(new Cliente(2, "Esther", "Díaz", "esther@email.com", "234567890", 1985, "Excelente", new SuscripcionPremium(), 20240301, 20250301, true));
        clientes.add(new Cliente(1, "David", "Llorens", "david@email.com", "345678901", 1992, "Buena", new SuscripcionBasica(), 20240115, 20250115, true));
        clientes.add(new Cliente(3, "Daniela", "Matei", "daniela@email.com", "456789012", 1988, "Muy buena", new SuscripcionEstudiante(3), 20240410, 20250410, true));
        clientes.add(new Cliente(4, "Pedro", "Pascal", "pedro@email.com", "567890123", 1975, "Excelente", new SuscripcionCorporativa(123), 20240415, 20250415, true));
        clientes.add(new Cliente(5, "Gandalf", "El Gris", "gandalf@email.com", "678901234", 1000, "Sabio", new SuscripcionPremium(), 20240101, 20250101, true));

        /* Gestion de empleados y permisos */
        Encargado.aCargoDe = new ArrayList<>();
        ArrayList<Encargado> encargados = new ArrayList<>();
        ArrayList<Empleado> empleados = new ArrayList<>();
        encargados.add(new Encargado("Sandra", "12345678X", "C/La moraleja", "1800", 1234566789));
        empleados.add(new Empleado("Pedro", "12345678XY", "C/La moraleja1", "1300", "Fitness", 23123213));
        empleados.add(new Empleado("Raúl", "12345678XH", "C/La moraleja2", "1350", "Yoga", 543534534));
        empleados.add(new Empleado("Salomón", "12345678XN", "C/La moraleja3", "1400", "Cardio", 342414));
        /* Gestion de empleados y permisos */

        colecClases.anyadirClase(new Clase("Yoga", instalacion, fechaYoga, empleados.get(1), 30));
        colecClases.anyadirClase(new Clase("Spinning", instalacion2, fechaSpinning, null, 25));
        colecClases.anyadirClase(new Clase("Fit Moves", instalacion3, fechaFitness, empleados.get(0), 10));
        colecClases.anyadirClase(new Clase("Body Combat", instalacion, fechaBody, empleados.get(2), 30));

        /* Equipos e instalaciones */
        Equipo eq = new Equipo();
        Instalacion ins = new Instalacion();
        Establecimiento est = new Establecimiento();
        ArrayList<Equipo> equipo = new ArrayList<>();
        /* Equipos e instalaciones */

        int opcion = 0, rol, maxAsistentes, dia, mes, anyo, hora, minutos, pos, idUsuario, numClientes;
        String nomClase, elementoMod, nomCliente;

        do {

            System.out.println("Bienvenido/a. Seleccione la opción: \n1. Empleado \n2. Cliente \n0. Salir");
            rol = tec.nextInt();

            do {

                if (rol == 1) { // Empleado

                    System.out.println("MENÚ OPCIONES");
                    System.out.println("1. Gestión de clases");
                    System.out.println("2. Registrar empleado");
                    System.out.println("3. Consultas");
                    System.out.println("4. Clientes");
                    System.out.println("5. Equipos e instalaciones");
                    System.out.println("0. Salir");
                    opcion = tec.nextInt();
                    tec.nextLine();

                    switch (opcion) {

                        case 1:

                            do {

                                System.out.println("OPCIONES GESTIÓN CLASES");
                                System.out.println("1. Resumen clases");
                                System.out.println("2. Consultar asistentes");
                                System.out.println("3. Modificar asistentes");
                                System.out.println("4. Crear nueva clase");
                                System.out.println("0. Salir");
                                opcion = tec.nextInt();
                                tec.nextLine();

                                switch (opcion) {

                                    case 1:

                                        do {

                                            System.out.println("LISTADO CLASES");
                                            colecClases.mostrarClases();

                                            System.out.println("OPCIONES");
                                            System.out.println("1. Editar clase");
                                            System.out.println("2. Eliminar clase");
                                            System.out.println("0. Salir");
                                            opcion = tec.nextInt();
                                            tec.nextLine();

                                            switch (opcion) {
                                                case 1:

                                                    System.out.println(
                                                            "Introduce el nombre de la clase que quieres editar: ");
                                                    nomClase = tec.nextLine();

                                                    colecClases.modificarClase(nomClase);
                                                    break;

                                                case 2:

                                                    System.out.println(
                                                            "Introduce el nombre de la clase que quieres eliminar: ");
                                                    nomClase = tec.nextLine();

                                                    colecClases.borrarClase(nomClase);
                                                    break;
                                            }

                                        } while (opcion != 0);

                                        break;

                                    case 2:

                                        System.out.println("CONSULTAR ASISTENTES");
                                        System.out.println("Introduce el nombre de la clase: ");
                                        nomClase = tec.nextLine();

                                        pos = colecClases.buscarClase(nomClase);

                                        if (pos != -1) {
                                            clase = colecClases.getClase(pos);
                                            clase.mostrarClientesInscritos();

                                        } else {
                                            System.out.println("Clase no encontrada");
                                        }

                                        break;

                                    case 3:

                                        System.out.println("MODIFICAR ASISTENTES");
                                        System.out.println("1. Eliminar asistentes");
                                        System.out.println("2. Añadir asistentes");
                                        opcion = tec.nextInt();
                                        tec.nextLine();

                                        switch (opcion) {
                                            case 1:

                                                System.out.println("ELIMINAR ASISTENTES");
                                                System.out.println("Introduce el nombre de la clase: ");
                                                nomClase = tec.nextLine();

                                                colecClases.eliminarAsistentes(nomClase);
                                                break;

                                            case 2:

                                                System.out.println("AÑADIR ASISTENTES");
                                                System.out.println("Introduce el nombre de la clase: ");
                                                nomClase = tec.nextLine();

                                                colecClases.anyadirAsistentes(nomClase);
                                                break;
                                        }

                                        break;

                                    case 4:

                                        System.out.println("CREAR NUEVA CLASE");
                                        colecClases.crearClase();

                                        break;

                                    case 0:

                                        System.out.println("Salir");
                                        break;

                                }

                            } while (opcion != 0);
                            break;

                        case 2: // registrar empleado
                            System.out.println("---------------");
                            System.out.println("Introduzca su ID y su nombre: ");
                            System.out.println("Id:");
                            int iDsolicit = tec.nextInt();
                            System.out.println("Nombre:");
                            String nomSolicit = tec.next();
                            int log = ColeccionSub2.buscarTrabajador(encargados, nomSolicit, iDsolicit);
                            if (ColeccionSub2.logueoCorrecto(log) == !true) {
                                System.out.println("---------------");
                                System.out.println("-LOGUEO INCORRECTO-,");
                                System.out.println("Solo un Encargado puede registrar nuevos empleados!");
                                System.out.println("---------------");
                            } else {
                                System.out.println("---------------");
                                System.out.println("Introduzca los datos del nuevo empleado:");
                                System.out.println("Nombre: ");
                                String nombreNew = tec.next();
                                System.out.println("Nif: ");
                                String nifNew = tec.next();
                                System.out.println("Dirección: ");
                                String direcNew = tec.next();
                                System.out.println("Especialidad: ");
                                String specialNew = tec.next();
                                System.out.println("Teléfono: ");
                                int phoneNew = tec.nextInt();
                                System.out.println("Sueldo: ");
                                String sueldoNew = tec.next();

                                Empleado novicio = new Empleado(nombreNew, nifNew, direcNew, sueldoNew, specialNew,
                                        phoneNew);
                                Encargado.aCargoDe.add(novicio);
                                System.out.println("Empleado añadido satisfactoriamente! Bienvenido!");
                                System.out.println("---------------");
                            }

                            break;

                        case 3:

                            do {
                                System.out.println("------CONSULTAS------");
                                System.out.println("1. Suscripciones");
                                System.out.println("2. Horario");
                                System.out.println("3. Permisos");
                                System.out.println("4. Equipos e instalaciones");
                                System.out.println("0. Salir");
                                opcion = tec.nextInt();
                                tec.nextLine();

                                switch (opcion) {
                                    case 1:
                                        System.out.println("Gestionar suscripciones:");
                                        coleccionSuscripcion.gestionarSuscripciones();
                                        break;
                                    case 2:
                                        int select;
                                            do {
                                                System.out.println("------HORARIOS------");
                                                System.out.println("1. Consultar horario");
                                                System.out.println("2. Cambiar horario");
                                                System.out.println("0. Salir");
                                                select = tec.nextInt();
                                                switch (select) {
                                                case 1:
                                                    System.out.println("Introduzca su ID y su nombre: ");
                                                    System.out.println("Id:");
                                                    int iDsolicit1 = tec.nextInt();
                                                    System.out.println("Nombre:");
                                                    String nomSolicit1 = tec.next();
                                                    int busc = ColeccionSub2.buscarTrabajador(encargados, nomSolicit1, iDsolicit1);
                                                    if (busc == -1) {
                                                        System.out.println("Empleado no registrado en el sistema.");
                                                    } else {
                                                        System.out.println(encargados.get(busc).getHorario());
                                                    }
                                                    
                                                    break;
                                                
                                                case 2:
                                                    System.out.println("Introduzca su ID y su nombre: ");
                                                    System.out.println("Id:");
                                                    int iDsolicit2 = tec.nextInt();
                                                    System.out.println("Nombre:");
                                                    String nomSolicit2 = tec.next();
                                                    int busc1 = ColeccionSub2.buscarTrabajador(encargados, nomSolicit2, iDsolicit2);
                                                    if (busc1 == -1) {
                                                        System.out.println("-----LOGUEO INCORRECTO-----");
                                                        System.out.println("No se puede cambiar el horario si no se es encargado!!");
                                                    } else {
                                                        System.out.println("-----LOGIN CORRECTO----");
                                                        System.out.println("Introduca la hora de inicio (AAAA-MM-DD): ");
                                                        String change = tec.next();
                                                        System.out.println("Introduca la hora de salida (AAAA-MM-DD): ");
                                                        String change1 = tec.next();
                                                        LocalTime time = LocalTime.parse(change);
                                                        LocalTime time1 = LocalTime.parse(change1);
                                                        encargados.get(busc1).setNuevoHorario(time, time1);
                                                        System.out.println("Horario cambiado con éxito!");
                                                    }

                                                    break;
                                            
                                                default:
                                                    break;
                                            }
                                        } while (select != 0);

                                        break;
                                    case 3:

                                    int accion;
                                    do {
                                        System.out.println("------PERMISOS------");
                                        System.out.println("1. Consultar permiso");
                                        System.out.println("2. Asignar permiso");
                                        System.out.println("0. Salir");
                                        accion = tec.nextInt();
                                        switch (accion) {
                                            case 1:
                                            System.out.println("Introduzca su ID y su nombre: ");
                                            System.out.println("Id:");
                                            int iDsolicit2 = tec.nextInt();
                                            System.out.println("Nombre:");
                                            String nomSolicit2 = tec.next();
                                            int busc1 = ColeccionSub2.buscarTrabajador(encargados, nomSolicit2, iDsolicit2);
                                            System.out.println(encargados.get(busc1).getInfoTrabAusente());
                                            
                                                break;
                                        
                                            case 2:
                                            System.out.println("Introduzca su ID y su nombre: ");
                                            System.out.println("Id:");
                                            int iDsolicit3 = tec.nextInt();
                                            System.out.println("Nombre:");
                                            String nomSolicit3 = tec.next();
                                            int busc2 = ColeccionSub2.buscarTrabajador(encargados, nomSolicit3, iDsolicit3);
                                            if (busc2 == -1) {
                                                System.out.println("No se puede asignar un permiso si no se es encargado");
                                            } else {
                                                System.out.println("-----LOGIN CORRECTO----");
                                                System.out.println("Introduca la fecha de inicio: ");
                                                String change = tec.next();
                                                System.out.println("Introduca la fecha de vuelta: ");
                                                String change1 = tec.next();
                                                LocalDate date = LocalDate.parse(change);
                                                LocalDate date1 = LocalDate.parse(change1);
                                                encargados.get(busc2).setNuevaBaja(date, date1);
                                                System.out.println("Baja asignada con éxito!");
                                            }
                                            

                                                break;
                                        }
                                    } while (accion != 0);

                                        break;

                                    case 4:

                                        break;

                                    case 0:

                                        break;
                                }

                            } while (opcion != 0);

                            break;

                        case 4:
                            do {
                                System.out.println("Menú clientes \n 1.Gestionar clientes \n 2.Gestionar pagos");
                                opcion = tec.nextInt();
                                switch (opcion) {
                                    case 1:
                                        System.out.println("Elija qué desea hacer: ");
                                        coleccionCliente.gestionarClientes();
                                        break;
                                    case 2:
                                        System.out.println("Elija qué desea hacer: ");
                                        coleccionPago.gestionarPagos();
                                        break;
                                }
                            } while (opcion != 0);

                            break;
                        case 5:
                            do {
                                System.out.println("¿Que quieres hacer?");
                                System.out.println("1. Registrar.");
                                System.out.println("2. Consultar.");
                                System.out.println("3. Generar alertas.");
                                System.out.println("0. Salir.");
                                opcion = tec.nextInt();
                                switch (opcion) {
                                    case 1:
                                        System.out.println("¿Que quieres registrar?");
                                        System.out.println("1. Registrar Equipos");
                                        System.out.println("2. Registrar Instalaciones");
                                        System.out.println("3. Registrar Establecimientos");
                                        System.out.println("0. Salir.");
                                        opcion = tec.nextInt();
                                        switch (opcion) {
                                            case 0:
                                                System.out.println("Saliendo...");
                                                break;
                                            case 1:
                                                System.out.println("1. Registrar Equipos");
                                                System.out.println("Código:");
                                                eq.setCod(tec.nextDouble());
                                                System.out.println("Tipo:");
                                                eq.setTipo(tec.nextLine());
                                                tec.nextLine();
                                                System.out.println("Estado:");
                                                eq.setEstado(tec.nextLine());
                                                equipo.add(eq);
                                                System.out.println(equipo);
                                                break;
                                            case 2:
                                                System.out.println("2. Registrar Instalaciones");
                                                System.out.println("ID: ");
                                                ins.setId(tec.nextDouble());
                                                System.out.println("Tipo: ");
                                                ins.setTipo(tec.nextLine());
                                                tec.nextLine();
                                                System.out.println("Estado: ");
                                                ins.setEstado(tec.nextLine());
                                                break;
                                            case 3:
                                                System.out.println("3. Registrar Establecimientos");
                                                System.out.println("ID: ");
                                                est.setId(tec.nextLine());
                                                tec.nextLine();
                                                System.out.println("Dirección: ");
                                                est.setDireccion(tec.nextLine());
                                                break;
                                            default:
                                                System.out.println("Opción no valida.");
                                                break;
                                        }
                                        break;
                                    case 2:
                                        System.out.println("¿Que quieres consultar?");
                                        System.out.println("1. Consultar Equipos");
                                        System.out.println("2. Consultar Instalaciones");
                                        System.out.println("3. Consultar Establecimientos");
                                        System.out.println("0. Salir.");
                                        opcion = tec.nextInt();
                                        switch (opcion) {
                                            case 0:
                                                System.out.println("Saliendo...");
                                                break;
                                            case 1:
                                                System.out.println("1. Consultar Equipos");
                                                System.out.println("Código: " + eq.getCod());
                                                System.out.println("Tipo: " + eq.getTipo());
                                                System.out.println("Estado: " + eq.getEstado());
                                                break;
                                            case 2:
                                                System.out.println("2. Consultar Instalaciones");
                                                System.out.println("ID: " + ins.getId());
                                                System.out.println("Tipo: " + ins.getTipo());
                                                break;
                                            case 3:
                                                System.out.println("3. Consultar Establecimientos");
                                                System.out.println("ID: " + est.getId());
                                                System.out.println("Dirección: " + est.getDireccion());
                                                break;
                                            default:
                                                System.out.println("Opción no valida.");
                                                break;
                                        }
                                        break;
                                    case 3: /* Incompleto */
                                        System.out.println("¿De que quieres generar alertas?");
                                        System.out.println("1. Equipos");
                                        System.out.println("2. Instalaciones");
                                        System.out.println("3. Establecimientos");
                                        System.out.println("0. Salir.");
                                        opcion = tec.nextInt();
                                        switch (opcion) {
                                            case 0:
                                                System.out.println("Saliendo...");
                                                break;
                                            case 1:
                                                System.out.println("1. Alerta Equipos");
                                                break;
                                            case 2:
                                                System.out.println("2. Alerta Instalaciones");
                                                break;
                                            case 3:
                                                System.out.println("3. Alerta Establecimientos");
                                                break;
                                            default:
                                                System.out.println("Opción no valida.");
                                                break;
                                        }
                                        break;
                                    default:
                                        break;
                                }
                            } while (opcion != 0);
                            break;
                        case 0:

                            System.out.println("Salir");

                            break;
                    }

                } else if (rol == 2) { // Usuario

                    System.out.println("INICIAR SESIÓN");
                    System.out.println("Introduce tu id: ");
                    idUsuario = tec.nextInt();
                    tec.nextLine();

                    Cliente clienteActual = new Cliente(idUsuario);

                    do {

                        System.out.println("MENÚ OPCIONES");
                        System.out.println("1. Gestión de clases");
                        System.out.println("2. Gestionar membresía");
                        System.out.println("3. Entrenadores");
                        System.out.println("0. Salir");
                        opcion = tec.nextInt();
                        tec.nextLine();

                        switch (opcion) {

                            case 1:

                                do {
                                    System.out.println("OPCIONES GESTIÓN CLASES");
                                    System.out.println("1. Mis clases");
                                    System.out.println("2. Clases dirigidas");
                                    System.out.println("0. Salir");
                                    opcion = tec.nextInt();
                                    tec.nextLine();

                                    switch (opcion) {

                                        case 1:

                                            System.out.println("MIS CLASES");
                                            System.out.println("1. Calendario clases reservadas: ");
                                            System.out.println("2. Reservar clase: ");
                                            System.out.println("0. Salir");
                                            opcion = tec.nextInt();
                                            tec.nextLine();

                                            switch (opcion) {

                                                case 1:

                                                    System.out.println("CALENDARIO CLASES RESERVADAS");
                                                    colecClases.mostrarClasesCliente(clienteActual);
                                                    break;

                                                case 2:

                                                    System.out.println("RESERVAR CLASE");
                                                    System.out.println("Introduce el nombre de la clase: ");
                                                    nomClase = tec.nextLine();

                                                    clase.registrarCliente(clienteActual);
                                                    System.out
                                                            .println("Reserva en " + nomClase + " realizada con éxito");

                                                    break;

                                                case 0:
                                                    System.out.println("Salir");
                                            }

                                            break;

                                        case 2:

                                            System.out.println("CLASES DIRIGIDAS");
                                            colecClases.mostrarClases();
                                            break;
                                    }

                                } while (opcion != 0);

                                break;

                            case 2:
                                coleccionCliente.gestionarMembresia();
                                break;

                            case 3:

                                break;

                            case 0:

                                break;

                        }

                    } while (opcion != 0);
                }

            } while (opcion != 0);

        } while (rol != 0);

        tec.close();
    }

    /*
     * public static <T> int buscarElemento(ArrayList<T> lista, String
     * elementoBuscado) {
     * int i = 0, pos = -1;
     * 
     * while (i < lista.size() && pos == -1) {
     * T obj = lista.get(i);
     * 
     * if (obj instanceof Clase) {
     * 
     * if (((Clase) obj).getNombre().equals(elementoBuscado)) {
     * pos = i;
     * }
     * 
     * } else if (obj instanceof Empleado) {
     * 
     * if (((Empleado) obj).getNombre().equals(elementoBuscado)) {
     * pos = i;
     * }
     * }
     * 
     * i++;
     * }
     * 
     * return pos;
     * }
     */
}