public class tester
{
    public void main (){
        textEditor arraylist = new textEditor();
        System.out.println (arraylist.size());
        arraylist.add('r');
        System.out.println(arraylist.size());
        imprimir(arraylist);
        arraylist.remove(0);
        System.out.println(arraylist.size());
        imprimir(arraylist);
        arraylist.add('r');
        arraylist.add('a');
        arraylist.add('f');
        arraylist.add('a');
        arraylist.add('e');
        arraylist.add('l');
        arraylist.add('m');
        arraylist.add('a');
        arraylist.add('t');
        arraylist.add('i');
        arraylist.add('u');
        arraylist.add('s');
        imprimir(arraylist);
        System.out.println(arraylist.size());
        arraylist.add(9,'e');
        imprimir(arraylist);
        System.out.println(arraylist.size());
        //imprimir(arraylist);
        //arraylist.remove(10);
        //imprimir(arraylist);
    }
    
    public void imprimir(textEditor arraylist){
        for (int i=0; i<arraylist.size();i++){
            System.out.print(arraylist.get(i)+"");
        }
    }
}

