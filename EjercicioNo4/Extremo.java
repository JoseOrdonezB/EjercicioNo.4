/**
 * @author Jose Ordoñez
 * @version 1.0
 */

public class Extremo extends Jugador {
    private int pases;
    private int asistencias;
    
    /**
     * @param nombre nombre del jugador
     * @param pais pais del jugador
     * @param faltas faltas realizadas por el jugador
     * @param goles goles realizados por el jugador
     * @param lanzamientos lanzamientos realizados por el jugador
     * @param pases pases realizados por el jugador
     * @param asistencias asistencias realizados por el jugador
     * @return devuelve los datos
     * @since 1.0
     */

    public Extremo(String nombre, String pais, int faltas, int goles, int lanzamientos, int pases, int asistencias){
        super(nombre, pais, faltas, goles, lanzamientos);
        this.pases = pases;
        this.asistencias = asistencias;
    }

    /**
     * @return Devuelve la efectividad del extreño
     * @since 1.0
     */
    
    double calcularEfectividad() {
        return ((pases + asistencias - faltas) * 100.0 / (pases + asistencias + faltas))
                + (goles * 100.0 / lanzamientos);
    }
}
