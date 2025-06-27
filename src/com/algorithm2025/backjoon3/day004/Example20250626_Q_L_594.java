package com.algorithm2025.backjoon3.day004;

import java.util.HashMap;
import java.util.Map;

public class Example20250626_Q_L_594 { //번외 letcode 594 Longest Harmonious Subsequence

    public int findLHS(int[] nums) {

        Map<Integer, Integer> map = new HashMap<>();
        int logset=0;

        for(int i=0;i<nums.length;i++){
            if(map.containsKey(nums[i])){
                map.put(nums[i],map.get(nums[i])+1);
            } else {
                map.put(nums[i],1);
            }
        }

        for(int key:map.keySet()){
            if(map.containsKey(key+1)){
                logset = Math.max(logset,map.get(key)+map.get(key+1));
            }
        }

        return logset;
    }
}
