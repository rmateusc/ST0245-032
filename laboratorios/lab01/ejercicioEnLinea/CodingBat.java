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
public boolean groupSum6(int start, int[] nums, int target) {//T(n)=3*T(n-1)+C
  if (start>=nums.length){ //C1
    if (target==0){//C2
      return true;//C3
    }else return false;//C4
  }
  if (nums[start]==6){ //C5
    return groupSum6(start+1, nums, target-nums[start]); //T(n-1)+C6
  } else return (groupSum6(start + 1, nums, target)||groupSum6(start + 1, nums, target - nums[start]));//T(n-1)+T(n-1)+C7  
}
  
  public boolean groupSum5(int start, int[] nums, int target) { //T(n)=3*T(n-1)+C
        if (target==0 && !aux5(start,nums)) return true; //C1
        else if (start==nums.length) || (target<0) return false;//C2
        else if (nums[start]%5==0) return groupSum5(start+1,nums,target-nums[start]);//T(n-1)+C3
        else if (nums[start]>target) return false;//C4
        else if (start!=0 && nums[start-1]==5 && nums[start]==1) return groupSum5(start+1,nums,target); //T(n-1)+C4
        else return groupSum5(start+1,nums,target-nums[start]) || groupSum5(start+1,nums,target); //T(n-1)+T(n-1)+C5
    }

    public boolean aux5(int start, int[]nums) {//T(n)=T(n-1)+c
        if (start==nums.length) return false;//C1
        else if (nums[start]%5==0) return true;//C2
        else return aux(start+1,nums);//T(n-1)+C3
    }
}

public boolean splitArray(int[] nums) {
  return auxArray(nums,0,0,0); //C
}

public boolean auxArray(int []nums, int start, int g1, int g2){//T(n)=2*T(n-1)+C
  if (start==nums.length){//C1
    if (g1==g2){//C2
      return true;//C3
    } else return false;
  } else return auxArray(nums,start+1,g1+nums[start],g2)||auxArray(nums,start+1,g1,g2+nums[start]);//T(n-1)+T(n-1)
}
  
  public boolean splitOdd10(int[] nums){
  return auxSplit(nums,0,0,0);//C
}

public boolean auxSplit(int []nums, int start, int g1, int g2){//T(n)=2*T(n-1)+C
  if (start==nums.length){ //C1
    if (g1%10==0 && g2%2!=0){//C2
       return true;//C3
    } else return false;
  } else return auxSplit(nums, start+1, g1+nums[start],g2)||auxSplit(nums, start+1,g1,g2+nums[start]);//C4+T(n-1)+T(n-1)
}
  
  public boolean split53(int[] nums) {
  return aux53(nums,0,0,0);//C
}

public boolean aux53(int []nums, int start, int g1, int g2){//T(n)=4*T(n-1)+C
  if (start>=nums.length){//C1
    if (g1==g2){//C2
      return true;//C3
    } else return false;
  } else if (nums[start]%5==0){//C4
    return aux53(nums, start+1, g1+nums[start], g2);//T(n-1)+C5
  } else if (nums[start]%3==0){ //C6
    return aux53(nums, start+1, g1, g2+nums[start]);//T(n-1)+C7
  } else 
    return aux53(nums, start+1, g1+nums[start],g2) || aux53(nums, start+1, g1, g2+nums[start]);//C8+T(n-1)+T(n-1)
}
    }
