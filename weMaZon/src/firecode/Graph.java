package firecode;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by oakinrele on Feb, 2020
 */
public class Graph {

    public static void hasPathBFS(int source, int destination)
    {
        //hasPathBFSHelper(getNode(source), getNode(destination));
    }
    public static void hasPathBFSHelper(GraphNode source, GraphNode destination) {
        final int MAXIMUM_CAPACITY = 2;

        Queue<GraphNode> nextToVisit = new LinkedList<>();
        HashSet<Integer> visited = new HashSet<>();

        nextToVisit.offer(source);

        while (!nextToVisit.isEmpty()) {
            GraphNode node = nextToVisit.poll();

            if (node == destination) {
                System.out.println("true");
            }
            if (visited.contains(node.data)) {
                continue;
            }
            visited.add(node.data);

            for(GraphNode child : node.adjacent)
            {
                nextToVisit.add(child);
            }
        }

        System.out.println("false");
    }

}


class GraphNode
{
    int data;
    Queue<GraphNode> adjacent = new LinkedList<>();

    GraphNode(int data)
    {
        this.data = data;
    }
}
