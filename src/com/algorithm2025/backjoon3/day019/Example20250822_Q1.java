package com.algorithm2025.backjoon3.day019;

import java.util.Arrays;

public class Example20250822_Q1 { //코딩테스트 연습 2022 KAKAO TECH INTERNSHIP 코딩 테스트 공부


    public static int Example20250822_Q1(int alp, int cop, int[][] problems) {
        int max_alp_req = 0, max_cop_req = 0; // 목표값

        for (int[] problem : problems) {
            max_alp_req = Math.max(max_alp_req, problem[0]);
            max_cop_req = Math.max(max_cop_req, problem[1]);
        }

        int[][] dp = new int[max_alp_req+1][max_cop_req+1];
        for (int i = 0; i <= max_alp_req; i++) {
            Arrays.fill(dp[i], Integer.MAX_VALUE);
        }

        alp = Math.min(alp, max_alp_req); // 둘중 하나라도 목표값을 넘어가면 안된다.
        cop = Math.min(cop, max_cop_req);

        dp[alp][cop] = 0; // dp[i][j]의 의미 : 알고력 i, 코딩력 j을 도달 할 수 있는 최단시간

        for (int i = alp; i <= max_alp_req; i++) {
            for (int j = cop; j <= max_cop_req; j++) {
                if (i < max_alp_req) {
                    dp[i+1][j] = Math.min(dp[i+1][j], dp[i][j] + 1);
                }
                if (j < max_cop_req) {
                    dp[i][j+1] = Math.min(dp[i][j+1], dp[i][j] + 1);
                }

                for (int[] problem : problems) {
                    int alp_req = problem[0];
                    int cop_req = problem[1];
                    int alp_rwd = problem[2];
                    int cop_rwd = problem[3];
                    int cost = problem[4];

                    if (i >= alp_req && j >= cop_req) {
                        int new_alp = Math.min(i+alp_rwd, max_alp_req); // 둘중 하나라도 목표값을 넘어가면 안된다.
                        int new_cop = Math.min(j+cop_rwd, max_cop_req);
                        dp[new_alp][new_cop] = Math.min(dp[new_alp][new_cop], dp[i][j] + cost);
                    }
                }
            }
        }

        return dp[max_alp_req][max_cop_req] == Integer.MAX_VALUE ? -1 : dp[max_alp_req][max_cop_req];
    }
}
