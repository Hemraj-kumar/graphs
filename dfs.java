import java.util.*;
public class dfs {
    boolean[] vis;
    public List<List<Integer>> adj;
    dfs(int v){
        vis=new boolean[v];
        adj=new ArrayList<>();
        for(int i=0;i<v;i++) adj.add(new ArrayList<>());
    }
    void addEdge(int from,int to){
        adj.get(from).add(to);
        adj.get(to).add(from);
    }
    void dfs_i(int s){
        vis[s]=true;
        System.out.println(s+" ");
        for(int i=0;i<adj.get(s).size();i++){
            if(!vis[adj.get(s).get(i)]){
                vis[adj.get(s).get(i)]=true;
                dfs_i(adj.get(s).get(i));
            }
        }
    }
    public static void main(String[] args) {
        dfs m=new dfs(4);
        m.addEdge(0,1);
        m.addEdge(0,2);
        m.addEdge(1, 2);
        m.addEdge(2, 0);
        m.addEdge(2, 3);
        m.addEdge(3, 3);
        m.dfs_i(0);
    }
}
