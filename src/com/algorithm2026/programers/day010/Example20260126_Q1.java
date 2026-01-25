package com.algorithm2026.programers.day010;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Example20260126_Q1 { //코딩테스트 연습 2019 카카오 개발자 겨울 인턴십  호텔 방 배정
    static Map<Long, Long> room = new HashMap<>();

    static long findRoom(long n) {
        if (!room.containsKey(n)) {
            return n;
        }

        long next = findRoom(room.get(n));
        room.put(n, next);
        return next;
    }

    public static long[] solution(long k, long[] room_number) {
        long[] answer = new long[room_number.length];

        for (int i = 0; i < room_number.length; i++) {
            long num = room_number[i];

            if (!room.containsKey(num)) {
                room.put(num, findRoom(num + 1));
                answer[i] = num;
            } else {
                long nextNum = findRoom(num);
                room.put(nextNum, findRoom(nextNum + 1));
                answer[i] = nextNum;
            }
        }

        return answer;
    }
}