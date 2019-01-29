
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

    public float anguloPolar () {
        if ((x>0) && (y>0)) {
            return (float)Math.atan(y/x);
        } else if (!(x>0) && (y>0)) {
            return (float)(Math.PI-Math.atan(y/x));
        } else if ((x>0) && !(y>0)) {
            return (float)(2*Math.PI-Math.atan(y/x));
        } else if ((x<0) && (y<0)) {
            return (float)(Math.PI+Math.atan(y/x));
        } else {
            System.out.println("No hay angulo");
            return 0.0;
        }
    }

    public float distanciaEuclidiana (Punto otro) {
        return (float)Math.sqrt(Math.pow((double)(x-otro.getX()),2.0)+Math.pow((double)(y-otro.getY()),2.0));
    }
}
