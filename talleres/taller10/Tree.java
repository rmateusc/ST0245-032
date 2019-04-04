
/**
 * Write a description of class Tree here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Tree
{
    private Nodo root;
    public Tree (Nodo root) {
        this.root=root;
    }
    
    public boolean contains (int dato) {
        return containsAux(root,dato);
    }
    
    public boolean containsAux (Nodo root, int dato) {
        if (dato==root.getDato()) {
            return true;
        } else if (dato<root.getDato()) {
            if (root.getIzquierdo()!=null) {
                return containsAux(root.getIzquierdo(),dato);
            } else {
                return false;
            }
        } else {
            if (root.getDerecho()!=null) {
                return containsAux(root.getDerecho(),dato);
            } else {
                return false;
            }
        }
    } 
    
    public void insert (int dato) {
        insertAux(root,dato);
    }
    
    public void insertAux(Nodo root, int dato) {
        if (root.getDato()==dato) {
            //No hacer nada
        } else if (dato>root.getDato()) {
            if (root.getDerecho()!=null) {
                insertAux(root.getDerecho(),dato);
            } else {
                Nodo nodo=new Nodo(dato);
                nodo.setRoot(root);
                root.setDerecho(nodo);
            }
        } else {
            if (root.getIzquierdo()!=null) {
                insertAux(root.getIzquierdo(),dato);
            } else {
                Nodo nodo=new Nodo(dato);
                nodo.setRoot(root);
                root.setIzquierdo(nodo);
            }
        }
    }
    
    public void remove (int dato) {
        removeAux(root,dato);
    }
    
    public void removeAux(Nodo root, int dato) {
        if (root.getDato()==dato) {
            if (root.getRoot().getIzquierdo().getDato()==dato) {
                
            } else {
                
            }
        }
    }
}
