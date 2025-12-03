package com.algorithm2025.backjoon4.day026;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

public class Example20251203_Q138475 {
    public List<Integer> Example20251203_Q138475(int e, int[] starts) {
        List<Integer> answer = new ArrayList<>();

        // 1부터 e까지 약수 개수 계산
        int[] divisor = new int[e + 1]; // 충분한 크기로 선언
        IntStream.rangeClosed(1, e).forEach(i -> divisor[i] = 1);
        IntStream.rangeClosed(2, e).forEach(i ->
                IntStream.iterate(i, j -> j <= e, j -> j += i).forEach(j -> divisor[j]++)
        );

        // starts 배열 유효성 검사
        for (int start : starts) {
            if (start < 1 || start > e) {
                // 유효하지 않은 값 처리
                throw new IllegalArgumentException("Invalid start value: " + start);
            }
        }

        // starts 배열 정렬 및 반복
        Arrays.stream(starts).sorted().forEach(start -> {
            int maxIndex = IntStream.rangeClosed(start, e)
                    .reduce((a, b) -> divisor[a] >= divisor[b] ? a : b).getAsInt();
            answer.add(maxIndex);
        });

        return answer;
    }
}
