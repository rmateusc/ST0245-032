
/**
 * Write a description of class pruebas here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */

import java.util.ArrayList;
import java.util.LinkedList;
public class Recorridos 
{
    public boolean DFS(Digraph g, int source,int destination) {
        boolean [] nodosrecorridos=new boolean[g.size()];
        return DFSAux(g,source,destination,nodosrecorridos);
    }

    public boolean DFSAux(Digraph g,int source,int dest,boolean [] nodosrecorridos) {
        ArrayList<Integer> sucesores=g.getSuccessors(source);
        if (nodosrecorridos[source]) {
            return false;
        } else {
            boolean ya=false;
            for (int i=0;i<sucesores.size();++i) {
                if (dest==sucesores.get(i)) ya=true; break;
            }
            if (ya) {
                return true;
            } else {
                nodosrecorridos[source]=true;
                boolean r;
                for (int i=0;i<sucesores.size();++i) {
                    r = DFSAux(g,sucesores.get(i),dest,nodosrecorridos);
                    if (r) {
                        return true;
                    } 
                }
                return false;
            }
        }
    }

    public boolean BFS (Digraph g, int source, int destination) {
        ArrayList<Integer> sucesores=g.getSuccessors(source);
        LinkedList<Integer> hijos=new LinkedList();
        for (int i=0;i<sucesores.size();++i) {
            if (destination!=sucesores.get(i)) hijos.addLast(sucesores.get(i));
            else return true;
        }
        return BFSAux(g,hijos,destination);
    }
    
    public boolean BFSAux(Digraph g,LinkedList<Integer> hijos, int destination) {
        LinkedList<Integer> nietos=new LinkedList();
        for (Integer sucesor:hijos) {
            ArrayList<Integer> suc=g.getSuccessors(sucesor);
            for (Integer nieto:suc) {
                if (nieto!=destination) nietos.addLast(nieto);
                else return true;
            }
        } 
        if (nietos.size()==0) return false;
        else return BFSAux(g,nietos,destination);
    }
}
