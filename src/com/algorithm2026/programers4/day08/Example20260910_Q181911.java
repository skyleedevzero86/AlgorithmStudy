
package com.algorithm2026.programers4.day04;

public class Example20260910_Q181911{ //부분 문자열 이어 붙여 문자열 만들기

    public String solution(String[] my_strings, int[][] parts) {
        StringBuilder answer = new StringBuilder(); // StringBuilder를 사용하여 효율적으로 문자열을 연결

        // 각 문자열에 대해 부분 문자열을 추출하고 이어붙임
        for (int i = 0; i < my_strings.length; i++) {
            String subStr = my_strings[i].substring(parts[i][0], parts[i][1] + 1); // parts[i]는 [s, e] 형태
            answer.append(subStr); // StringBuilder에 부분 문자열 추가
        }

        return answer.toString(); // 최종 문자열을 반환
    }
}