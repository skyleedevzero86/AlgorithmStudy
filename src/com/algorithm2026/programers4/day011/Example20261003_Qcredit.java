package com.algorithm2026.programers4.day011;

public class Example20261003_Qcredit{ //학습 크레딧 최소 조합
    public int minimumModules(int[] credits, int target) {
        int unreachable = target + 1;
        int[] dp = new int[target + 1];
        Arrays.fill(dp, unreachable);
        dp[0] = 0;

        for (int x = 1; x <= target; x++) {
            for (int credit : credits) {
                if (credit <= x && dp[x - credit] != unreachable) {
                    dp[x] = Math.min(dp[x], dp[x - credit] + 1);
                }
            }
        }

        return dp[target] == unreachable ? -1 : dp[target];
    }
}