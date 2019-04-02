
/**
 * Write a description of class Abeja here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Abeja
{
    private int ID;
    private Punto p;
    public Abeja(int ID, Punto p) {
        this.ID=ID;
        this.p=p;
    }
    
    public int getID() {
        return ID;
    }
    
    public Punto getPunto() {
        return p;
    }
}
