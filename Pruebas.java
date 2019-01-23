
/**
 * Write a description of class Pruebas here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Pruebas
{
    public static void main (String [] args) {
        Punto r=new Punto(48,8);
        Punto g=new Punto(13,0);
        System.out.println(r.radioPolar());
        System.out.println(r.anguloPolar());
        System.out.println(r.distanciaEuclidiana(g));
    }
}
