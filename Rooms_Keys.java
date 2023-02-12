import java.util.*;
public class Rooms_Keys {
    static boolean bfs(Map<Integer, List<Integer>> map){
        Queue<Integer> qu=new LinkedList<>();
        boolean[] vis=new boolean[map.size()];
        qu.add(0);vis[0]=true;
        while(!qu.isEmpty()){
            int s=qu.poll();
            for(int i=0;i<map.get(s).size();i++){
                if(!vis[map.get(s).get(i)]){
                    vis[map.get(s).get(i)]=true;
                    qu.add(map.get(s).get(i));
                }
            }
        }
        for(boolean i:vis) {
            if (!i) return false;
        }return true;
    }
    static boolean check(Map<Integer, List<Integer>> map){
        boolean res=bfs(map);
        return res;
    }
    public static void main(String[] args) {
        Map<Integer,List<Integer>> map=new HashMap<>();
        for(int i=0;i<4;i++){
            map.put(i,new ArrayList<>());
        }
        map.get(0).add(1);
        map.get(0).add(3);

        map.get(1).add(3);
        map.get(1).add(0);
        map.get(1).add(1);

        map.get(2).add(2);

        map.get(3).add(0);

        if(check(map)) System.out.println("Can complete");
        else System.out.println("cannot complete");

    }
}
