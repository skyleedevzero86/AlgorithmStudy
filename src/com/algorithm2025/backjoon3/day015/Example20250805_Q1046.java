package com.algorithm2025.backjoon3.day015;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Example20250805_Q1046 { //Last Stone Weight

    public int lastStoneWeight(int[] stones){

        int ans = 0;
        List<Integer> list = new ArrayList<>();
        Arrays.sort(stones);

        for(int i=0; i<stones.length; i++){
            list.add(stones[i]);
        }

        for(int i=0; i<list.size(); i++){
            if(list.size()==0){
                break;
            }

            if(list.size()==1){
                ans  = list.get(0);
                break;
            }

            int y = list.get(i);
            int x = list.get(i-1);

            if(x==y){
                list.remove(i);
                list.remove(i-1);
                i--;
            }    else {
                list.remove(i);
                list.remove(i-1);
                list.add(y-x);
            }
            Collections.sort(list);
        }
        return ans;
    }
}
