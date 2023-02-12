import java.util.*;
public class Bipartite {
    public List<List<Integer>> adj;
    Bipartite(int v){
        adj=new ArrayList<>();
        for(int i=0;i<v;i++) adj.add(new ArrayList<>());
    }
    void addEdge(int from,int to){
        adj.get(from).add(to);
        adj.get(to).add(from);
    }
    public boolean bfs(int i,int[] color){
        Queue<Integer> qu=new LinkedList<>();
        qu.add(i);color[i]=0;
        while(!qu.isEmpty()) {
            int y = qu.poll();
            for (int j = 0; i < adj.get(y).size(); j++) {
                if (color[j] == -1) {
                    color[j] = 1 + color[y];
                    qu.add(j);
                } else if (color[j] == color[y]) {
                    return false;
                }
            }
        }return true;
    }
    public boolean check(int n){
        int[] color=new int[n];
        for(int i:color) color[i]=-1;

        for(int i=0;i<n;i++){
            if(!bfs(i,color)) return false;
        }return true;
    }
    public static void main(String[] args) {
        Bipartite b=new Bipartite(7);
        b.addEdge(0,1);
        b.addEdge(1,0);

        b.addEdge(1,2);
        b.addEdge(2,1);

        b.addEdge(2,3);
        b.addEdge(3,2);

        b.addEdge(4,3);
        b.addEdge(3,4);

        b.addEdge(4,5);
        b.addEdge(5,4);

        b.addEdge(4,6);
        b.addEdge(6,4);

        b.addEdge(1,6);
        b.addEdge(6,1);
        int n=7;
        if(b.check(n)) System.out.println("Yes bipartite");
        else System.out.println("No");
    }
}
