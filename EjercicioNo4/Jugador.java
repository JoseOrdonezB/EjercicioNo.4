/**
 * @author Jose Ordoñez
 * @version 1.0
 */

public class Jugador {
    protected String nombre;
    protected String pais;
    protected int faltas;
    protected int goles;
    protected int lanzamientos;

    /**
     * @param nombre nombre del jugador
     * @param pais pais del jugador
     * @param faltas faltas realizadas por el jugador
     * @param goles goles realizados por el jugador
     * @param lanzamientos lanzamientos realizados por el jugador
     * @return devuelve los datos
     * @since 1.0
     */
    
    public Jugador(String nombre, String pais, int faltas, int goles, int lanzamientos) {
        this.nombre = nombre;
        this.pais = pais;
        this.faltas = faltas;
        this.goles = goles;
        this.lanzamientos = lanzamientos;
    }

}
