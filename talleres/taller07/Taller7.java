
/**
 * @daoterog @rmateusc
 */
public class LinkedListDaniel
{
    private Node first;
    private int size;
    private Node last;
    public LinkedListDaniel()
    {
        size = 0;
        first = null;	
    }

    private Node getNode(int index) throws IndexOutOfBoundsException {
        if (index >= 0 && index < size) {
            Node temp = first;
            for (int i = 0; i < index; i++) {
                temp = temp.next;
            }
            return temp;
        } else {
            throw new IndexOutOfBoundsException();
        }
    }

    public int get(int index) throws IndexOutOfBoundsException {
        Node temp = getNode(index);
        return temp.data;
    }

    public int size () {
        return size;
    }
    
    public int indexOf (int data) {
        if (contains(data)) {
            return indexOfAux(first,data,0);
        } else {
            return -1;
        }
    }
    
    public int indexOfAux(Node nodo, int data,int contador) {
        return nodo.data==data ? contador : indexOfAux(nodo.next,data,contador++);
    }
    
    public int max () {
        return maxAux(first,first.data,0);
    }
    
    public int maxAux (Node nodo, int max,int contador) {
        if (contador==size) {
            return max;
        } else {
            if (max<nodo.data) {
                return maxAux(nodo.next,nodo.data,contador++);
            } else {
                return maxAux(nodo.next,max,contador++);
            }
        }
    }
    
    public boolean equals (LinkedListDaniel l1, LinkedListDaniel l2) {
        if (l1.size()==l2.size()) {
            return equalsAux(l1.first,l2.first,0,l1.size);
        } else {
            return false;
        }
    }
    
    public boolean equalsAux (Node l1, Node l2, int contador, int size) {
        return l1.data==l2.data ? contador==size ? true : equalsAux(l1.next,l2.next,contador++,size) : false;
    }

    public void insert (int data, int index) throws IndexOutOfBoundsException {
        if (index>1) {
            if(index==0) {
                size++;
                Node agregar=new Node(data);
                agregar.next=first;
                first=agregar;
            } else if (index<size) {
                size++;
                insertAux1(first,index,0,data);
            } else {
                int dif=index-size+1;
                size+=dif;
                insertAux2(dif,data);
            }
        } else {
            throw new IndexOutOfBoundsException();
        }
    }
    
    public void getLast () {
        Node ultimo=first;
        for (int i=0;i<size-1;i++) {
            ultimo=ultimo.next;
        }
        last=ultimo;
    }

    public void insertAux2 (int dif,int data) {
        if (dif>1) {
            Node agregar=new Node(0);
            getLast();
            last.next=agregar;
            insertAux2(dif-1,data);
        } else {
            Node agregar=new Node(data);
            getLast();
            last.next=agregar;
        }
    }

    public void insertAux1 (Node nodo,int index, int contador, int data) {
        if (contador<index-1) {
            insertAux1(nodo,index,contador++,data);
        } else {
            Node agregar=new Node(data);
            Node cambiaso=nodo.next;
            nodo.next=agregar;
            agregar.next=cambiaso;
        }
    }

    public void remove (int index) throws IndexOutOfBoundsException {
        if (index>=0 && index<size) {
            if (index==0) first=first.next;
            else {
                Node cambiar=removeAux(first,0,index-1);
                cambiar.next=cambiar.next.next;
            }
            size--;
        } else {
            throw new IndexOutOfBoundsException();
        }
    }

    public Node removeAux (Node nodo, int contador, int index) {
        return contador==index ? nodo : removeAux(nodo.next,contador++,index);
    }

    public boolean contains (int data) {
        return containsAux(first,data,0);
    }

    public boolean containsAux (Node nodo, int data, int index) {
        return index==size ? false : nodo.data==data ? true : containsAux(nodo.next,data,index++);
    }
}
