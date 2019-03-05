/**
 * @daoterog @rmateusc
 */
import java.lang.ArrayIndexOutOfBoundsException;
public class textEditor
{    
    char [] text= new char [0];

    public textEditor(){
    }

    public void remove(int index) throws ArrayIndexOutOfBoundsException {
        if (index<=text.length){
            text[index]='\u0000';
            reducirTamano(index,text, text.length-1);
        } else 
            throw new  ArrayIndexOutOfBoundsException();
    }

    public int size(){
        return text.length;
    }

    public char get(int index){
        if (index<text.length){
            return text[index];
        } else 
            throw new ArrayIndexOutOfBoundsException();
    }

    public void add(char t){
        agrandarTamano(text,text.length+1);
        text[text.length-1]=t;
    }

    public void agrandarTamano(char [] text1,int tamano) {
        text=new char[tamano];
        for (int i=0;i<text1.length;i++) {
            text[i]=text1[i];  
        }        
        text[text.length-1]=0;
    }

    public void reducirTamano (int index, char []text1, int tamano){
        text = new char [tamano];
        for (int i=0; i<tamano;i++){
            if (i<index){
                text[i] = text1[i];
            } else{
                text[i]=text1[i+1];
            }
        }
    }

    public void add(int index, char t){
        if (index<=text.length){
            char ultima=text[text.length-1];
            agrandarTamano(text,text.length+1);
            organizador(index,t,ultima);
        } else 
            agrandarTamano(text,text.length+(index+1-text.length));
        text[index]=t;
    }

    public void organizador (int index, char t, char ultima){
        char remplazo=text[index];
        char remp;
        for (int i=index; i<text.length-1;i++){
            if (i==index) {
                text[i]=t;
            } else{
                remp = text[i];
                text[i]=remplazo;
                remplazo=remp;
            }
        }
        text[text.length-1]=ultima;
    }
    
    public boolean contains (char a) {
        for (int i=0;i<text.length;i++) {
            if (a==text[i]) 
            return true;
        }
        return false;
    }
    
    public int indexOf (char a) {
        for (int i=0;i<text.length;i++) {
            if (a==text[i]) 
            return i;
        }
        return -1;
    }

    public void imprimir(char [] arraylist){
        for (int i=0; i<arraylist.length;i++){
            if (i!=arraylist.length) 
                System.out.print(arraylist[i]);
            else 
                System.out.print(arraylist[i]+" ");
        }
    }
    
    public boolean compararClases (char[] array1, char[] array2){
        return auxComparar(array1,array2,0);
    }
    
    public boolean auxComparar(char[]array1, char[]array2, int index){
        if (array1[index]==array2[index]){
            if (index==array1.length && index==array2.length){
                return true;
            }
            return auxComparar(array1,array2,index+1);
        } else {
            return false;
        }
    }
    
    public int convertInteger(char []array1){
        int []array2 = new int [array1.length];
        for (int i=0; i<array1.length;i++){
            int pos=Character.getNumericValue(i);
            array2[i]=pos;
        }
        return max(array2,0);
    }
    
    public int max(int [] array, int index){
        int max = array[0];
        if (index==array.length){
            return max;
        } else {
            max= Math.max(array[index+1],max(array,index+1));
            return max;
        }
    }
}
