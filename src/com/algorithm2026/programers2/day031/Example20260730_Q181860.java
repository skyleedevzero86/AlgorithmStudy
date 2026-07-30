package com.algorithm2026.programers2.day031;

import java.util.ArrayList;
import java.util.List;

public class Example20260730_Q181860 { //빈 배열에 추가, 삭제하기

    public List<Integer> solution(int[] arr, boolean[] flag) {
        List<Integer> X = new ArrayList<>();

        for (int i = 0; i < arr.length; i++) {
            if (flag[i]) {
                // flag[i]가 true인 경우 arr[i] × 2 번 arr[i]를 추가
                for (int j = 0; j < arr[i] * 2; j++) {
                    X.add(arr[i]);
                }
            } else {
                // flag[i]가 false인 경우 arr[i]개의 원소를 제거
                for (int j = 0; j < arr[i]; j++) {
                    if (!X.isEmpty()) {
                        X.remove(X.size() - 1);
                    }
                }
            }
        }

        return X;
    }

    public static void main(String[] args) {
        Example20260730_Q181860 solution = new Example20260730_Q181860();

        int[] arr = {3, 2, 4, 1, 3};
        boolean[] flag = {true, false, true, false, false};

        List<Integer> result = solution.solution(arr, flag);
        System.out.println(result);  // [3, 3, 3, 3, 4, 4, 4, 4]
    }

}
