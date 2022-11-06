package company.fairmoney;


import java.util.*;

/**
 * Created by oakinrele on Jun, 2020
 */
public class ConnectedSum {
    /*
     * Complete the 'connectedSum' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER n
     *  2. STRING_ARRAY edges
     */

    //Build Adjacency List
    //Dfs to find connected nodes
    //Count all connected nodes and find sqrt ceiling

    // 1 2

    /*
        1 : 2, 3
        2: 4
        3: 5
        4:
        5:
        6:
        7: 8
        8:
        9:
        10:
    */
    //Dfs

    public static int connectedSum(int n, List<String> edges) {
        // Write your code here
        List<Integer>[] graph = new ArrayList[n + 1];

        for(int i = 1; i <= n; i++){
            graph[i] = new ArrayList<>();
        }

        System.out.println(Arrays.toString(graph));


        for(String edge : edges){
            String[] nodes = edge.split(" ");
            int u = Integer.parseInt(nodes[0]);
            int v = Integer.parseInt(nodes[1]);
            System.out.println(u);
            System.out.println(v);
            graph[u].add(v);
            graph[v].add(u);
        }

        int sum = 0;
        Set<Integer> visited = new HashSet<>();
        for(int node = 1; node < graph.length; node++){
            double[] totalNodes = new double[1];
            dfs(node, graph, totalNodes, visited);
            int currVal = (int) Math.ceil(Math.sqrt(totalNodes[0]));
            sum += currVal;
        }

        return sum;
    }

    public static void dfs(int node, List<Integer>[] graph, double[] total, Set<Integer> visited){
        if(visited.contains(node)){
            return;
        }

        visited.add(node);
        total[0]++;

        System.out.println("Curr tot: " + total[0]);

        for(int adj : graph[node]){
            dfs(adj, graph, total, visited);
        }
    }


}


class TreeNode
{
    int data;
    TreeNode left;
    TreeNode right;

    TreeNode(int data, TreeNode left,TreeNode right)
    {
        this.data = data;
        this.left = left;
        this.right = right;
    }
}
