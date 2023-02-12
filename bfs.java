import java.util.*;
class bfs{
    private int V;
    public List<List<Integer>> adj;
    bfs(int v){
        V=v;
        adj=new ArrayList<>();
        for(int i=0;i<v;i++) adj.add(new ArrayList<>());
    }
    void bfs(int s){
        boolean[] vis=new boolean[V];
        Queue<Integer> qu=new LinkedList<>();
        qu.add(s);
        vis[s]=true;
        while(!qu.isEmpty()){
            int p=qu.poll();
            System.out.println(p+" ");
            for(int i=0;i<adj.get(p).size();i++){
                if(!vis[adj.get(p).get(i)]){
                    vis[adj.get(p).get(i)]=true;
                    qu.offer(adj.get(p).get(i));
                }
            }
        }
    }
    void addEdge(int from,int to){
        adj.get(from).add(to);
        adj.get(to).add(from);
    }
    public static void main(String[] args) {
        bfs m=new bfs(4);
        m.addEdge(0,1);
        m.addEdge(0,2);
        m.addEdge(1, 2);
        m.addEdge(2, 0);
        m.addEdge(2, 3);
        m.addEdge(3, 3);
        m.bfs(0);
    }
}