/**
 * @daoterog @rmateusc
 */
public class PuertoUraba
{
    public static long puertoAntioquia (int i) {
        if (i<=1) {
            return i;
        } else {
            return puertoAntioquia(i-1)+puertoAntioquia(i-2);   
        }
    }
}