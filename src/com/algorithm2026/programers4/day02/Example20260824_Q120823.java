package com.algorithm2026.programers4.day02;

public class Example20260824_Q120823 { //직각삼각형 출력하기
    public int Example20260824_Q120823(String message) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for(int i = 0; i<n; i++) {
            for(int j=n; j>=n-i; j--) {
                System.out.print("*");
            }
            System.out.println();
        }

    }
}
