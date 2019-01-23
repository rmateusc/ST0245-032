
/**
 * @daoterog @rmateusc
 */
public class Contador
{
    private String id;
    private int acum;
    public Contador (String idd) {
        id=idd;
    }
    
    public void incrementar () {
        acum++;
    }
    
    public int incrementos () {
        return acum;
    }
    
    public String toString () {
        return id+":"+acum;
    }
}
