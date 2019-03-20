import java.util.Stack;
public class Punto1
{
    Stack <Double> stack = new Stack();
    public void reversePolish (String str){
        String[]sep=str.split(" ");            
        for (int i=0; i<sep.length;i++){
            try {
                Integer.parseInt(sep[i]);
                double a= (double)(Integer.parseInt(sep[i]));
                stack.push(a);                
            } catch (NumberFormatException e){
                if (sep[i].equals("+")){
                    double a=stack.pop();                    
                    double b=stack.pop();
                    double c=a+b;
                    stack.push(c);
                }else if (sep[i].equals("-")){                    
                    double a=stack.pop();
                    double b=stack.pop();
                    stack.push(b-a);
                } else if (sep[i].equals("*")){                    
                    double a=stack.pop();
                    double b=stack.pop();
                    stack.push(a*b);
                } else if (sep[i].equals("/")){
                    double a=stack.pop();
                    double b=stack.pop();
                    stack.push(b/a);
                } else if (sep[i].equals("^")){
                    double a=stack.pop();
                    double b=stack.pop();
                    stack.push(Math.pow(a,b));
                } else {
                    System.out.println ("El operador esta malo");
                }
            }
        }
        System.out.println ("Respuesta: "+stack.pop());
    }
}
