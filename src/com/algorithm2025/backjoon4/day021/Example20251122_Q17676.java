package com.algorithm2025.backjoon4.day021;

import java.util.ArrayList;
import java.util.List;

public class Example20251122_Q17676 { // 코딩테스트 연습 2018 KAKAO blind Reqruiment [1차] 추석 트래픽
    public int solution(String[] lines) {
        int answer = 0;
        List<long[]> log = new ArrayList<>();

        for (String line : lines) {
            String[] parts = line.split(" ");
            String time = parts[1];
            String duration = parts[2].replace("s", "");

            String[] hms = time.split(":");
            long end = (long)((Integer.parseInt(hms[0]) * 3600 + Integer.parseInt(hms[1]) * 60 + Double.parseDouble(hms[2])) * 1000);
            long start = end - (long)(Double.parseDouble(duration) * 1000) + 1;
            log.add(new long[] { start, end });
        }

        for (long[] x : log) {

            answer = Math.max(answer, throughput(log, x[0], x[0] + 1000));
            answer = Math.max(answer, throughput(log, x[1], x[1] + 1000));
        }

        return answer;
    }


    private int throughput(List<long[]> log, long start, long end) {
        int cnt = 0;
        for (long[] x : log) {
            if (x[0] < end && x[1] >= start) {
                cnt += 1;
            }
        }
        return cnt;
    }

}
