package com.algorithm2026.programers.day014;

import java.util.*;

public class Example20260202_Q1 { //Summer/Winter Coding(~2018) 지형 편집

    int[][] land;
    int P,Q;
    int N;

    public long solution(int[][] land, int P, int Q) {
        long answer = 0;

        this.land = land;
        this.P = P;
        this.Q = Q;
        this.N = land.length;

        long end = this.land[0][0];
        long start = this.land[0][0];
        for(int i = 0; i < this.N; i++){
            for(int j = 0; j < this.N; j++){
                if(this.land[i][j] > end)
                    end = this.land[i][j];
                if(this.land[i][j] < start)
                    start = this.land[i][j];
            }
        }

        long mid;
        while(start <= end){

            mid = (start + end)/ 2;

            long leftCost = calculateCost(mid);
            long rightCost = calculateCost(mid+1);

            if(leftCost > rightCost){
                answer = rightCost;
                start = mid+1;
            }
            else{
                answer = leftCost;
                end = mid-1;
            }
        }

        return answer;
    }

    long calculateCost(long height){
        long cost = 0;
        for(int i = 0; i < this.N; i++){
            for(int j = 0; j < this.N; j++){
                if(land[i][j] > height){
                    cost += (land[i][j] - height) * Q;
                }
                else{
                    cost += (height - land[i][j]) * P;
                }
            }
        }
        return cost;
    }
}