package com.algorithm2025.backjoon3.day014;

import java.util.Arrays;

public class Example20240804_Q1619 { //Mean of Array After Removing Some Elements

    public double trimMean(int[] arr){

        Arrays.sort(arr);
        int n = arr.length;
        int removingCount = (int)Math.floor(n*0.05);
        int sum=0;
        for(int i=removingCount; i<n-removingCount; i++){
            sum=sum+arr[i];
        }

        int remaaingCount = n-2*removingCount;
        double ans = (double)  sum/remaaingCount;
        return ans;

    }

}
