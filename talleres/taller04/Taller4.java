
/**
 * @daoterog @rmateusc
 */
public class Taller4
{
    public static int suma (int [] array) {
        return arrayAux(array,0);
    }
    
    public static int arrayAux (int [] array, int n) {
        return n==array.length-1 ? array[n] : array[n]+arrayAux(array,n+1);
    }
    
    public static int arrayAux (int [] array, int n) { 
        if (n==array.length-1) { //C1
            return array[n]; //C2
        } else {
            return array[n]+arrayAux(array,n+1); //C3+T(n-1)
        }
    }

    public static long fibonacci (int i) {
        if (i<=1) {//C1
            return i;//C2
        } else 
            return fibonacci(i-1)+fibonacci(i-2);//C3+T(n-1)
        }
    }
    
    public static long fibonacci (int i) {
        return i <= 1 ? i : fibonacci(i-1)+fibonacci(i-2);
    }

    public static boolean groupSum (int start, int [] array, int target) {
        if (start>=array.length) { //C1
            if (target==0) {//C2 
                return true;//C3
            } else {
                return false;//C4
            }
        } else if (array[start]>target) {//C5
            return groupSum(start+1,array,target);//C6+T(n-1)
        } else if (target-array[start]==0) {//C7
            return true;//C8
        } else {
                return groupSum(start+1,array,target-array[start]) || groupSum(start+1,array,target);//C10+T(n-1)
        }
    }

    /* 
     * public static boolean groupSum1 (int start, int [] array, int target) {
     *   return start>=array.length ? target==0 ? true : false : array[start]>target ? groupSum1(start+1,array,target) : target-array[start]==0 ? true : groupSum1(start,array,target-array[start]) || groupSum1(start+1,array,target);
     * } 
     */
}

