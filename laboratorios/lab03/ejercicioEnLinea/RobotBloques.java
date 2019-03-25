import java.util.*;
public class RobotBloques
{
    static Stack <Integer> lista [];
    static String input;
    static int pos[];
    Scanner sc = new Scanner(System.in);
    public RobotBloques (int n){
        this.lista=new Stack[n];
    }

    public void main(){
        input=sc.nextLine();
        String [] array=input.split(" ");
        String first=array[0];
        String third=array[2];
        int a=Integer.parseInt(array[1]);
        int b=Integer.parseInt(array[3]);
        if (array[1]!=array[3]){
            if (first.equals("move")){
                if (third.equals("onto")){
                    moveOnto(a,b);
                } else if (third.equals("over")){
                    moveOver(a,b);
                }
            } else if (first.equals("pile")){
                if (third.equals("onto")){
                    pileOnto(a,b);
                } else if (third.equals("over")){
                    pileOver(a,b);
                }
            } else if (first.equals("quit")){
                for(int i=0;i<lista.length; i++){
                    System.out.println(terminar(i));
                }
            } else {
                main();
            }
        } else {
            main();
        }
    }

    public void moveOnto(int a, int b){
        limpiar(b);
        moveOver(a,b);
    }

    public void moveOver(int a, int b){
        limpiar(a);
        lista[pos[b]].push(lista[pos[a]].pop());
        pos[a]=pos[b];
    }

    public void pileOnto(int a, int b){
        limpiar (b);
        pileOver(a,b);
    }

    public void pileOver(int a, int b){
        Stack<Integer>pila=new Stack<Integer>();
        while(lista[pos[a]].peek()!=a) {
            pila.push(lista[pos[a]].pop());
        }
        pila.push(lista[pos[a]].pop());
        while(!pila.isEmpty()) {
            int Tmp=pila.pop();
            lista[pos[b]].push(Tmp);
            pos[Tmp]=pos[b];
        }
    }

    public void limpiar(int n){
        while(lista[pos[n]].peek()!=n) {
            retornar(lista[pos[n]].pop());
        }
    }

    public void retornar(int n){
        while(!lista[n].isEmpty()) {
            retornar(lista[n].pop());
        }
        lista[n].push(n);
        pos[n]=n;
    }

    public static String terminar (int n){
        String esp = "";
        while(!lista[n].isEmpty()){
            esp=" "+lista[n].pop()+esp;
            esp=n+":"+esp;
        }
        return esp;
    }
}
//Reference: https://github.com/AhmedHani/Online-Judges-Problems-SourceCode
