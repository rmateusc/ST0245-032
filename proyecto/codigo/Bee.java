/**
 * Este objeto se encarga de de guardar las coordenadas de cada abeja, leidas
 * en la clase Reader, en lo que llamamos Bee, para asi facilitar el manejo
 * y la comparacion de estas coordenadas a la hora de crear un Octree. 
 * @author: Daniel Otero Gomez, Rafael Mateus Carrion. 
 * @version: 4/7/2019/A
 * @see Octree
 * @see Bee
 */
public class Bee
{
    private double latitude;
    private double longitude;
    private double altitude;
    /**
     * Este es el constructor de la clase.
     * @param latitude: latitud en grados
     * @param longitude: longitud en grados
     * @param @altitude: altitud en metros sobre el nivel del mar
     */
    public Bee (double latitude, double longitude, double altitude){
        this.latitude=latitude;
        this.longitude=longitude;
        this.altitude=altitude;
    }
    
    /**
     * Devuelve la latitud
     * @return latitude
     */
    public double getLatitude(){
        return latitude;
    }
    
    /**
     * Devuelve la longitud
     * @return longitude
     */
    public double getLongitude(){
        return longitude;
    }
    
    /**
     * Devuelve la altitud
     * @return altitude
     */
    public double getAltitude(){
        return altitude;
    }
}
