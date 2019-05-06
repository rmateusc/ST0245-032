import java.util.LinkedList;
import java.util.Arrays;
import java.util.Iterator; 
/**
 * @rmateusc @daoterog
 */
class Graph{
    private static int vertex; 
    private static LinkedList<Integer>linklist[];
    Graph(int vertex){
        this.vertex=vertex;
        linklist = new LinkedList[vertex];
        
        for (int i=0; i<vertex; i++) {
            linklist[i] = new LinkedList();
        }
    }
    
    void addEdge(int m, int n) {
        linklist[m].add(n);
        linklist[n].add(m);
    }

    static void coloring() {
        int arr[] = new int[vertex];
        Arrays.fill(arr, -1);
        arr[0] = 0;
        boolean b[] = new boolean[vertex];
        Arrays.fill(b, true);
        for (int i=1; i<vertex; i++) {
            Iterator <Integer> it= linklist[i].iterator();
            while(it.hasNext()) {
                int num = it.next();
                if (arr[num] != -1) {
                    b[arr[num]] = false;
                }
            }
            int k;
            for (k=0; k<vertex; k++) {
                if (b[k]) {
                    break;
                }
            }
            arr[i]=k;
            if (k>=2) {
                System.out.println("NOT Bicoloreable");
            }
            Arrays.fill(b, true);
        }
        System.out.println("Bicoloreable");
    }
} 
