package com.yl.graph;

import org.junit.jupiter.api.Test;

/**
 * @author candk
 * @Description
 * @date 3/26/21 - 2:20 PM
 */
public class GraphTest {

    @Test
    public void test1() {

        String[] vertexValue = {"A", "B", "C", "D", "E"};
        Graph graph = new Graph(vertexValue.length);
        for (String vertex : vertexValue) {
            graph.insertVertex(vertex);
        }

        graph.insertEdge(0, 1, 1);
        graph.insertEdge(0, 2, 1);
        graph.insertEdge(1, 2, 1);
        graph.insertEdge(1, 3, 1);
        graph.insertEdge(1, 4, 1);

        graph.dfs();
        System.out.println();
        graph.bfs();
    }
}
