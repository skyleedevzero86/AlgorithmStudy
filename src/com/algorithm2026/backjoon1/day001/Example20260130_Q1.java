package com.algorithm2026.backjoon1.day001;

import java.io.*;
import java.util.*;

public class Example20260130_Q1 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for (int t = 0; t < T; t++) {
            int N = Integer.parseInt(br.readLine());

            int[][] arr = new int[N][2];
            for (int i = 0; i < N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                arr[i][0] = Integer.parseInt(st.nextToken());
                arr[i][1] = Integer.parseInt(st.nextToken());
            }

            // 서류 점수 기준 정렬
            Arrays.sort(arr, (a, b) -> a[0] - b[0]);

            int cnt = 1;
            int max = arr[0][1];

            for (int i = 1; i < N; i++) {
                if (arr[i][1] < max) {
                    cnt++;
                    max = arr[i][1];
                }
            }

            sb.append(cnt).append('\n');
        }

        System.out.print(sb);
    }

}
