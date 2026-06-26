package com.algorithm2026.programers2.day019;

import java.util.stream.IntStream;

public class Example20260626_Q181861 { //코딩테스트 연습 코딩 기초 트레이닝 배열의 원소만큼 추가하기
    public int[] Example20260626_Q181861(int[] arr) {
        return IntStream.of(arr)
                .flatMap(a -> IntStream.generate(() -> a).limit(a))
                .toArray();
    }
}
