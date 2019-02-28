
/**
 * @daoterog @rmateusc
 */
public class Taller5
{
    public static int[] insertionSort (int[] array){ //T(n)=n*(n-1)*C//O(n)=n^2 
        for (int i=0;i<array.length;i++) { //T(n)=n*(C2+C3)
            int menor=array[i];//C2
            int j=i+1;//C3
            while (j<array.length) { //T(n)=(n-1)*(C5+C6+C7+C8)
                if (menor>array[j]) { //C5
                    menor=array[j];//C6
                    array[j]=array[i];//C7
                    array[i]=menor;//C8
                }
                j++;//C9
            }
        }
        return array;//C10
    }

    public static int suma (int[]array){ //T(n)=(n*C2)+C T(n)=O(n)
        int suma=0; //C1
        for (int i=0;i<array.length;i++) { //T(n)=n*C2
            suma+=array[i];//C2
        }
        return suma;//C4
    }

    public static void mul (int num){ //T(n)=(n^2)C//O(n)=n^2
        for (int i=0;i<=num;i++) { //T(n)=n 
            for (int j=0;j<=num;j++) { //T(n)=n*C2
                System.out.println(i+"*"+j+"="+j*i); //C2
            }
        } 
    }
}
