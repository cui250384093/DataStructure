package com.yl.graph;

import java.util.*;

/**
 * @author candk
 * @Description
 * @date 3/26/21 - 2:05 PM
 */
public class Graph {

    private ArrayList<String> vertexList;
    private int[][] edges;
    private int numOfEdges;
    private boolean[] isVisited;

    public Graph() {
    }

    public Graph(int n) {
        edges = new int[n][n];
        vertexList = new ArrayList<>(n);
        numOfEdges = 0;
    }

    /**
     * 插入顶点
     * @param vertex
     */
    public void insertVertex(String vertex) {
        vertexList.add(vertex);
    }

    /**
     * 插入边
     * @param v1 顶点1下标
     * @param v2 顶点2下标
     * @param weight 权值
     */
    public void insertEdge(int v1, int v2, int weight) {
        edges[v1][v2] = weight;
        edges[v2][v1] = weight;
        numOfEdges++;
    }

    /**
     * 返回顶点数目
     * @return
     */
    public int getNumOfVertex() {
        return vertexList.size();
    }

    /**
     * 返回边数目
     * @return
     */
    public int getNumOfEdges() {
        return numOfEdges;
    }

    /**
     * 返回下标对应顶点名称
     * @param index
     * @return
     */
    public String getVertexByIndex(int index) {
        return vertexList.get(index);
    }

    /**
     * 返回边权值
     * @param v1
     * @param v2
     * @return
     */
    public int getWeight(int v1, int v2) {
        return edges[v1][v2];
    }

    public void showGraph() {
        for (int[] edge : edges) {
            System.out.println(Arrays.toString(edge));
        }
    }

    /**
     * 得到第一个邻接顶点的下标
     * @param index 原顶点下标
     * @return 邻接顶点下标，没有则为 -1
     */
    public int getFirstNeighbor(int index) {
        for (int i = 0; i < vertexList.size(); i++) {
            if (edges[index][i] > 0) {
                return i;
            }
        }
        return -1;
    }

    /**
     * 根据前一个邻接顶点下标来获取下一个邻接顶点
     * @param v1
     * @param v2
     * @return
     */
    public int getNextNeighbor(int v1, int v2) {
        for (int i = v2 + 1; i < vertexList.size(); i++) {
            if (edges[v1][i] > 0) {
                return i;
            }
        }
        return -1;
    }

    /**
     * 深度遍历图 deep first search
     * @param isVisited
     * @param i
     */
    public void dfs(boolean[] isVisited, int i) {
        System.out.print(getVertexByIndex(i) + "->");
        isVisited[i] = true;
        int w = getFirstNeighbor(i);
        while (w != -1) {
            if (!isVisited[w]) {
                dfs(isVisited, w);
            }

            w = getNextNeighbor(i, w);
        }
    }

    /**
     * 深度优先遍历的重载
     */
    public void dfs() {
        isVisited = new boolean[getNumOfVertex()];
        for (int i = 0; i < getNumOfVertex(); i++) {
            if (!isVisited[i]) {
                dfs(isVisited, i);
            }
        }
    }

    /**
     * 广度优先遍历 broad first search
     * @param isVisited
     * @param i
     */
    public void bfs(boolean[] isVisited, int i) {
        //队列头结点下标
        int u;
        //邻接结点下标
        int w;
        //队列
        LinkedList<Integer> queue = new LinkedList<Integer>();
        System.out.print(getVertexByIndex(i) + "->");
        isVisited[i] = true;
        queue.addLast(i);

        while (!queue.isEmpty()) {
            u = queue.removeFirst();
            w = getFirstNeighbor(u);
            while (w != -1) {
                if (!isVisited[w]) {
                    System.out.print(getVertexByIndex(w) + "->");
                    isVisited[w] = true;
                    queue.addLast(w);
                }

                //以u为前驱点，找w后面的下一个邻接点
                w = getNextNeighbor(u, w);
            }
        }
    }


    public void bfs() {
        isVisited = new boolean[getNumOfVertex()];
        for (int i = 0; i < getNumOfVertex(); i++) {
            if (!isVisited[i]) {
                bfs(isVisited, i);
            }
        }
    }
}
