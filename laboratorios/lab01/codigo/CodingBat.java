public class Recursion {
// Recursion1:
public int factorial(int n) {//T(n)=n*T(n-1)+C //O(n)=
  if (n==1){ //C1
      return n;//C2
  } else //C3
  return n*factorial(n-1);//T(n)=C4+T(n-1)
}

public String changePi(String str) {//T(n)=C //O(n)=1
   if(str.contains("pi")){ //C1
     str=str.replace("pi","3.14"); //C2
     return str; //C3
   } else //C4
  return str; //C5
}

public String noX(String str) { //T(n)=C O(n)=1
  if(str.contains("x")){ //C1
    str=str.replace("x",""); //C2
    return str;//C3
  }else //C4
  return str;//C5
}

public int fibonacci(int n) {//T(n)=C+T(n-1)+T(n-2) //O(n)=2^n
  if (n>=2){ //C1
    return fibonacci(n-1)+fibonacci(n-2); //C2+T(n-1)+T(n-2)
  } else //C3
  return n; //C4
}
  
  public int triangle(int rows) {//T(n)=C+(n-1) //O(n)=n
  if (rows<=1){ //c1
    return rows; //c2
  } else {//c3
    return rows+triangle(rows-1);//c4+T(n-1)
  }
}
//Recusion2:

}

