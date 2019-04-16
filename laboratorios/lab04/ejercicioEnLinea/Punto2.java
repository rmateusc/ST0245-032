
/**
 * Write a description of class punto2 here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
import java.util.Scanner;
import java.util.ArrayList;
public class Punto2
{
    public void main () {
        System.out.println("Inserte el arbol en pre-orden");
        System.out.println("Escriba cada numero individualmente y presione enter para continuar con el siguiente");
        System.out.println("Digite cualquier numero negativo para parar la entrada de datos");
        Scanner n=new Scanner(System.in);
        int num=n.nextInt();
        if (num>-1) {
            Nodo nume=new Nodo(num);
            Tree arbol=new Tree(nume);
            while (num>-1) {
                num=n.nextInt();
                if (num>=0) arbol.insert(num);
            }
            punto2(arbol);
        }
    }

    public void punto2 (Tree arbol) {
        punto2Aux(arbol.getRoot());
    }
    
    public void punto2Aux(Nodo root) {
        if (root!=null) {
            punto2Aux(root.getIzquierdo());
            punto2Aux(root.getDerecho());
            System.out.println(root);
        }
    }
}
