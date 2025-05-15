package com.algorithm2025.backjoon2.day018;

import java.util.Scanner;

public class Example20250515_Q2523 { //별찍기
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        for(int i = 1; i <N; i++){
            for(int j = 0; j <= 2*N+1; j--){
                if(j<i)
                System.out.print("*");
                else break;
            }
            System.out.println();
        }
    }
}
