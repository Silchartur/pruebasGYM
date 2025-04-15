
import java.util.ArrayList;

public class ColeccionSub2 {

    /**
     * 
     * @param aCargoDe
     * @param nombre
     * @param nif
     * @param direccion
     * @param sueldo
     * @param especialidad
     * @param telefono
     * @param inicio
     * @param fin
     */
    static public void setNuevoDiscípulo(ArrayList<Empleado> aCargoDe, String nombre, String nif, String direccion,
            String sueldo, String especialidad, int telefono) {
        aCargoDe.add(new Empleado(nombre, nif, direccion, sueldo, especialidad,
                telefono));
    }

    /**
     * método para buscar un empleado en caso necesario (saber si imparte una clase,
     * conocer sus turnos y horarios, registrarse como empleado...)
     * 
     * @param aCargoDe lista de empleados para realizar la búsqueda, se añaden a
     *                 la misma al registrarlos
     * @param nombre   nombre para encontrar coincidencias
     * @param id       id, no susceptible a cambios para evitar errores en
     *                 coincidencias en el nombre (ej: Marcos, 01; Marcos, 15)
     * @return la posición de la lista en que se encuentra el empleado, de no
     *         encontrarlo quiere decir que o bien no imparte
     *         la clase o no está registrado en el sistema
     */
    public static int buscarTrabajador(ArrayList<Encargado> aCargoDe, String nombre, int id) {
        int i = 0, pos = -1;
        while (i < aCargoDe.size() && pos == -1) {
            if (aCargoDe.get(i).getNombre().equals(nombre) && aCargoDe.get(i).getId() == id) {
                pos = i;
            } else {
                i++;
            }
        }
        return pos;
    }

    public static boolean logueoCorrecto(int a) {
        boolean correcto;
        if (a == -1) {
            correcto = false;
        } else {
            correcto = true;
        }
        return correcto;
    }
}