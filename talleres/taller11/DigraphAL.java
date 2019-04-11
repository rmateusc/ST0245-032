import java.util.ArrayList;
import java.util.LinkedList;
/**
 * Implementacion de un grafo dirigido usando listas de adyacencia
 *
 * @author Mauricio Toro, Mateo Agudelo, <su nombre>
 */
public class DigraphAL extends Digraph {
    ArrayList<LinkedList<Pair<Integer,Integer>>> l;

    /**
     * Constructor para el grafo dirigido
     * @param vertices el numero de vertices que tendra el grafo dirigido
     *
     */
    public DigraphAL(int size) {
        super(size);
        l=new ArrayList<LinkedList<Pair<Integer,Integer>>>();
        for (int i=0;i<size;++i) {
            l.add(new LinkedList<Pair<Integer,Integer>>());
        }
    }

    /**
     * Metodo para añadir un arco nuevo, donde se representa cada nodo con un entero
     * y se le asigna un peso a la longitud entre un nodo fuente y uno destino	
     * @param source desde donde se hara el arco
     * @param destination hacia donde va el arco
     * @param weight el peso de la longitud entre source y destination
     */
    public void addArc(int source, int destination, int weight) {
        l.get(source).add(new Pair(destination,weight));
    }

    /**
     * Metodo para obtener una lista de hijos desde un nodo, es decir todos los nodos
     * asociados al nodo pasado como argumento
     * @param vertex nodo al cual se le busca los asociados o hijos
     * @return todos los asociados o hijos del nodo vertex, listados en una ArrayList
     * Para más información de las clases:
     * @see <a href="https://docs.oracle.com/javase/8/docs/api/java/util/ArrayList.html"> Ver documentacion ArrayList </a>
     */
    public ArrayList<Integer> getSuccessors(int source) {
        ArrayList<Integer> destinos=new ArrayList();
        for (int i=0;i<l.get(source).size();++i) {
            destinos.add(l.get(source).get(i).first);
        }
        return destinos;
    }

    /**
     * Metodo para obtener el peso o longitud entre dos nodos
     * 
     * @param source desde donde inicia el arco
     * @param destination  donde termina el arco
     * @return un entero con dicho peso
     */	
    public int getWeight(int source, int destination) {
        for (int i=0;i<l.get(source).size();++i) {
            if (l.get(source).get(i).first==destination) return l.get(source).get(i).second;
        }
        return 0;
    }

    public boolean punto3(int source,int destination) {
        ArrayList<Integer> a=new ArrayList();
        return punto3Aux(source,destination,a);
    }

    public boolean punto3Aux(int source,int dest,ArrayList<Integer> nodosrecorridos) {
        ArrayList<Integer> sucesores=getSuccessors(source);
        if (nodosrecorridos.contains(source)) {
            return false;
        } else {
            boolean ya=false;
            for (int i=0;i<sucesores.size();++i) {
                if (dest==sucesores.get(i)) ya=true;
            }
            if (ya) {
                return true;
            } else {
                nodosrecorridos.add(source);
                boolean r;
                for (int i=0;i<sucesores.size();++i) {
                    r = punto3Aux(sucesores.get(i),dest,nodosrecorridos);
                    if (r) {
                        return true;
                    } 
                }
                return false;
            }
        }
    }
}