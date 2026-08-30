package com.algorithm2026.programers4.day04;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Example20260830_Q1837 { //GPS
    public int Example20260830_Q1837(String message) {
        final int INF = 987654321;

        // 인접 리스트 생성
        List<List<Integer>> adjList = new ArrayList<>(n + 1);
        for (int i = 0; i <= n; i++) {
            adjList.add(new ArrayList<>());
        }
        for (int i = 0; i < m; i++) {
            int from = edge_list[i][0];
            int to = edge_list[i][1];

            adjList.get(from).add(to);
            adjList.get(to).add(from);
        }

        // D[i][j] : i번째 로그가 j일 때, i번째 j로 오기까지 고쳐야 하는 로그의 최소 횟수
        int[][] D = new int[k][n + 1];
        for (int[] row : D) {
            Arrays.fill(row, INF);
        }

        // 시작경로와 끝 경로는 고정되어 있다.
        D[0][gps_log[0]] = 0;

        // gps_log의 2번째 자리부터 탐색
        for (int i = 1; i < k; i++) {
            // gps_log의 i번째 자리가 j일때, 최소의 고친 횟수를 i - 1번째 값에서부터 가져오기
            for (int j = 1; j <= n; j++) {
                // 이동하지 않고 다음턴에도 그자리에 가만히 있는 경우
                D[i][j] = Math.min(D[i - 1][j], D[i][j]);

                // j에 연결된 인접 노드에서 j로 이동한 경우
                for (int adj : adjList.get(j)) {
                    D[i][j] = Math.min(D[i - 1][adj], D[i][j]);
                }

                // 로그를 고쳤다면 횟수 더해주기
                D[i][j] += (gps_log[i] == j) ? 0 : 1;
            }
        }

        // 올바른 경로로 수정하는 것이 불가능한 경우
        if (D[k - 1][gps_log[k - 1]] >= INF) {
            return -1;
        }

        // 끝 경로로 오기까지 고쳐야 하는 로그의 최소 횟수
        return D[k - 1][gps_log[k - 1]];
    }
}
