
/**
 * @daoterog @rmateusc
 */
public class CodingBat
{
    public String[] fizzBuzz(int start, int end) {
        String [] l = new String [end-start];
        return aux(start,end,l,0);
    }

    public String[] aux(int start,int end,String[] l,int cont) {
        if (start==end){
            return l;
        } else {
            if (start%3==0 && start%5==0) {
                l[cont]="FizzBuzz";
                return aux(start+=1,end,l,cont+=1);
            } else if (start%5==0) {
                l[cont]="Buzz";
                return aux(start+=1,end,l,cont+=1);
            } else if (start%3==0) {
                l[cont]="Fizz";
                return aux(start+=1,end,l,cont+=1);
            } else {
                l[cont]=start+"";
                return aux(start+=1,end,l,cont+=1);
            }
        }
    }  

    public int[] zeroMax(int[] nums) {
        if (nums.length==0) return nums;
        else return zeroAux(nums,0);
    }

    public int[]zeroAux(int[]nums,int cont) {
        if (cont==nums.length-1) {
            return nums;
        } else if (nums[cont]==0) {
            nums[cont]=aux(nums,cont+1,0);
            return zeroAux(nums,cont+=1);
        } else {
            return zeroAux(nums,cont+=1);
        }
    }

    public int aux (int[]nums, int index, int max) {
        if (index==nums.length) {
            return max;
        } else if (nums[index]%2==1 && nums[index]>max) {
            max=nums[index];
            return aux(nums,index+=1,max);
        } else {
            return aux(nums,index+=1,max);
        }
    }

    public int[] zeroFront(int[] nums) {
        if (nums.length==0) return nums;
        else return zeroAuxF(nums,0);
    }

    public int[] zeroAuxF (int[] nums, int cont) {
        if (cont==nums.length-1) {
            return nums;
        } else if (nums[cont]!=0 && nums[cont+1]==0) {
            int r=nums[cont+1];
            nums[cont+1]=nums[cont];
            nums[cont]=r;
            return zeroAuxF(nums,cont+=1);
        } else if (nums[cont]!=0 && nums[cont+1]!=0) {
            int a=aux1(nums,cont);
            if (a==-1) {
                return nums;
            } else {
                nums[a]=nums[cont];
                nums[cont]=0;
                return zeroAuxF(nums,cont+=1);
            }
        } else {
            return zeroAuxF(nums,cont+=1);
        }
    }

    public int aux1 (int[] nums, int index) {
        if (nums.length==index) {
            return -1;
        } else if (nums[index]==0) {
            return index;
        } else {
            return aux1(nums,index+=1);
        }
    }

    public int[] notAlone(int[] nums, int val) {
        if (nums.length<3) return nums;
        else return aux3(nums,val,1);
    }

    public int[] aux3 (int[] nums, int val,int cont) {
        if (cont==nums.length-1) {
            return nums;
        } else if (nums[cont]==val) {
            if (nums[cont-1]>nums[cont+1]){
                nums[cont]=nums[cont-1];
            } else {
                nums[cont]=nums[cont+1];
            }
            return aux3(nums,val,cont+=1);
        } else {
            return aux3(nums,val,cont+=1);
        }
    }

    public int[] post4(int[] nums) {
        int ind=aux2(nums,0,-1);
        int[] nuevo=new int [nums.length-ind-1];
        return auxP4(nums,nuevo,ind+1,0);
    }

    public int[] auxP4(int[] nums,int[] nuevo,int ind, int cont) {
        if (ind==nums.length) {
            return nuevo;
        } else {
            nuevo[cont]=nums[ind];
            return  auxP4(nums,nuevo,ind+=1,cont+=1);
        }
    }

    public int aux2 (int[] nums, int index, int f) {
        if (nums.length==index) {
            return f;
        } else if (nums[index]==4) {
            f=index;
            return aux2(nums,index+=1,f);
        } else {
            return aux2(nums,index+=1,f);
        }
    }
    
    //Array 3
    public int maxSpan(int[] nums) {
  if (nums.length<=1){
    return nums.length;
  } else if (nums[0]==nums[nums.length-1]){
  return nums.length;
  } else {
    return nums.length-1;
  }
}
}
