package com.algorithm2026.programers4.day07;

public class Example20260830_Q181854 { //배열의 길이에 따라 다른 연산하기


    public int[] Example20260830_Q181854(int[] arr, int n) {
        int[] answer = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            answer[i] = arr[i];
        }

        boolean isOddLength = arr.length % 2 != 0;

        for (int i = 0; i < answer.length; i++) {
            if (isOddLength) {
                if (i % 2 == 0) {
                    answer[i] += n;
                }
            } else {
                if (i % 2 == 1) {
                    answer[i] += n;
                }
            }
        }

        return answer;
    }
}