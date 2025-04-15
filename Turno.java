
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;

/**
 * @author David Llorens Hernandez
 *         Descripción: clase turno del subsistema 2 de la franquicia de
 *         gimnasios
 */
public class Turno {
    // atributos
    LocalDate inicioVacaciones, finVacaciones, inicioBaja, finBaja;
    LocalTime inicio, fin;
    boolean completado;

    /**
     * constructor por defecto. Establece vacaciones iniciales y horario
     * de mañanas
     */
    public Turno() {
        this.inicioVacaciones = LocalDate.of(2025, 8, 15);
        this.finVacaciones = LocalDate.of(2025, 8, 30);
        this.inicio = LocalTime.of(9, 30);
        this.fin = LocalTime.of(17, 30);
        completado = false;
    }

    /**
     * constructor que establece vacaciones inicales y horario personalizado
     * 
     * @param inicio      hora del inicio del turno de trabajo
     * @param fin         hora del fin del turno de trabajo
     */
    public Turno(LocalTime inicio, LocalTime fin) {
        this.inicioVacaciones = LocalDate.of(2025, 8, 15);
        this.finVacaciones = LocalDate.of(2025, 8, 30);
        this.inicio = inicio;
        this.fin = fin;
    }

    // métodos
    /**
     * método que asigna el periodo de baja a un trabajador en caso necesario
     * 
     * @param iBaja fecha del inicio de la baja
     * @param fBaja fin del periodo de baja
     */
    public void setBaja(LocalDate iBaja, LocalDate fBaja) {
        this.inicioBaja = iBaja;
        this.finBaja = fBaja;
    }

    /**
     * método que asigna las nuevas vacaciones al turno
     * 
     * @param iNuevas inicio del nuevo periodo vacacional
     * @param fNuevas final del periodo vacacional
     */
    public void setNuevasVacaciones(LocalDate iNuevas, LocalDate fNuevas) {
        this.inicioVacaciones = iNuevas;
        this.finVacaciones = fNuevas;
    }

    /**
     * método que asigna un nuevo horario al turno
     * 
     * @param inicio nueva fecha de inicio del turno laboral
     * @param fin    nueva fecha de fin del horario laboral
     */
    public void setHorario(LocalTime inicio, LocalTime fin) {
        this.inicio = inicio;
        this.fin = fin;
    }


    public String getHorario() {
        return "Trabaja de " + inicio + " a " + fin;
    }
    /**
     * método que muestra el estado de las vacaciones del trabajador
     * 
     * @return "El empleado no está de vacaciones" cuando la fecha actual
     *         está fuera de las fechas de vacaciones establecias
     * @return "El empleado volverá " + diasRestantes. Devuelve los días que
     *         le quedan de vacaciones al trabajador
     */
    public String getVacaciones() {
        LocalDate hoy = LocalDate.now();
        if (hoy.isBefore(inicioVacaciones) || hoy.isAfter(finVacaciones)) {
            long seVa = ChronoUnit.DAYS.between(hoy, inicioVacaciones);
            return "El empleado no está de vacaciones, se va en " + seVa + " días";
        } else {
            long diasRestantes = ChronoUnit.DAYS.between(hoy, finVacaciones);
            return "El empleado volverá en " + diasRestantes + " días";
        }
    }

    /**
     * Método que comprueba si el empleado está de baja
     * 
     * @return "El empleado no está de baja" si no se ha asignado fecha
     *         de inicio o si la fecha actual está fuera de la fecha asignada
     * @return "Al empleado le quedan " + diasRestantes + " días de baja"
     *         si la fecha actual está dentro del periodo de baja, devuelve los días
     *         restantes
     */
    public String comprobarBaja() {
        LocalDate hoy = LocalDate.now();
        if (inicioBaja == null || hoy.isBefore(inicioBaja) || hoy.isAfter(finBaja)) {
            return "\nEl empleado no está de baja";
        } else {
            long diasRestantes = ChronoUnit.DAYS.between(hoy, finBaja);
            return "\nAl empleado le quedan " + diasRestantes + " días de baja";
        }
    }

    /**
     * Método que comprueba si el turno del empleado ha finalizado.
     * 
     * @return false si la hora actual se encuentra dentro del tiempo
     *         de trabajo
     * @return true si la hora actual se encuentra fuera del tiempo de
     *         trabajo
     */
    public boolean terminado() {
        LocalTime ahora = LocalTime.now();
        if (ahora.isAfter(inicio) && ahora.isBefore(fin)) {
            return completado = false;
        } else {
            return completado = true;
        }
    }
}