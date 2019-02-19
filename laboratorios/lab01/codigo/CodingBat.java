public class Recursion {
// Recursion1:
public int factorial(int n) {
  if (n==1){
      return n;
  } else 
  return n*factorial(n-1);
}

public String changePi(String str) {
   if(str.contains("pi")){
     str=str.replace("pi","3.14");
     return str;
   } else
  return str;
}

public String noX(String str) {
  if(str.contains("x")){
    str=str.replace("x","");
    return str;
  }else
  return str;
}

public int fibonacci(int n) {
  if (n>=2){
    return fibonacci(n-1)+fibonacci(n-2);
  } else 
  return n;
}
  
  public int triangle(int rows) {
  if (rows<=1){
    return rows;
  } else {
    return rows+triangle(rows-1);
  }
}
//Recusion2:

}

