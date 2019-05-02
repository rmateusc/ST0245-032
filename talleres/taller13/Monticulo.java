/**
 * @daoterog @rmateusc
 */
public class Monticulo {

    // Variables de la clase Monticulo
    static int[] monticulo;
    static int size;
    static int max;

    /** Constructor de la clase Monticulo que genera un objeto de tipo Monticulo pasando por parametro
    /   el numero de elementos y el numero maximo
     */
    public Monticulo (int max) {
        size=0;
        this.max=max;
        monticulo=new int[max]; 
    }

    /** Constructor de la clase Monticulo que genera un objeto de tipo Monticulo pasando por parametro un vector
    /   
    /
     */

    public Monticulo (int[] vector, int max) {
        monticulo=vector; 
        this.max=max;
        size=vector.length;
    }

    //devuelve cierto si el montículo está vacío.
    public boolean EmptyHeap() {
        return size==0;
    }

    //reubica el elemento i-esimo del vector en caso de que este sea mayor que el
    //padre (montículo de maximos).
    public static void flotar (int elemento) {
        int posicion=0;
        for(int i=0; i<monticulo.length; i++){ 
            if(monticulo[i]==elemento){
                posicion=i;
                break;
            }
        }
        int posicionPadre=(posicion-1)/2;
        if(elemento>=monticulo[posicionPadre] || monticulo[0]==elemento){
            System.out.println("");
        }
        else{

            if(elemento<monticulo[posicionPadre]){
                int aux=monticulo[posicionPadre];
                monticulo[posicionPadre]=elemento;
                monticulo[posicion]=aux;

            }
            flotar(elemento);
        }

    }
    //reubica el elemento i-esimo del vector en caso de que éste sea menor que alguno
    //de sus hijos. En tal caso, intercambia su valor por el del mayor de sus hijos (montículo de máximos).
    public static void hundir (int elemento) {
        int posicion=0;
        for(int i=0; i<monticulo.length; i++){//busca poscion elemento 
            if(monticulo[i]==elemento){
                posicion=i;
                break;
            }
        }
        int hijoIzq = (posicion*2) + 1;
        int hijoDer = (posicion*2) + 2;
        if (elemento>monticulo[hijoDer]){
            flotar(monticulo[hijoDer]);
        }
        else if(elemento>monticulo[hijoIzq]){
            flotar(monticulo[hijoIzq]);
        }
        else{
            System.out.println("");
        }
    }
    //inserta un elemento en el montículo y lo flota hasta restaurar la propiedad de
    //montículo.
    public static void insert(int elemento) {
        monticulo[size]=elemento;
        int posicionPadre=(size-1)/2;
        if(elemento<monticulo[posicionPadre]){
            flotar(elemento);
        }
        size++;
    }
    //devuelve la cima del montículo, la elimina del mismo y recompone la
    //propiedad de montículo.
    public int first() {
        int p= monticulo[0];
        return 0;
    }
}
