package com.algorithm2026.programers2.day033;

public class Example20260731_Q181879 { // 접두사인지 확인하기

   public int solution(String my_string, String is_prefix) {
      // my_string이 is_prefix로 시작하는지 확인
      if (my_string.startsWith(is_prefix)) {
         return 1; // 접두사가 맞으면 1을 반환
      } else {
         return 0; // 접두사가 아니면 0을 반환
      }
   }

   public static void main(String[] args) {
      Solution sol = new Solution();

      // 테스트 예시들
      System.out.println(sol.solution("banana", "ban")); // 1
      System.out.println(sol.solution("banana", "nan")); // 0
      System.out.println(sol.solution("banana", "abcd")); // 0
      System.out.println(sol.solution("banana", "bananan")); // 0
   }
}