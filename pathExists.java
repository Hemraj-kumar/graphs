import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class pathExists {
    public List<List<Integer>> adj;
    pathExists(int v){
        adj=new ArrayList<>();
        for(int i=0;i<v;i++) {
            adj.add(new ArrayList<>());
        }
    }
    void addEdge(int from,int to){
        adj.get(from).add(to);
        adj.get(to).add(from);
    }
    public boolean bfs(int s,int d){
        Queue<Integer> qu=new LinkedList<>();
        boolean[] vis=new boolean[3];
        qu.add(s);vis[s]=true;
        while(!qu.isEmpty()){
            int y=qu.poll();
            if(y == d) return true;
            for(int i=0;i<adj.get(y).size();i++){
                if(!vis[adj.get(y).get(i)]){
                    vis[adj.get(y).get(i)]=true;
                    qu.add(adj.get(y).get(i));
                }
            }
        }
        return false;
    }
    public boolean check(int s,int d){
        boolean res=bfs(s,d);
        return res;
    }

    public static void main(String[] args) {
        pathExists p=new pathExists(4);
        p.addEdge(0,1);
        p.addEdge(1,0);

        p.addEdge(1,2);
        p.addEdge(2,1);

        p.addEdge(0,2);
        p.addEdge(2,0);

//        p.addEdge(5,4);
//        p.addEdge(4,5);
//
//        p.addEdge(4,3);
//        p.addEdge(3,4);

        int s=0,d=2;
        if(p.check(s,d)) System.out.println("There exists");
        else System.out.println("There do not exists");
    }
}
