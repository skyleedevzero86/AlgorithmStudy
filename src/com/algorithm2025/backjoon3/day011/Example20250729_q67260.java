package com.algorithm2025.backjoon3.day011;

import java.util.*;

public class Example20250729_q67260 { //코딩테스트 연습2020 카카오 인턴십 동굴 탐험

    static final int MAX = 200000; // 2e5
    static List<Integer>[] edge = new List[MAX];
    static Set<Integer> s = new HashSet<>();
    static int[] key = new int[MAX], needKey = new int[MAX];
    static boolean[] check_visit = new boolean[MAX];

    public static void BFS(int node){
        Queue<Integer> q = new LinkedList<>();
        q.offer(node);
        check_visit[node] = true;

        if(needKey[0] != 0) return;

        while(!q.isEmpty()){
            int tmp = q.poll();
            needKey[key[tmp]] = 0;

            if(s.contains(key[tmp])){
                s.remove(key[tmp]);
                q.offer(key[tmp]);
                check_visit[key[tmp]] = true;
            }
            for(int it : edge[tmp]){
                if(check_visit[it]) continue;
                if(needKey[it] != 0){
                    s.add(it);
                    continue;
                }
                check_visit[it] = true;
                q.offer(it);
            }
        }
    }

    public static boolean Example20250729_q67260(int n, int[][] path, int[][] order) {
        for(int i=0; i<MAX; i++) {
            edge[i] = new ArrayList<>();
        }
        for(int[] it : path){
            edge[it[0]].add(it[1]);
            edge[it[1]].add(it[0]);
        }
        for(int[] it : order){
            key[it[0]] = it[1];
            needKey[it[1]] = it[0];
        }
        BFS(0);
        for(int i = 0 ; i < n ; i++) if(!check_visit[i]) return false;
        return true;
    }
}
