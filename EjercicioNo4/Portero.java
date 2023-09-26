/**
 * @author Jose Ordoñez
 * @version 1.0
 */

public class Portero extends Jugador {

    private int paradas;
    private int recibido;

    /**
     * @param nombre nombre del jugador
     * @param pais pais del jugador
     * @param faltas faltas realizadas por el jugador
     * @param goles goles realizados por el jugador
     * @param lanzamientos lanzamientos realizados por el jugador
     * @param paradas paradas realizadas por el jugador
     * @param recibido goles recibidos del jugador.
     * @return devuelve los datos
     * @since 1.0
     */

    public Portero(String nombre, String pais, int faltas, int goles, int lanzamientos, int paradas, int recibido){
        super(nombre, pais, faltas, goles, lanzamientos);
        this.paradas = paradas;
        this.recibido = recibido;
    }

    /**
     * @return Devuelve la efectividad del portero
     * @since 1.0
     */

    double calcularEfectividad() {
        return ((paradas - recibido) * 100.0 / (paradas + recibido))
                + (goles * 100.0 / lanzamientos);
    }
}
