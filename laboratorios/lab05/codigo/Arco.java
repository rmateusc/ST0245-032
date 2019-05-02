
/**
 * Write a description of class Arco here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Arco
{
    private long ID;
    private double distancia;
    private String nombre;
    public Arco (long ID,double distancia, String nombre) {
        this.ID=ID;
        this.distancia=distancia;
        this.nombre=nombre;
    }
    
    public Arco (long ID,double distancia) {
        this.ID=ID;
        this.distancia=distancia;
    }
    
    public long getID () {
        return ID;
    }
    
    public double getDistancia () {
        return distancia;
    }
    
    public String getNombre () {
        return nombre;
    }
}
