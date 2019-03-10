
/**
 * @daoterog @rmateusc
 */
import java.util.concurrent.TimeUnit;
public class Tiempos
{
    public static void main (String [] args) {
        int [] arr;
        Punto1 p=new Punto1();
        System.out.println("Insertion Sort");
        for (int i=1;i<10000000;i*=10) {
            arr=generador(i);
            long start=System.currentTimeMillis();
            p.insertionSort(arr);
            long fin=System.currentTimeMillis();
            System.out.println(fin-start);
        }
        System.out.println("Merge Sort");
        for (int i=1;i<10000000;i*=10) {
            arr=generador(i);
            long start=System.currentTimeMillis();
            p.mergeSort(arr,0,arr.length);
            long fin=System.currentTimeMillis();
            System.out.println(fin-start);
        }
    }
    
    public static int [] generador (int n) {
        int [] a=new int [n];
        for (int i=0;i<n;i++) {
            a[i]=(int)(Math.random()*100);
        }
        return a;
    }
}
