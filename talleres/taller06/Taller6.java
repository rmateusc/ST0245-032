
/**
 * Write a description of class Taller6 here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
import java.util.Scanner;
import java.util.ArrayList;
public class Taller6
{
    public static ArrayList<Integer> lista=new ArrayList();
    public static ArrayList<ArrayList<Integer>> lista1=new ArrayList();
    public static void lecturaEnteros () {
        try {
            limpiar();
            System.out.println("Ingrese los enteros que desea guardar/nDigite el entero -1 cuando desee dejar de guardarlos");
            Scanner ent=new Scanner (System.in);
            int e=ent.nextInt();
            if (e==-1) {
                System.out.println("Usted no desea guardar nada, gracias!");
            } else {
                lista.add(e);
                while (e!=-1) {
                    e=ent.nextInt();
                    if (e!=-1) lista.add(e);
                }
                System.out.println("Ya no desea guardar mas numeros, gracias!");
            }
            imprimir();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static void imprimir () {
        for (int i=0;i<lista.size();i++) {
            System.out.print(lista.get(i)+" ");
        }
    }
    
    public static void limpiar () {
        while (lista.size()!=0) {
            lista.remove(0);
        }
    }
    
    public static void limpiar1 () {
        while (lista.size()!=0) {
            lista1.remove(0);
        }
    }
    
    public static void mainArregloDeArreglos (int n) {
        limpiar1();
        arregloDeArreglos(n);
    }
    
    public static void arregloDeArreglos (int n) {
        if (n>0) {
            lista1.add(0,llenar(n));
            arregloDeArreglos(n-1);
        }
    }
    
    public static ArrayList<Integer> llenar (int n) {
        ArrayList<Integer> l=new ArrayList();
        for (int i=1;i<=n;i++) {
            l.add(0,i);
        }
        return l;
    }
}
