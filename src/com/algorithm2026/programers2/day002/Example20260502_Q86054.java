package com.algorithm2026.programers2.day002;

import java.util.*;

public class Example20260502_Q86054 { //안티세포 복습

    static List<Map<Long, Integer>> levels;
    static long sum[];
    static final int MOD = 1000000007;

    public int[] Example20260502_Q86054(int[] a, int[] s) {
        int[] answer = new int[s.length];
        int idx = 0;

        int start, end = 0;
        for(int t = 0; t < s.length; t++){
            int n = s[t];
            start = end;
            end = start + n;
            sum = new long[n+1];
            sum[0] = 1;

            levels = new ArrayList<>();
            for(int i = 0; i <= n; i++){
                levels.add(new HashMap<>());
            }

            levels.get(0).put(new Long(-1),-1);

            for(int i = 1; i <= n; i++){
                sum[i] = connect(a[start + i - 1], i, i-1);
            }

            answer[t] = (int) ((sum[n])%MOD);
        }

        return answer;
    }

    static long connect(long num, int here, int par){
        Map<Long,Integer> level = levels.get(here);
        if(!level.containsKey(num)){
            level.put(num, par);
        }

        long ret = sum[par];

        if(levels.get(par).containsKey(num)){
            ret += connect(num * 2, here, levels.get(par).get(num));
            ret %= MOD;
        }

        return ret;
    }

}



