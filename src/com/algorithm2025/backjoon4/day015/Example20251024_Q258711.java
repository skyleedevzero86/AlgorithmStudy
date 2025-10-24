package com.algorithm2025.backjoon4.day015;

import java.util.ArrayList;
import java.util.List;

public class Example20251024_Q258711 { //코딩테스트 연습 2024 KAKAO WINTER INTERNSHIP  도넛과 막대 그래프
    List<Edge>[] G = new ArrayList[1000001];
    Node[] nodes = new Node[1000001];
    boolean[] visited = new boolean[1000000];
    int vCnt, eCnt;

    class Edge{
        int id, to;

        Edge(int id, int to){
            this.id = id;
            this.to = to;
        }
    }

    class Node{
        int in, out;
        boolean visited = true;
    }

    void dfs(int x){
        if(!nodes[x].visited)
            vCnt++;
        nodes[x].visited=true;
        for(Edge e : G[x]){
            if(visited[e.id])
                continue;
            visited[e.id] = true;
            eCnt++;
            dfs(e.to);
        }
    }

    public int[] Example20251024_Q258711(int[][] edges) {
        int[] answer = new int[4];
        for(int i=0;i<G.length;i++){
            G[i] = new ArrayList<>();
            nodes[i] = new Node();
        }
        for(int i=0;i<edges.length;i++){
            int[] e = edges[i];
            G[e[0]].add(new Edge(i, e[1]));
            nodes[e[0]].out++;
            nodes[e[1]].in++;
            nodes[e[0]].visited = nodes[e[1]].visited = false;
        }
        for(int i=1;i<=1000000;i++){
            if(nodes[i].in == 0 && nodes[i].out >= 2){
                answer[0] = i;
                break;
            }
        }
        G[answer[0]].clear();
        nodes[answer[0]].visited = true;
        for(int i=1;i<G.length;i++){
            for(Edge e : G[i]){
                if(i == e.to)
                    continue;
                G[e.to].add(new Edge(e.id, i));
            }
        }
        for(int i=1;i<=1000000;i++){
            if(nodes[i].visited)
                continue;
            vCnt = eCnt = 0;
            dfs(i);
            if(vCnt == eCnt)
                answer[1]++;
            else if(vCnt - 1 == eCnt)
                answer[2]++;
            else
                answer[3]++;
        }
        return answer;
    }
}
