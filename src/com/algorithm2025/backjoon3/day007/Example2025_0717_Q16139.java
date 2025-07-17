package com.algorithm2025.backjoon3.day007;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Example2025_0717_Q16139 { // 인간 컴퓨터 상호작용
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String text = br.readLine();
        int N = text.length();

        int s[][] = new int[26][N + 1];

        for (int i = 1; i <= N; i++) {
            int charIndex = text.charAt(i - 1) - 'a';

            for (int j = 0; j < 26; j++) {
                s[j][i] = s[j][i - 1];
            }
            s[charIndex][i]++;
        }


        int q = Integer.parseInt(br.readLine());


        for (int i = 0; i < q; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            char targetChar = st.nextToken().charAt(0);
            int targetCharIndex = targetChar - 'a';
            int l = Integer.parseInt(st.nextToken());
            int r = Integer.parseInt(st.nextToken());
            int count = s[targetCharIndex][r + 1] - s[targetCharIndex][l];

            bw.write(count + "\n");
        }

        bw.flush();
        br.close();
        bw.close();
    }
}
