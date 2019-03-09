
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

    //Array3

    public int[] fix34(int[] nums) {
        int c=next4(nums,0,0);
        int[] n4=new int[c];
        n4=next4(nums,0,0,n4);
        return aux(nums,0,0,n4);
    }

    public int[] aux(int [] nums,int cont,int index,int[] n4){
        if (cont==nums.length) {
            return nums;
        } else if (nums[cont]==3) {
            int r=nums[cont+1];
            nums[cont+1]=nums[n4[index]];
            nums[n4[index]]=r;
            return aux(nums,cont+1,index+1,n4);
        }  else {
            return aux(nums,cont+1,index,n4);
        }
    }

    public int next4 (int [] nums,int index,int cont) {
        if (index==nums.length) {
            return cont;
        } else if (nums[index]==4) {
            return next4(nums,index+1,cont+1);
        } else {
            return next4(nums,index+1,cont);
        }
    }

    public int[] next4 (int [] nums,int index,int cont,int[] n4) {
        if (cont==n4.length) {
            return n4;
        }else if (nums[index]==4) {
            n4[cont]=index;
            return next4(nums,index+1,cont+1,n4);
        } else {
            return next4(nums,index+1,cont,n4);
        }
    }

    public int[] fix45(int[] nums) {
        int c=next5(nums,0,0);
        int[] n4=new int[c];
        n4=next5(nums,0,0,n4);
        return aux1(nums,nums.length-1,0,n4);
    }

    public int[] aux1(int [] nums,int cont,int index,int[] n4){
        if (cont==-1) {
            return nums;
        } else if (nums[cont]==4) {
            int r=nums[cont+1];
            nums[cont+1]=nums[n4[index]];
            nums[n4[index]]=r;
            return aux1(nums,cont-1,index+1,n4);
        }  else {
            return aux1(nums,cont-1,index,n4);
        }
    }

    public int next5 (int [] nums,int index,int cont) {
        if (index==nums.length) {
            return cont;
        } else if (nums[index]==5) {
            return next5(nums,index+1,cont+1);
        } else {
            return next5(nums,index+1,cont);
        }
    }

    public int[] next5 (int [] nums,int index,int cont,int[] n4) {
        if (cont==n4.length) {
            return n4;
        }else if (nums[index]==5) {
            n4[cont]=index;
            return next5(nums,index+1,cont+1,n4);
        } else {
            return next5(nums,index+1,cont,n4);
        }
    }

    public boolean linearIn(int[] outer, int[] inner) {
        if (inner.length==0 && outer.length==0) return true;
        else if (inner.length==0) return true;
        else if (outer.length==0) return false;
        else return aux(outer,inner,0,0);
    }

    public boolean aux (int[] outer,int[] inner, int cont,int cont2) {
        if (cont2==outer.length) {
            return false;
        } else if (inner[cont]==outer[cont2]) {
            if (cont==inner.length-1) {
                return true;
            } else {
                return aux(outer,inner,cont+1,cont2+1);
            }
        } else {
            return aux(outer,inner,cont,cont2+1);
        }
    }
}

