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

//        String[] vertexValue = {"A", "B", "C", "D", "E", "F", "G", "H"};
        String[] vertexValue = {"1", "2", "3", "4", "5", "6", "7", "8"};
        Graph graph = new Graph(vertexValue.length);
        for (String vertex : vertexValue) {
            graph.insertVertex(vertex);
        }

        graph.insertEdge(0, 1, 1);
        graph.insertEdge(0, 2, 1);
        graph.insertEdge(1, 3, 1);
        graph.insertEdge(1, 4, 1);
        graph.insertEdge(3, 7, 1);
        graph.insertEdge(4, 7, 1);
        graph.insertEdge(2, 5, 1);
        graph.insertEdge(2, 6, 1);
        graph.insertEdge(5, 6, 1);

        graph.dfs();
        System.out.println();
        graph.bfs();
    }
}
