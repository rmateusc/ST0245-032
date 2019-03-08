public class Punto1
{
    
    public void insertionSort (int[] array){  
        for (int i=0;i<array.length;i++) { 
            int menor=array[i];
            int j=i+1;
            while (j<array.length) { 
                if (menor>array[j]) { 
                    menor=array[j];
                    array[j]=array[i];
                    array[i]=menor;
                }
                j++;
            }
        }
        System.out.println("InsertionSort");
        System.out.println(array);
    }

    public static void mergeSort(int A[],int left, int rigth){
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (Exception m) {
        }
        if (left<rigth){
            int middle=(left+rigth)/2;
            mergeSort(A,left, middle);
            mergeSort(A,middle+1, rigth);
            merge(A,left, middle, rigth);
        }
    }

    public static void merge(int A[],int left, int middle, int rigth){
        int i, j, k;
        int [] B = new int[A.length]; 
        for (i=left; i<=rigth; i++) 
            B[i]=A[i];

        i=left; j=middle+1; k=left;
        while (i<=middle && j<=rigth) 
            if (B[i]<=B[j])
                A[k++]=B[i++];
            else
                A[k++]=B[j++];
        while (i<=middle) 
            A[k++]=B[i++]; 
    }
    
}
