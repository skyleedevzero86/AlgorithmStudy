package com.algorithm2025.backjoon3.day004;

import java.util.Scanner;

public class Example20250626_Q_L_704 { //번외 letcode 704 Binary Search
    public int search(int[] arr,int target){

    int low = 0;
    int height = arr.length-1;
    while(low<height){
        int mid = (low+height)/2;
        if(arr[mid]==target){
            return mid;
        } else if(arr[mid]<target){
            low = mid+1;
        } else {
            height = mid-1;
        }
    }

    return -1;

    }

}
