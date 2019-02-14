
/**
 * @daoterog @rmateusc
 */
import java.util.concurrent.TimeUnit;
public class Tiempos
{
    public static void mainSuma (String [] args) {
        for (int i=0;i<=20;i++) {
            long start=System.currentTimeMillis();
            int s=suma(new int [i],0);
            long tiempo=System.currentTimeMillis()-start;
            System.out.println(tiempo);
        }
    }

    public static int suma (int [] array, int n) {
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (Exception e) {

        }
        return n==array.length-1 ? array[n] : array.length==0 ? 0 : array[n]+suma(array,n+1);
    }
    
    public static long fibonacci (int i) {
        return i <= 1 ? i : fibonacci(i-1)+fibonacci(i-2);
    }

    public static void mainFibonacci (String [] args) {
        for (int i=0;i<=20;i++) {
            long start= System.currentTimeMillis();
            long a=fibonacci(i);
            long tiempo=System.currentTimeMillis()-start;
            System.out.println(tiempo);
        }
    }
    
    public static void mainGroupSum (String [] args) {
        for (int i=1;i<=20;i++) {
            //int [] b=generador(i);
            int [] b=new int [i];
            //imprimir(b);
            int t=(int)Math.random()*100+30;
            //System.out.println(t);
            long start= System.currentTimeMillis();
            boolean a=Taller4.groupSum(0,b,t);
            long tiempo=System.currentTimeMillis()-start;
            System.out.println(tiempo);
        }
    }
    
    public static void imprimir (int [] a) {
        for (int i=0;i<a.length;i++) {
            System.out.print(a[i]+" ");
        }
    }
    
    public static int [] generador (int n) {
        int [] a=new int [n];
        for (int i=0;i<n;i++) {
            a[i]=(int)Math.random()*100;
        }
        return a;
    }
    
    public static boolean groupSum (int start, int [] array, int target) {
        return start>=array.length ? target==0 ? true : false : array[start]>target ? groupSum(start+1,array,target) : target-array[start]==0 ? true : groupSum(start,array,target-array[start]) || groupSum(start+1,array,target);
    } 
}
