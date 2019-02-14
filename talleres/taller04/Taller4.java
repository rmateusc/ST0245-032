
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

    public static long fibonacci (int i) {
        return i <= 1 ? i : fibonacci(i-1)+fibonacci(i-2);
    }

    public static boolean groupSum (int start, int [] array, int target) {
        if (start>=array.length) {
            if (target==0) return true;
            else return false;
        } else if (array[start]>target) {
            return groupSum(start+1,array,target);
        } else if (target-array[start]==0) {
            return true;
        } else {
            return groupSum(start,array,target-array[start]) || groupSum(start+1,array,target);
        }
    }

    /* 
     * public static boolean groupSum1 (int start, int [] array, int target) {
     *   return start>=array.length ? target==0 ? true : false : array[start]>target ? groupSum1(start+1,array,target) : target-array[start]==0 ? true : groupSum1(start,array,target-array[start]) || groupSum1(start+1,array,target);
     * } 
     */
}

