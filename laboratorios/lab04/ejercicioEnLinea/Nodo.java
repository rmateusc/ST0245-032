
/**
 * Write a description of class Nodo here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Nodo
{
    private int dato;
    private Nodo izq;
    private Nodo der;
    private Nodo root;
    public Nodo (int dato) {
        this.dato=dato;
    }
    
    public void setRoot (Nodo root) {
        this.root=root;
    }
    
    public Nodo getRoot () {
        return root;
    }
    
    public int getDato() {
        return dato;
    }
    
    public Nodo getIzquierdo() {
        return izq;
    }
    
    public void setIzquierdo(Nodo izq) {
        this.izq=izq;
    }
    
    public Nodo getDerecho() {
        return der;
    }
    
    public void setDerecho (Nodo der) {
        this.der=der;
    }
}
