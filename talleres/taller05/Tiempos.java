
/**
 * Write a description of class Tiempos here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
import java.util.concurrent.TimeUnit;
public class Tiempos
{
    public static void mainSort (String [] args) {
        for (int i=1000;i<=100000;i+=1000) {
            long start=System.currentTimeMillis();
            int [] b=generador(i);
            //int [] b=new int [i];
            //imprimir(b);
            insertionSort(b);
            //imprimir(b);
            long tiempo=System.currentTimeMillis()-start;
            System.out.println(tiempo);
        }
    }

    public static void mainSuma (String [] args) {
        for (int i=1000;i<=100000;i+=1000) {
            long start=System.currentTimeMillis();
            int [] b=generador(i);
            //int [] b=new int [i];
            //imprimir(b);
            int s=suma(b);
            long tiempo=System.currentTimeMillis()-start;
            System.out.println(tiempo);
        }
    }

    public static void mainMul (String [] args) {
        for (int i=1000;i<=100000;i+=1000) {
            long start=System.currentTimeMillis();
            mul(i);
            long tiempo=System.currentTimeMillis()-start;
            System.out.println(tiempo);
        }
    }

    public static int[] insertionSort (int[] array){ //T(n)=n*(n-1)*C//O(n)=n^2 
        /*try {
        TimeUnit.SECONDS.sleep(1);
        } catch (Exception m) {

        }*/
        for (int i=0;i<array.length;i++) { //T(n)=n*(C2+C3)
            int menor=array[i];//C2
            int j=i+1;//C3
            while (j<array.length) { //T(n)=(n-1)*(C5+C6+C7+C8)
                if (menor>array[j]) { //C5
                    menor=array[j];//C6
                    array[j]=array[i];//C7
                    array[i]=menor;//C8
                }
                j++;//C9
            }
        }
        return array;//C10
    }

    public static int suma (int[]array){ //T(n)=(n*C2)+C T(n)=O(n)
        /*try {
        TimeUnit.SECONDS.sleep(1);
        } catch (Exception m) {

        }*/
        int suma=0; //C1
        for (int i=0;i<array.length;i++) { //T(n)=n*C2
            suma+=array[i];//C2
        }
        return suma;//C4
    }

    public static void mul (int num){ //T(n)=(n^2)C//O(n)=n^2
        /*try {
        TimeUnit.SECONDS.sleep(1);
        } catch (Exception m) {

        }*/
        for (int i=0;i<=num;i++) { //T(n)=n 
            for (int j=0;j<=num;j++) { //T(n)=n*C2
                //System.out.println(i+"*"+j+"="+j*i); //C2
            }
        } 
    }

    public static int [] generador (int n) {
        int [] a=new int [n];
        for (int i=0;i<n;i++) {
            a[i]=(int)(Math.random()*100);
        }
        return a;
    }

    public static void imprimir (int [] a) {
        for (int i=0;i<a.length;i++) {
            System.out.print(a[i]+" ");
        }
    }
}
