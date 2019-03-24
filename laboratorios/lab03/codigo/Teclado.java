
/**
 * Write a description of class Teclado here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
import java.util.LinkedList;
public class Teclado
{
    public LinkedList<Character> lista=new LinkedList();
    public void deStringALista (String s) {
        for (int i=0;i<s.length();i++) {
            lista.add(i,s.charAt(i));
        }
    }

    public void limpiar () {
        while (lista.size()!=0) {
            lista.removeFirst();
        }
    }

    public void main (String s) {
        limpiar();
        deStringALista(s);
        organizar(0,false,0);
        imprimir();
    }

    public void organizar (int index,boolean cambiar,int ind) {
        if (index>=lista.size()) {
            //Parar
        } else if (lista.get(index)!='[' && lista.get(index)!=']' && cambiar==true) {
            lista.add(ind,lista.get(index));
            lista.remove(index+1);
            organizar(index+1,cambiar,ind+1);
        } else if (lista.get(index)=='[') {
            if (index==0) { 
                lista.removeFirst();
                organizar(index,true,1);
            } else {
                if (index==lista.size()-1) { 
                    lista.removeLast();
                    organizar(index+1,true,1);
                } else {
                    lista.remove(index);
                    if (lista.get(index)=='[') {
                        organizar(index,true,1);
                    } else {
                        lista.addFirst(lista.get(index));
                        lista.remove(index+1);
                        organizar(index+1,true,1);
                    }
                }
            }
        } else if (lista.get(index)==']') {
            lista.remove(index);
            organizar(index,false,0);
        } else {
            organizar(index+1,cambiar,0);
        }
    }

    public void imprimir () {
        System.out.println();
        for (int i=0;i<lista.size();++i) {
            System.out.print(lista.get(i));
        }
    }
}
