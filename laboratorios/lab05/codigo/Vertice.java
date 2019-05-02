import java.util.LinkedList;
/**
 * Write a description of class Vertice here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Vertice
{
    private long ID;
    private double x;
    private double y;
    private String nombre;
    private LinkedList<Arco> arcos=new LinkedList();
    public Vertice (long ID,double x,double y,String nombre) {
        this.ID=ID;
        this.x=x;
        this.y=y;
        this.nombre=nombre;
    }
    
    public Vertice (long ID,double x,double y) {
        this.ID=ID;
        this.x=x;
        this.y=y;
    }
    
    public long getID () {
        return ID;
    }
    
    public double getX () {
        return x;
    }
    
    public double getY () {
        return y;
    }
    
    public String getNombre () {
        return nombre;
    }
    
    public void addArco (Arco arco) {
        arcos.addFirst(arco);
    }
    
    public int compareTo (Vertice otro) {
       return (int)(ID - otro.getID());
    }
}