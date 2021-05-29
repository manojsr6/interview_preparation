import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;

public class Bridge {
    private int v;
    private LinkedList<Integer> adj[];
    int time=0;
    static final int NIL= -1;

    Bridge(int v)
    {
        this.v= v;
        adj= new LinkedList[v];
        for(int i= 0; i<v;i++)
        {
            adj[i]= new LinkedList<Integer>();
        }
    }
    void addEdge(int v, int w)
    {
        adj[v].add(w);
        adj[w].add(v);
    }

    void bridgeUtil(int u, boolean visited[], int dis[], int low[], int parent[])
    {
        visited[u]= true;
        dis[u]= low[u]= ++time;

        Iterator<Integer> i= adj[u].iterator();

        while(i.hasNext())
        {
            int v= i.next();

            if(!visited[v])
            {
                parent[v]= u;
                bridgeUtil(v, visited, dis, low, parent);

                low[u]= Math.max(low[u], low[v]);

                if(low[v] > dis[u])
                {
                    System.out.println(u+" "+v);
                }
            }
            else if (v != parent[u])
                low[u]= Math.min(low[u],dis[v]);
        }
    }
    void criticalBridge()
    {
        boolean visited[]= new boolean[v];
        int disc[]= new int[v];
        int low[]= new int[v];
        int parent[]= new int[v];

        for(int i= 0; i<v; i++)
        {
            parent[i]= NIL;
            visited[i]= false;
        }

        for(int i=0;i<v;i++)
        {
            if(visited[i] == false)
            {
                bridgeUtil(i, visited, disc, low, parent);
            }
        }
    }

    public static void main(String args[])
    {
            // Create graphs given in above diagrams
            System.out.println("Bridges in first graph ");
            Bridge g1 = new Bridge(5);
            g1.addEdge(1, 0);
            g1.addEdge(0, 2);
            g1.addEdge(2, 1);
            g1.addEdge(0, 3);
            g1.addEdge(3, 4);
            g1.criticalBridge();
            System.out.println();
    }
}
