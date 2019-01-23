
/**
 * @daoterog @rmateusc
 */
import java.lang.Math;
public class Punto
{
    private int x;
    private int y;
    public Punto (int xx, int yy) {
        x=xx;
        y=yy;
    }

    public int getX () {
        return x;
    }

    public int getY () {
        return y;
    }

    public float radioPolar () {
        return (float)Math.sqrt(x*x+y*y);
    }

    public double anguloPolar () {
        return Math.atan(y/x);
        /*if ((x-x==0) && (y-y==0)) {
            return Math.atan(y/x);
        } else if (!(x-x==0) && (y-y==0)) {
            return (180-Math.atan(y/x));
        } else if ((x-x==0) && !(y-y==0)) {
            return (360-Math.atan(y/x));
        } else {
            return (180+Math.atan(y/x));
        }*/
    }

    public float distanciaEuclidiana (Punto otro) {
        return (float)Math.sqrt(Math.pow((double)(x-otro.getX()),2.0)+Math.pow((double)(y-otro.getY()),2.0));
    }
}
