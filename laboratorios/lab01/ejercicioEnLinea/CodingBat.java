public class Recursion {
// Recursion1:
public int factorial(int n) {//T(n)=n*T(n-1)+C //O(n)=n^2
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
public boolean groupSum6(int start, int[] nums, int target) {
  if (start>=nums.length){
    if (target==0){
      return true;
    }else return false;
  }
  if (nums[start]==6){
    return groupSum6(start+1, nums, target-nums[start]);
  } else return (groupSum6(start + 1, nums, target)||groupSum6(start + 1, nums, target - nums[start]));  
}
  
  public boolean groupSum5(int start, int[] nums, int target) {
        if (target==0 && !aux(start,nums)) return true;
        else if (start==nums.length) || (target<0) return false;
        else if (nums[start]%5==0) return groupSum5(start+1,nums,target-nums[start]);
        else if (nums[start]>target) return false;
        else if (start!=0 && nums[start-1]==5 && nums[start]==1) return groupSum5(start+1,nums,target);
        else return groupSum5(start+1,nums,target-nums[start]) || groupSum5(start+1,nums,target);
    }

    public boolean aux(int start, int[]nums) {
        if (start==nums.length) return false;
        else if (nums[start]%5==0) return true;
        else return aux(start+1,nums);
    }
}
