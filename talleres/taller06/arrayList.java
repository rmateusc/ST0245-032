public class textEditor
{    
    char [] text= new char [0];

    public textEditor(){
    }

    public void remove(int index){
        if (index<=text.length){
            text[index]='\u0000';
            reducirTamano(index,text, text.length-1);
        } else 
            System.out.println("Error.arrayindexoutofboundsexception");
    }

    public int size(){
        return text.length;
    }

    public char get(int index){
        if (index<text.length){
            return text[index];
        } else 
            System.out.println("Error.arrayindexoutofboundsexception");
        return '\u0000';
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
            agrandarTamano(text,text.length+1);
            imprimir(text);
            System.out.println(size());
            organizador(index,t);
            imprimir(text);
            System.out.println(size());
        } else 
            agrandarTamano(text,text.length+(index+1-text.length));
        text[index]=t;
    }

    public void organizador (int index, char t){
        if (index==text.length){
            add(t);
        }else{
            char remplazo=text[index];
            for (int i=index; i<text.length-1;i++){
                if (i==index) {
                    text[i]=t;
                } else if (i==text.length-1){
                    text[i]=remplazo;
                } else{
                    
                    char remp = text[i];
                    text[i]=remp;
                    remp=text[i+1];
                }

                /*text[i]=text[i+1];
                text[index]=t;
                text[i+1]=remplazo;
                 */
            }
            
        }
    }

    public void imprimir(char [] arraylist){
        for (int i=0; i<arraylist.length;i++){
            if (i!=arraylist.length) 
                System.out.print(arraylist[i]);
            else 
                System.out.print(arraylist[i]+" ");
        }
    }
}
