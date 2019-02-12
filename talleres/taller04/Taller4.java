
/**
 * @daoterog @rmateusc
 */
public class Taller4
{
    public static int arrayMax (int [] array, int n) {
        if (n==0) {
            return array[n];
        } else {
            array[n-2]=array[n-2]+array[n-1];
            return arrayMax(array,n-1);
        }
    }

    public static long fibonacci (int n) {
        if (n==1) {
            return 1;
        } else if (n<1) {
            return 0;
        } else {
            return fibonacci(n-1)+fibonacci(n-2);
        }
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
}
